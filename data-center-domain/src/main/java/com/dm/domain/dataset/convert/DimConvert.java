package com.dm.domain.dataset.convert;

import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dim.model.DimDO;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 17:22
 */
public class DimConvert {
    public static DimDO toDimDO(DatasetSaveCmd.DimSaveCmd cmd) {
        return new DimDO()
                .setEnName(cmd.getEnName())
                .setDisplayName(cmd.getDisplayName())
                .setDimType(cmd.getDimType())
                .setVersion(0);
    }

    public static List<DimDO> toDimDOS(List<DatasetSaveCmd.DimSaveCmd> cmd) {
        return cmd.stream().map(DimConvert::toDimDO).toList();
    }
}
