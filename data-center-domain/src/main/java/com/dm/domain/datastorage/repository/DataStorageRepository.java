package com.dm.domain.datastorage.repository;

import com.dm.domain.datastorage.model.DataStorageDO;

import java.util.List;

/**
 * 数据仓储
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 11:25
 */
public interface DataStorageRepository {
    /**
     * 根据storage的主键Id
     *
     * @param dataStorageDO 数据仓储
     * @return 数据仓储
     */
    List<DataStorageDO> listDataStorageDO(DataStorageDO dataStorageDO);

    /**
     * 保存数据仓储
     *
     * @param dataStorageDO 数据仓储
     */
    void save(DataStorageDO dataStorageDO);
}
