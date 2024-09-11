package com.dm.infrastructure.convert;

import cn.hutool.core.util.StrUtil;
import com.dm.common.enums.DimType;
import com.dm.domain.dim.model.DimDO;
import com.dm.infrastructure.db.po.DatasetDimPO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:13
 */
public class DimConvert {
    public static DatasetDimPO toDatasetDimPO(DimDO dimDO) {
        return new DatasetDimPO()
                .setId(dimDO.getId())
                .setDatasetId(dimDO.getDatasetId())
                .setEnName(dimDO.getEnName())
                .setDisplayName(StrUtil.isBlank(dimDO.getDisplayName()) ? dimDO.getEnName() : dimDO.getDisplayName())
                .setDimType(dimDO.getDimType().getCode())
                .setVersion(dimDO.getVersion())
                .setCreatedAt(dimDO.getCreatedAt())
                .setUpdatedAt(dimDO.getUpdatedAt())
                .setDeletedAt(null);
    }

    public static DimDO toDimDO(DatasetDimPO datasetDimPO) {
        return new DimDO()
                .setId(datasetDimPO.getId())
                .setDatasetId(datasetDimPO.getDatasetId())
                .setEnName(datasetDimPO.getEnName())
                .setDisplayName(datasetDimPO.getDisplayName())
                .setDimType(DimType.get(datasetDimPO.getDimType()))
                .setVersion(datasetDimPO.getVersion())
                .setCreatedAt(datasetDimPO.getCreatedAt())
                .setUpdatedAt(datasetDimPO.getUpdatedAt());
    }

    public static List<DimDO> toDimDOS(List<DatasetDimPO> datasetDimPOS) {
        return datasetDimPOS.stream().map(DimConvert::toDimDO).collect(Collectors.toList());
    }
}
