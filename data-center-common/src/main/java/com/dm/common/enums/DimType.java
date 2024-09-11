package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 维度类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-22 20:59
 */
@Getter
@AllArgsConstructor
public enum DimType {

    STRING("string", "字符类型"),
    NUMBER("number", "数字类型"),
    DATE("date", "日期类型");

    private final String code;

    private final String desc;

    public static DimType get(String code) {
        for (DimType value : DimType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
