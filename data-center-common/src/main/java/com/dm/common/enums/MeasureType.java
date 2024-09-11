package com.dm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 度量类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-08 22:39
 */
@Getter
@AllArgsConstructor
public enum MeasureType {

    NUMBER("number", "数字类型"),
    RATIO("ratio", "百分比类型");

    private final String code;

    private final String desc;

    public static MeasureType get(String code) {
        for (MeasureType value : MeasureType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
