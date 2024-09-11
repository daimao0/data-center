package com.dm.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据存储的上传方式
 */
@Getter
@AllArgsConstructor
public enum UploadMethod {
    /**
     * 覆盖
     */
    COVER("cover","cover"),
    /**
     * 追加
     */
    APPEND("append","append");

    private final String code;

    private final String desc;

    public UploadMethod get(String code){
        for (UploadMethod value : UploadMethod.values()) {
            if (value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
}
