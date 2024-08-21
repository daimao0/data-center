package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据集类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-20 20:54
 */
@Getter
@AllArgsConstructor
public enum DatasetType {
    SQL(0, "sql数据集"),
    CSV(1, "csv数据集");
    private final Integer code;
    private final String desc;

    public static DatasetType get(Integer code) {
        for (DatasetType value : DatasetType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
