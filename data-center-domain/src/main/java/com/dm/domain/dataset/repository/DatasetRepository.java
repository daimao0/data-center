package com.dm.domain.dataset.repository;

import com.dm.domain.dataset.model.entity.DatasetEntity;

/**
 * @author daimao
 * @date 2024/8/19 1:00
 */
public interface DatasetRepository {
    /**
     * 根据id查询数据集
     * @param id id
     * @return 数据集
     */
    DatasetEntity findById(Long id);
}
