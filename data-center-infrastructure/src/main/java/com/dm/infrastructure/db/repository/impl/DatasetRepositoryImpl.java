package com.dm.infrastructure.db.repository.impl;

import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.dataset.repository.DatasetRepository;
import com.dm.infrastructure.convert.DatasetConvert;
import com.dm.infrastructure.db.mapper.DatasetMapper;
import com.dm.infrastructure.db.po.DatasetPO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 02:07
 */
@Component
public class DatasetRepositoryImpl implements DatasetRepository {
    @Resource
    private DatasetMapper datasetMapper;

    @Override
    public DatasetDO findById(Long id) {
        DatasetPO datasetPO = datasetMapper.selectById(id);
        return DatasetConvert.toDataset(datasetPO);
    }

    /**
     * 数据集保存
     *
     * @param datasetDO 数据集领域
     */
    @Override
    public void save(DatasetDO datasetDO) {
        DatasetPO datasetPO = DatasetConvert.toDatasetPO(datasetDO);
        datasetMapper.insert(datasetPO);
        datasetDO.setId(datasetPO.getId());
    }
}
