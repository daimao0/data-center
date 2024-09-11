package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 存储类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 17:13
 */
@Getter
@AllArgsConstructor
public enum StorageType {
    CSV("csv", "csv文件"),
    MYSQL("mysql", "mysql");

    private final String code;

    private final String desc;

    public static StorageType get(String code) {
        for (StorageType value : StorageType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
