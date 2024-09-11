package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据集状态
 * 状态：0、未上线；1、已上线；2、编辑中（已上线）
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-20 20:57
 */
@Getter
@AllArgsConstructor
public enum DatasetStatus {
    OFFLINE("offline", "未上线"),
    ONLINE("online", "已上线"),
    EDIT("editing", "编辑中");
    private final String code;
    private final String desc;

    public static DatasetStatus get(String code) {
        for (DatasetStatus value : DatasetStatus.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
