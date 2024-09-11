package com.dm.app.convert;

import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.DimVO;
import com.dm.common.enums.DimType;
import com.dm.common.utils.ConvertUtil;
import com.dm.domain.dataset.commond.DatasetSaveCmd;
import com.dm.domain.dim.model.DimDO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 02:56
 */
public class DimConvert {
    /**
     * 保存维度时类型转换
     *
     * @param dimSaveReq 维度保存参数
     * @return 类型转化
     */
    public static DimDO toDimDO(DatasetSaveReq.DimSaveReq dimSaveReq) {
        return new DimDO()
                .setEnName(dimSaveReq.getEnName())
                .setDisplayName(dimSaveReq.getDisplayName())
                .setVersion(0)
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());
    }

    /**
     * 维度VO
     *
     * @param dimDO 维度域
     * @return 维度VO
     */
    public static DimVO toDimVO(DimDO dimDO) {
        return new DimVO()
                .setEnName(dimDO.getEnName())
                .setDisplayName(dimDO.getDisplayName())
                .setDimType(dimDO.getDimType().getCode())
                .setCreatedAt(ConvertUtil.toStr(dimDO.getCreatedAt()))
                .setUpdatedAt(ConvertUtil.toStr(dimDO.getUpdatedAt()));
    }

    /**
     * 维度VO列表
     *
     * @param dimDOS 维度域列表
     * @return 维度VO
     */
    public static List<DimVO> toDimVOS(List<DimDO> dimDOS) {
        return dimDOS.stream().map(DimConvert::toDimVO).toList();
    }

    public static List<DimDO> toDimDOS(List<DatasetSaveReq.DimSaveReq> dims) {
        return dims.stream().map(DimConvert::toDimDO).toList();
    }

    public static DatasetSaveCmd.DimSaveCmd toDimSaveCmd(DatasetSaveReq.DimSaveReq dim) {
        return new DatasetSaveCmd.DimSaveCmd()
                .setEnName(dim.getEnName())
                .setDisplayName(dim.getDisplayName())
                .setDimType(DimType.get(dim.getDimType()));
    }

    public static List<DatasetSaveCmd.DimSaveCmd> toDimSaveCmds(List<DatasetSaveReq.DimSaveReq> dims) {
        return dims.stream().map(DimConvert::toDimSaveCmd).toList();
    }
}
