package com.dm.infrastructure.db.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dm.domain.measure.model.MeasureDO;
import com.dm.domain.measure.repository.MeasureRepository;
import com.dm.infrastructure.convert.MeasureConvert;
import com.dm.infrastructure.db.mapper.DatasetMeasureMapper;
import com.dm.infrastructure.db.po.DatasetMeasurePO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:13
 */
@Service
public class MeasureRepositoryImpl implements MeasureRepository {
    @Resource
    private DatasetMeasureMapper datasetMeasureMapper;

    /**
     * 保存度量
     *
     * @param measureDO 度量域
     */
    @Override
    public void save(MeasureDO measureDO) {
        DatasetMeasurePO datasetMeasurePO = MeasureConvert.toDatasetMeasurePO(measureDO);
        datasetMeasureMapper.insert(datasetMeasurePO);
    }

    /**
     * 批量保存度量
     *
     * @param measureDOS 度量
     */
    @Override
    public void batchSave(List<MeasureDO> measureDOS) {
        for (MeasureDO measureDO : measureDOS) {
            save(measureDO);
        }
    }
    /**
     * 根据数据集id查询度量域
     * @param datasetId 数据集id
     * @return 度量域
     */
    @Override
    public List<MeasureDO> listByDatasetId(Long datasetId) {
        LambdaQueryWrapper<DatasetMeasurePO> queryWrapper = new LambdaQueryWrapper<DatasetMeasurePO>()
                .eq(DatasetMeasurePO::getDatasetId,datasetId);
        List<DatasetMeasurePO> datasetMeasurePOS = datasetMeasureMapper.selectList(queryWrapper);
        return MeasureConvert.toMeasureDOS(datasetMeasurePOS);
    }
}
