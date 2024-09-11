package com.dm.app.convert;

import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.MeasureVO;
import com.dm.common.enums.MeasureType;
import com.dm.common.utils.ConvertUtil;
import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.measure.model.MeasureDO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 02:41
 */
public class MeasureConvert {
    public static MeasureDO toMeasureDO(DatasetSaveReq.MeasureSaveReq measureSaveReq) {
        return new MeasureDO()
                .setEnName(measureSaveReq.getEnName())
                .setDisplayName(measureSaveReq.getDisplayName())
                .setVersion(0)
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());
    }

    public static List<MeasureDO> toMeasureDOS(List<DatasetSaveReq.MeasureSaveReq> reqs) {
        return reqs.stream().map(MeasureConvert::toMeasureDO).toList();
    }

    public static MeasureVO toMeasureVO(MeasureDO measureDO) {
        return new MeasureVO()
                .setEnName(measureDO.getEnName())
                .setDisplayName(measureDO.getDisplayName())
                .setMeasureType(measureDO.getMeasureType().getCode())
                .setCreatedAt(ConvertUtil.toStr(measureDO.getCreatedAt()))
                .setUpdatedAt(ConvertUtil.toStr(measureDO.getUpdatedAt()));
    }

    public static List<MeasureVO> toMeasureVOS(List<MeasureDO> measureDOS) {
        return measureDOS.stream().map(MeasureConvert::toMeasureVO).toList();
    }

    public static DatasetSaveCmd.MeasureSaveCmd toMeasureSaveCmd(DatasetSaveReq.MeasureSaveReq measureSaveReq) {
        return new DatasetSaveCmd.MeasureSaveCmd()
                .setEnName(measureSaveReq.getEnName())
                .setDisplayName(measureSaveReq.getDisplayName())
                .setMeasureType(MeasureType.get(measureSaveReq.getMeasureType()));
    }

    public static List<DatasetSaveCmd.MeasureSaveCmd> toMeasureSaveCmds(List<DatasetSaveReq.MeasureSaveReq> measures) {
        return measures.stream().map(MeasureConvert::toMeasureSaveCmd).toList();
    }
}
