package com.dm.domain.datasource.repository;

import com.dm.domain.datasource.model.DatasourceDO;

import java.util.List;

/**
 * 数据源存储服务
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 15:53
 */
public interface DatasourceRepository {
    /**
     * 保存数据源
     *
     * @param datasourceDO 数据源
     */
    void save(DatasourceDO datasourceDO);

    /**
     * 根据id查询数据源
     *
     * @param id id
     * @return 数据源
     */
    DatasourceDO findById(Long id);

    /**
     * 根据数据集查询数据源
     *
     * @param id 数据集id
     * @return 数据源
     */
    List<DatasourceDO> listByDatasetId(Long id);
}
