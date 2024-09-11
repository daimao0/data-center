package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据源类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 16:22
 */
@Getter
@AllArgsConstructor
public enum DataSourceType {
    CSV("csv", "csv数据源"),
    MYSQL("mysql", "mysql数据源");
    private final String code;
    private final String desc;

    public static DataSourceType get(String code) {
        for (DataSourceType value : DataSourceType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
