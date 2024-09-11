package com.dm.domain.dim.repository;

import com.dm.domain.dim.model.DimDO;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:06
 */
public interface DimRepository {
    /**
     * 保存维度
     *
     * @param dimDO 维度域
     */
    void save(DimDO dimDO);

    /**
     * 批量保存
     *
     * @param dimDOS 维度域
     */
    void batchSave(List<DimDO> dimDOS);

    /**
     * 根据数据集id查询维度域
     *
     * @param datasetId 数据集id
     * @return 维度域
     */
    List<DimDO> listByDatasetId(Long datasetId);
}
