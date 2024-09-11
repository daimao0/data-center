package com.dm.domain.datastorage.repository;

import com.dm.domain.datastorage.model.DataStorageCSVDO;

/**
 * 数据源存储CSV
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 11:50
 */
public interface DataStorageCSVRepository {
    /**
     * 根据数据存储id查询csv类型的数据存储
     *
     * @param storageId 存储id
     * @return csv类型的存储
     */
    DataStorageCSVDO findByDataStorageId(Long storageId);
}
