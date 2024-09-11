package com.dm.domain.datasource.service;

import com.dm.domain.datasource.model.DatasourceDO;

import java.util.List;
import java.util.Map;

/**
 * 数据源聚合服务
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-10 20:56
 */
public interface DatasourceService {
    /**
     * 保存数据源
     *
     * @param datasourceDO 数据源
     */
    void save(DatasourceDO datasourceDO);

    /**
     * 数据源试跑
     *
     * @param datasourceDO 数据源域
     * @return 试跑结果
     */
    List<Map<String, Object>> trail(DatasourceDO datasourceDO);
}
