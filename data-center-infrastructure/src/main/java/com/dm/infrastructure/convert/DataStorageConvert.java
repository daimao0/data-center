package com.dm.infrastructure.convert;

import com.dm.domain.datastorage.model.DataStorageCSVDO;
import com.dm.domain.datastorage.model.DataStorageDO;
import com.dm.infrastructure.db.po.DataStorageCSVPO;
import com.dm.infrastructure.db.po.DataStoragePO;

/**
 * 数据存储转化
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 16:29
 */
public class DataStorageConvert {

    public static DataStorageCSVDO toDataStorageCSVDO(DataStorageCSVPO dataStorageCSVPO){
        if (dataStorageCSVPO==null){
            return null;
        }
        return new DataStorageCSVDO()
                .setId(dataStorageCSVPO.getId())
                .setDataStorageId(dataStorageCSVPO.getDataStorageId())
                .setPath(dataStorageCSVPO.getPath())
                .setCreatedAt(dataStorageCSVPO.getCreatedAt())
                .setUpdatedAt(dataStorageCSVPO.getUpdatedAt());
    }

    public static DataStoragePO toDataStoragePO(DataStorageDO dataStorageDO){
        return new DataStoragePO()
                .setDatasourceId(dataStorageDO.getDatasourceId())
                .setStorageType(dataStorageDO.getStorageType().getCode())
                .setCreatedAt(dataStorageDO.getCreatedAt())
                .setUpdatedAt(dataStorageDO.getUpdatedAt());

    }

    public static DataStorageCSVPO toDataStorageCSVPO(DataStorageCSVDO dataStorageCSVDO) {
        return new DataStorageCSVPO()
                .setId(dataStorageCSVDO.getId())
                .setDataStorageId(dataStorageCSVDO.getDataStorageId())
                .setPath(dataStorageCSVDO.getPath())
                .setCreatedAt(dataStorageCSVDO.getCreatedAt())
                .setUpdatedAt(dataStorageCSVDO.getUpdatedAt());
    }
}

