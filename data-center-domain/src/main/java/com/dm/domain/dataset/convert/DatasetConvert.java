package com.dm.domain.dataset.convert;

import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dataset.aggregates.DatasetAgg;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.dim.model.DimDO;
import com.dm.domain.measure.model.MeasureDO;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 17:08
 */
public class DatasetConvert {
    /**
     * 保存数据集域
     * 保存数据集版本默认为0
     *
     * @param datasetSaveCmd 数据集保存参数
     * @return 数据集域
     */
    public static DatasetDO toDatasetDO(DatasetSaveCmd datasetSaveCmd) {
        return new DatasetDO()
                .setName(datasetSaveCmd.getName())
                .setDatasetStatus(datasetSaveCmd.getStatus())
                .setVersion(0);
    }


    /**
     * 保存数据集域
     *
     * @param cmd 参数
     * @return 数据集聚合域
     */
    public static DatasetAgg toDatasetAgg(DatasetSaveCmd cmd) {
        //数据集
        DatasetDO datasetDO = toDatasetDO(cmd);
        //数据集度量
        List<DatasetSaveCmd.MeasureSaveCmd> measures = cmd.getMeasures();
        List<MeasureDO> measureDOS = MeasureConvert.toMeasureDOS(measures);
        //数据集维度
        List<DatasetSaveCmd.DimSaveCmd> dims = cmd.getDims();
        List<DimDO> dimDOS = DimConvert.toDimDOS(dims);
        return new DatasetAgg(datasetDO, measureDOS, dimDOS);
    }
}
