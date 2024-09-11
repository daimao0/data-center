package com.dm.app.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.dm.api.http.DatasetAppService;
import com.dm.api.request.DatasetBindDatasourceReq;
import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.DatasetVO;
import com.dm.app.convert.DatasetConvert;
import com.dm.common.api.ResponseCode;
import com.dm.common.enums.DataSourceType;
import com.dm.common.enums.DatasetStatus;
import com.dm.common.enums.DimType;
import com.dm.common.enums.MeasureType;
import com.dm.common.exception.BaseException;
import com.dm.common.utils.CSVUtil;
import com.dm.domain.dataset.aggregates.DatasetAgg;
import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dataset.service.DatasetAggService;
import com.dm.domain.datasource.aggregates.DatasourceAgg;
import com.dm.domain.datasource.model.DatasourceCSVDO;
import com.dm.domain.datasource.model.DatasourceDO;
import com.dm.domain.datasource.repository.DatasourceRepository;
import com.dm.domain.datasource.service.DatasourceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */
@Service
public class DatasetAppServiceImpl implements DatasetAppService {
    @Resource
    private DatasetAggService datasetAggService;
    @Resource
    private DatasourceService datasourceService;
    @Resource
    private DatasourceRepository datasourceRepository;
    @Resource
    private CSVUtil csvUtil;
    private final String numberRegex = "-?\\d+(\\.\\d+)?";

    /**
     * 获得数据集VO
     *
     * @param id 数据集id
     * @return 数据集VO
     */
    @Override
    public DatasetVO getById(Long id) {
        DatasetAgg datasetAgg = datasetAggService.findById(id);
        return DatasetConvert.toDatasetVO(datasetAgg);
    }

    /**
     * 保存数据集
     *
     * @param datasetSaveReq 数据集保存参数
     */
    @Override
    public void save(DatasetSaveReq datasetSaveReq) {
        DatasetSaveCmd cmd = DatasetConvert.toDatasetSaveCmd(datasetSaveReq);
        datasetAggService.save(cmd);
    }

    /**
     * 上传文件生成数据集
     *
     * @param file 文件
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadFileGenDataset(MultipartFile file) {
        //生成数据集保存命令
        DatasetSaveCmd datasetSaveCmd = this.toDatasetSaveCmd(file);
        //保存数据集
        DatasetAgg datasetAgg = datasetAggService.save(datasetSaveCmd);
        //绑定数据源
        DatasourceDO datasourceDO = this.toDatasourceDO(file);
        DatasourceAgg datasourceAgg = new DatasourceAgg(datasetAgg.getDatasetDO(), datasourceDO);
        datasourceAgg.datasetBindDatasource();
        //保存数据源
        datasourceService.save(datasourceAgg.getDatasourceDO());
    }


    /**
     * 绑定数据源
     *
     * @param req 参数
     */
    @Override
    public void bindDatasource(DatasetBindDatasourceReq req) {
        //todo
    }

    /**
     * 根据数据集id试跑数据
     *
     * @param id 数据集id
     * @return 试跑结果
     */
    @Override
    public List<Map<String, Object>> trial(Long id) {
        List<DatasourceDO> datasourceDOS = datasourceRepository.listByDatasetId(id);
        if (CollUtil.isNotEmpty(datasourceDOS)){
            for (DatasourceDO datasourceDO : datasourceDOS) {
                return datasourceService.trail(datasourceDO);
            }
        }
        return null;
    }


    /**
     * 生成数据集保存命令
     *
     * @param file 文件
     * @return 数据集保存命令
     */
    public DatasetSaveCmd toDatasetSaveCmd(MultipartFile file) {
        //获得文件后缀名
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        //获得数据源类型
        DataSourceType dataSourceType = DataSourceType.get(suffix);
        if (dataSourceType == null) {
            throw new BaseException(ResponseCode.FILE_FORMAT_INCORRECT);
        }
        //读存储获得表格数据
        List<Map<String, Object>> data = null;
        switch (dataSourceType) {
            case CSV -> data = csvUtil.readCSV(file);
            case MYSQL -> {
                //todo
            }
            default -> {

            }
        }
        //如果数据为空则抛出异常
        if (CollUtil.isEmpty(data)) {
            throw new BaseException(ResponseCode.STORAGE_DATA_NULL);
        }
        //获得度量和维度
        List<DatasetSaveCmd.DimSaveCmd> dimSaveCmds = new ArrayList<>();
        List<DatasetSaveCmd.MeasureSaveCmd> measureSaveCmds = new ArrayList<>();
        Map<String, Object> row = data.get(0);
        //度量维度
        row.forEach((k, v) -> {
            if (isNumber(v)) {
                DatasetSaveCmd.MeasureSaveCmd measureSaveCmd = new DatasetSaveCmd.MeasureSaveCmd()
                        .setEnName(k)
                        .setDisplayName(k)
                        .setMeasureType(MeasureType.NUMBER);
                measureSaveCmds.add(measureSaveCmd);
            } else {
                DatasetSaveCmd.DimSaveCmd dimSaveCmd = new DatasetSaveCmd.DimSaveCmd()
                        .setEnName(k)
                        .setDisplayName(k)
                        .setDimType(DimType.STRING);
                dimSaveCmds.add(dimSaveCmd);
            }
        });
        return new DatasetSaveCmd()
                .setName(file.getName())
                .setStatus(DatasetStatus.OFFLINE)
                .setMeasures(measureSaveCmds)
                .setDims(dimSaveCmds);
    }

    private boolean isNumber(Object val) {
        return val.toString().matches(numberRegex);
    }


    public DatasourceDO toDatasourceDO(MultipartFile file) {
        //获得文件后缀名
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        //获得数据源类型
        DataSourceType dataSourceType = DataSourceType.get(suffix);
        DatasourceCSVDO datasourceCSVDO = new DatasourceCSVDO();
        datasourceCSVDO.setName(file.getName());
        datasourceCSVDO.setDatasourceType(dataSourceType);
        //存储数据源路径
        List<Map<String, Object>> data = csvUtil.readCSV(file);
        String path = csvUtil.genFile(file.getName(), file.getOriginalFilename(), data, false);
        datasourceCSVDO.setPath(path);
        return datasourceCSVDO;
    }

}
