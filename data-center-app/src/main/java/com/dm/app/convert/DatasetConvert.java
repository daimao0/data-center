package com.dm.app.convert;

import cn.hutool.core.convert.Convert;
import com.dm.api.command.DatasetSaveCmd;
import com.dm.api.vo.DatasetVO;
import com.dm.common.enums.DatasetStatus;
import com.dm.common.enums.DatasetType;
import com.dm.domain.dataset.model.DatasetDO;

import java.time.LocalDateTime;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */

public class DatasetConvert {
    public static DatasetVO toDatasetVO(DatasetDO datasetDO) {
        if (datasetDO == null) {
            return null;
        }
        return new DatasetVO()
                .setId(Convert.toStr(datasetDO.getId()))
                .setName(datasetDO.getName());
    }

    public static DatasetDO toDatasetDO(DatasetSaveCmd datasetSaveCmd) {
        return new DatasetDO()
                .setName(datasetSaveCmd.getName())
                .setDatasetType(DatasetType.get(datasetSaveCmd.getDatasetType()))
                .setDatasetStatus(DatasetStatus.get(datasetSaveCmd.getStatus()))
                .setCreator(datasetSaveCmd.getCreator())
                .setManagers(datasetSaveCmd.getManagers())
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(LocalDateTime.now());
    }
}
