package com.dm.domain.dataset.service;

import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dataset.aggregates.DatasetAgg;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 11:41
 */
public interface DatasetAggService {
    /**
     * 数据集域
     *
     * @param id 数据集id
     * @return 数据集域
     */
    DatasetAgg findById(Long id);

    /**
     * 保存数据集
     * @param datasetSaveCmd 数据集保存参数
     */
    DatasetAgg save(DatasetSaveCmd datasetSaveCmd);
}
