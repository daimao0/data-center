package com.dm.infrastructure.convert;

import com.dm.common.enums.DatasetStatus;
import com.dm.common.enums.DatasetType;
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
                .setDatasetType(DatasetType.get(datasetPO.getDatasetType()))
                .setDatasetStatus(DatasetStatus.get(datasetPO.getStatus()))
                .setVersion(datasetPO.getVersion())
                .setManagers(datasetPO.getManagers())
                .setCreator(datasetPO.getCreator())
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
               .setDatasetType(datasetDO.getDatasetType().getCode())
               .setStatus(datasetDO.getDatasetStatus().getCode())
               .setVersion(datasetDO.getVersion())
               .setManagers(datasetDO.getManagers())
               .setCreator(datasetDO.getCreator())
               .setCreatedAt(datasetDO.getCreatedAt())
               .setUpdatedAt(datasetDO.getUpdatedAt());
    }
}
