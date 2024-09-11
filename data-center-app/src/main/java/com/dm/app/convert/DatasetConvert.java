package com.dm.app.convert;

import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.DatasetVO;
import com.dm.api.vo.DimVO;
import com.dm.api.vo.MeasureVO;
import com.dm.common.enums.DatasetStatus;
import com.dm.common.utils.ConvertUtil;
import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dataset.aggregates.DatasetAgg;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.dim.model.DimDO;
import com.dm.domain.measure.model.MeasureDO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */

public class DatasetConvert {


    /**
     * 数据集VO
     *
     * @param datasetAgg 数据集聚合域
     * @return 数据集vo
     */
    public static DatasetVO toDatasetVO(DatasetAgg datasetAgg) {
        DatasetDO datasetDO = datasetAgg.getDatasetDO();
        List<MeasureDO> measureDOS = datasetAgg.getMeasureDOS();
        List<DimDO> dimDOS = datasetAgg.getDimDOS();
        //数据集vo
        DatasetVO datasetVO = new DatasetVO()
                .setId(datasetDO.getId())
                .setName(datasetDO.getName())
                .setStatus(datasetDO.getDatasetStatus().getCode())
                .setVersion(datasetDO.getVersion())
                .setCreatedAt(ConvertUtil.toStr(datasetDO.getCreatedAt()))
                .setUpdatedAt(ConvertUtil.toStr(datasetDO.getUpdatedAt()));
        //度量vo
        List<MeasureVO> measureVOS = MeasureConvert.toMeasureVOS(measureDOS);
        datasetVO.setMeasures(measureVOS);
        //维度VO
        List<DimVO> dimVOS = DimConvert.toDimVOS(dimDOS);
        datasetVO.setDims(dimVOS);
        return datasetVO;
    }

    public static DatasetDO toDatasetDO(DatasetSaveReq datasetSaveReq) {
        return new DatasetDO()
                .setName(datasetSaveReq.getName())
                .setDatasetStatus(DatasetStatus.get(datasetSaveReq.getStatus()))
                .setVersion(0)
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());
    }

    /**
     * 数据集保存请求参数
     *
     * @param datasetSaveReq 数据集保存请求参数
     * @return 数据集域
     */
    public static DatasetAgg toDatasetAgg(DatasetSaveReq datasetSaveReq) {
        //数据集域
        DatasetDO datasetDO = toDatasetDO(datasetSaveReq);
        //度量域
        List<MeasureDO> measureDOS = MeasureConvert.toMeasureDOS(datasetSaveReq.getMeasures());
        //维度域
        List<DimDO> dimDOS = DimConvert.toDimDOS(datasetSaveReq.getDims());
        return new DatasetAgg(datasetDO, measureDOS, dimDOS);
    }

    /**
     * 数据集保存参数
     *
     * @param datasetSaveReq 数据集保存参数
     * @return 数据集cmd
     */
    public static DatasetSaveCmd toDatasetSaveCmd(DatasetSaveReq datasetSaveReq) {
        //数据集
        DatasetSaveCmd datasetSaveCmd = new DatasetSaveCmd()
                .setName(datasetSaveReq.getName())
                .setStatus(DatasetStatus.get(datasetSaveReq.getStatus()));
        //度量
        List<DatasetSaveCmd.MeasureSaveCmd> measureSaveCmds = MeasureConvert.toMeasureSaveCmds(datasetSaveReq.getMeasures());
        datasetSaveCmd.setMeasures(measureSaveCmds);
        //维度
        List<DatasetSaveCmd.DimSaveCmd> dimSaveCmds = DimConvert.toDimSaveCmds(datasetSaveReq.getDims());
        datasetSaveCmd.setDims(dimSaveCmds);
        return datasetSaveCmd;
    }
}
