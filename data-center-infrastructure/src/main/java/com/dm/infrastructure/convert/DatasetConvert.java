package com.dm.infrastructure.convert;

import com.dm.common.enums.DatasetStatus;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.infrastructure.db.po.DatasetPO;

/**
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 02:11
 */
public class DatasetConvert {
    public static DatasetDO toDataset(DatasetPO datasetPO) {
        if (datasetPO == null) {
            return null;
        }
        return new DatasetDO()
                .setId(datasetPO.getId())
                .setName(datasetPO.getName())
                .setDatasetStatus(DatasetStatus.get(datasetPO.getStatus()))
                .setVersion(datasetPO.getVersion())
                .setCreatedAt(datasetPO.getCreatedAt())
                .setUpdatedAt(datasetPO.getUpdatedAt());
    }

    /**
     * DO转PO
     * @param datasetDO 数据集DO
     * @return 数据集PO
     */
    public static DatasetPO toDatasetPO(DatasetDO datasetDO){
       return new DatasetPO()
               .setId(datasetDO.getId())
               .setName(datasetDO.getName())
               .setStatus(datasetDO.getDatasetStatus().getCode())
               .setVersion(datasetDO.getVersion())
               .setCreatedAt(datasetDO.getCreatedAt())
               .setUpdatedAt(datasetDO.getUpdatedAt());
    }
}
