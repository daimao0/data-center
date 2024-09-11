package com.dm.infrastructure.convert;

import com.dm.domain.datasource.model.DatasourceCSVDO;
import com.dm.domain.datasource.model.DatasourceDO;
import com.dm.infrastructure.db.po.DatasourceCSVPO;
import com.dm.infrastructure.db.po.DatasourcePO;

/**
 * 数据源转化器
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 16:02
 */
public class DatasourceConvert {

    public static DatasourcePO toDatasourcePO(DatasourceDO datasourceDO) {
        return new DatasourcePO()
                .setId(datasourceDO.getId())
                .setName(datasourceDO.getName())
                .setDatasetId(datasourceDO.getDatasetId())
                .setDatasourceType(datasourceDO.getDatasourceType().getCode())
                .setCreatedAt(datasourceDO.getCreatedAt())
                .setUpdatedAt(datasourceDO.getUpdatedAt());
    }

    public static DatasourceDO toDatasourceDO(DatasourceCSVPO datasourceCSVPO) {
        if (datasourceCSVPO == null) {
            return null;
        }
        return new DatasourceCSVDO()
                .setId(datasourceCSVPO.getId())
                .setPath(datasourceCSVPO.getPath())
                .setCreatedAt(datasourceCSVPO.getCreatedAt())
                .setUpdatedAt(datasourceCSVPO.getUpdatedAt());
    }

    public static DatasourceCSVPO toDatasourceCSVPO(DatasourceDO datasourceDO) {
        DatasourceCSVDO datasourceCSVDO = (DatasourceCSVDO) datasourceDO;
        return new DatasourceCSVPO()
                .setDatasourceId(datasourceDO.getId())
                .setPath(datasourceCSVDO.getPath());
    }
}
