package com.dm.infrastructure.convert;

import cn.hutool.core.util.StrUtil;
import com.dm.common.enums.MeasureType;
import com.dm.domain.measure.model.MeasureDO;
import com.dm.infrastructure.db.po.DatasetMeasurePO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:13
 */
public class MeasureConvert {

    public static DatasetMeasurePO toDatasetMeasurePO(MeasureDO measureDO) {
        return new DatasetMeasurePO()
                .setId(measureDO.getId())
                .setDatasetId(measureDO.getDatasetId())
                .setEnName(measureDO.getEnName())
                .setDisplayName(StrUtil.isBlank(measureDO.getDisplayName()) ? measureDO.getEnName() : measureDO.getDisplayName())
                .setMeasureType(measureDO.getMeasureType().getCode())
                .setVersion(measureDO.getVersion())
                .setCreatedAt(measureDO.getCreatedAt())
                .setUpdatedAt(measureDO.getUpdatedAt())
                .setDeletedAt(null);
    }

    public static MeasureDO toMeasureDO(DatasetMeasurePO datasetMeasurePO) {
        return new MeasureDO()
                .setId(datasetMeasurePO.getId())
                .setDatasetId(datasetMeasurePO.getDatasetId())
                .setEnName(datasetMeasurePO.getEnName())
                .setDisplayName(datasetMeasurePO.getDisplayName())
                .setMeasureType(MeasureType.get(datasetMeasurePO.getMeasureType()))
                .setVersion(datasetMeasurePO.getVersion())
                .setCreatedAt(datasetMeasurePO.getCreatedAt())
                .setUpdatedAt(datasetMeasurePO.getUpdatedAt());
    }

    public static List<MeasureDO> toMeasureDOS(List<DatasetMeasurePO> datasetMeasurePOS) {
        return datasetMeasurePOS.stream().map(MeasureConvert::toMeasureDO).collect(Collectors.toList());
    }
}
