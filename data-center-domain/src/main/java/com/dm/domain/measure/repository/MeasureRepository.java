package com.dm.domain.measure.repository;

import com.dm.domain.measure.model.MeasureDO;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:06
 */
public interface MeasureRepository {
    /**
     * 保存度量
     *
     * @param measureDO 度量域
     */
    void save(MeasureDO measureDO);

    /**
     * 批量保存度量
     * @param measureDOS 度量
     */
    void batchSave(List<MeasureDO> measureDOS);

    /**
     * 根据数据集id查询度量域
     * @param datasetId 数据集id
     * @return 度量域
     */
    List<MeasureDO> listByDatasetId(Long datasetId);
}
