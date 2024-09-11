package com.dm.domain.dataset.convert;

import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.measure.model.MeasureDO;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 17:17
 */
public class MeasureConvert {

    /**
     * 度量域
     *
     * @param cmd 保存参数
     * @return 度量域
     */
    public static MeasureDO toMeasureDO(DatasetSaveCmd.MeasureSaveCmd cmd) {
        return new MeasureDO()
                .setEnName(cmd.getEnName())
                .setDisplayName(cmd.getDisplayName())
                .setMeasureType(cmd.getMeasureType())
                .setVersion(0);
    }

    /**
     * 度量域列表
     *
     * @param cmd 保存参数列表
     * @return 度量域列表
     */
    public static List<MeasureDO> toMeasureDOS(List<DatasetSaveCmd.MeasureSaveCmd> cmd) {
        return cmd.stream().map(MeasureConvert::toMeasureDO).toList();
    }

}
