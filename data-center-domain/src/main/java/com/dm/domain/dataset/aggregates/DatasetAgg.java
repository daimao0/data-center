package com.dm.domain.dataset.aggregates;

import cn.hutool.core.collection.CollUtil;
import com.dm.common.api.ResponseCode;
import com.dm.common.exception.BaseException;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.datasource.aggregates.DatasourceAgg;
import com.dm.domain.dim.model.DimDO;
import com.dm.domain.measure.model.MeasureDO;
import lombok.Data;

import java.util.List;

/**
 * 数据集聚合域
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 11:20
 */
@Data
public class DatasetAgg {

    /**
     * 数据集域
     */
    private DatasetDO datasetDO;

    /**
     * 度量域
     */
    private List<MeasureDO> measureDOS;

    /**
     * 维度域
     */
    private List<DimDO> dimDOS;

    /**
     * 数据源
     */
    private DatasourceAgg datasourceAgg;

    public DatasetAgg(DatasetDO datasetDO, List<MeasureDO> measureDOS, List<DimDO> dimDOS) {
        this.datasetDO = datasetDO;
        this.measureDOS = measureDOS;
        this.dimDOS = dimDOS;
    }

    /**
     * 保存数据集聚合
     */
    public void save() {
        if (this.datasetDO.getId() == null || this.datasetDO.getId() < 0) {
            throw new BaseException(ResponseCode.DATASET_NOT_EXIST);
        }
        if (CollUtil.isNotEmpty(this.measureDOS)) {
            for (MeasureDO measureDO : this.measureDOS) {
                measureDO.setDatasetId(this.datasetDO.getId());
                measureDO.setVersion(0);
            }
        }
        if (CollUtil.isNotEmpty(this.dimDOS)) {
            for (DimDO dimDO : dimDOS) {
                dimDO.setDatasetId(this.getDatasetDO().getId());
                dimDO.setVersion(0);
            }
        }

    }

}
