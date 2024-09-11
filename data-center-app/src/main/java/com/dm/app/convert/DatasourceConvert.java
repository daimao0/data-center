package com.dm.app.convert;

import com.dm.api.request.DatasourceSaveReq;
import com.dm.api.vo.DatasourceVO;
import com.dm.common.enums.DataSourceType;
import com.dm.common.utils.ConvertUtil;
import com.dm.domain.datasource.model.DatasourceDO;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 17:25
 */
public class DatasourceConvert {
    public static DatasourceVO toDatasourceVO(DatasourceDO datasourceDO) {
        if (datasourceDO == null) {
            return null;
        }
        return new DatasourceVO()
                .setId(datasourceDO.getId())
                .setName(datasourceDO.getName())
                .setDatasourceType(datasourceDO.getDatasourceType().getCode())
                .setCreatedAt(ConvertUtil.toStr(datasourceDO.getCreatedAt()))
                .setUpdatedAt(ConvertUtil.toStr(datasourceDO.getUpdatedAt()));
    }

    public static DatasourceDO toDatasourceDO(DatasourceSaveReq datasourceSaveReq) {
        return new DatasourceDO()
                .setName(datasourceSaveReq.getName())
                .setDatasourceType(DataSourceType.get(datasourceSaveReq.getDatasourceType()));
    }

}
