package com.dm.app.convert;

import cn.hutool.core.convert.Convert;
import com.dm.api.vo.DatasetVO;
import com.dm.domain.dataset.model.entity.DatasetEntity;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */

public class DatasetConvert {
    public static DatasetVO toDatasetVO(DatasetEntity datasetEntity){
        return new DatasetVO().setId(Convert.toStr(datasetEntity.getId()));
    }

}
