package com.dm.domain.datasource.aggregates;

import com.dm.common.api.ResponseCode;
import com.dm.common.exception.BaseException;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.datasource.model.DatasourceDO;
import lombok.Data;

/**
 * 数据源聚合根
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 11:03
 */
@Data
public class DatasourceAgg {
    /**
     * 数据集
     */
    private final DatasetDO datasetDO;

    /**
     * 数据源域
     */
    private final DatasourceDO datasourceDO;

    public DatasourceAgg(DatasetDO datasetDO, DatasourceDO datasourceDO) {
        this.datasetDO = datasetDO;
        this.datasourceDO = datasourceDO;
    }

    /**
     * 数据集绑定数据源
     */
    public void datasetBindDatasource() {
        if (this.datasetDO == null || this.datasetDO.getId() == null) {
            throw new BaseException(ResponseCode.DATASET_NOT_EXIST);
        }
        if (this.datasourceDO == null) {
            throw new BaseException(ResponseCode.DATASOURCE_NOT_EXIST);
        }
        this.datasourceDO.setDatasetId(this.datasetDO.getId());
    }
}
