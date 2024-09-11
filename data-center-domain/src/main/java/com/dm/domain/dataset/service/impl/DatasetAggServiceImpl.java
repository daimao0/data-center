package com.dm.domain.dataset.service.impl;

import com.dm.common.api.ResponseCode;
import com.dm.common.exception.BaseException;
import com.dm.domain.dataset.aggregates.DatasetAgg;
import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dataset.convert.DatasetConvert;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.dataset.repository.DatasetRepository;
import com.dm.domain.dataset.service.DatasetAggService;
import com.dm.domain.dim.model.DimDO;
import com.dm.domain.dim.repository.DimRepository;
import com.dm.domain.measure.model.MeasureDO;
import com.dm.domain.measure.repository.MeasureRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 11:49
 */
@Service
public class DatasetAggServiceImpl implements DatasetAggService {
    @Resource
    private DatasetRepository datasetRepository;
    @Resource
    private MeasureRepository measureRepository;
    @Resource
    private DimRepository dimRepository;

    /**
     * 数据集域
     *
     * @param id 数据集id
     * @return 数据集域
     */
    @Override
    public DatasetAgg findById(Long id) {
        DatasetDO datasetDO = datasetRepository.findById(id);
        if (datasetDO == null) {
            throw new BaseException(ResponseCode.DATASET_NOT_EXIST);
        }
        List<MeasureDO> measureDOS = measureRepository.listByDatasetId(datasetDO.getId());
        List<DimDO> dimDOS = dimRepository.listByDatasetId(datasetDO.getId());
        return new DatasetAgg(datasetDO, measureDOS, dimDOS);
    }

    /**
     * 保存数据集
     *
     * @param datasetSaveCmd 数据集保存参数
     */
    @Override
    public DatasetAgg save(DatasetSaveCmd datasetSaveCmd) {
        //数据集聚合域
        DatasetAgg datasetAgg = DatasetConvert.toDatasetAgg(datasetSaveCmd);
        //保存数据集
        datasetRepository.save(datasetAgg.getDatasetDO());
        datasetAgg.save();
        //保存度量
        measureRepository.batchSave(datasetAgg.getMeasureDOS());
        //todo 保存指标
        //保存维度
        dimRepository.batchSave(datasetAgg.getDimDOS());
        return findById(datasetAgg.getDatasetDO().getId());
    }
}
