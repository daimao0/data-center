package com.dm.infrastructure.convert;

import com.dm.domain.dataset.model.entity.DatasetEntity;
import com.dm.infrastructure.db.po.DatasetPO;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 02:11
 */
public class DatasetConvert {
    public static DatasetEntity toDataset(DatasetPO datasetPO) {
        if (datasetPO == null) {
            return null;
        }
        return new DatasetEntity()
                .setId(datasetPO.getId());
    }
}
