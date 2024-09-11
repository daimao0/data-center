package com.dm.infrastructure.db.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dm.domain.dim.model.DimDO;
import com.dm.domain.dim.repository.DimRepository;
import com.dm.infrastructure.convert.DimConvert;
import com.dm.infrastructure.db.mapper.DimMapper;
import com.dm.infrastructure.db.po.DatasetDimPO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:12
 */
@Service
public class DimRepositoryImpl implements DimRepository {
    @Resource
    private DimMapper dimMapper;

    /**
     * 保存维度
     *
     * @param dimDO 维度域
     */
    @Override
    public void save(DimDO dimDO) {
        DatasetDimPO datasetDimPO = DimConvert.toDatasetDimPO(dimDO);
        dimMapper.insert(datasetDimPO);
    }

    @Override
    public void batchSave(List<DimDO> dimDOS) {
        for (DimDO dimDO : dimDOS) {
            save(dimDO);
        }
    }

    /**
     * 根据数据集id查询维度域
     *
     * @param datasetId 数据集id
     * @return 维度域
     */
    @Override
    public List<DimDO> listByDatasetId(Long datasetId) {
        LambdaQueryWrapper<DatasetDimPO> queryWrapper = new LambdaQueryWrapper<DatasetDimPO>()
                .eq(DatasetDimPO::getDatasetId, datasetId);
        List<DatasetDimPO> datasetDimPOS = dimMapper.selectList(queryWrapper);
        return DimConvert.toDimDOS(datasetDimPOS);
    }
}
