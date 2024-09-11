package com.dm.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daimao
 * @date 2022/8/2 0:48
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(400, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    //========================文件类型错误====================================================
    FILE_FORMAT_INCORRECT(100001, "文件格式不正确,或不支持此文件格式"),
    FILE_IS_BLANK(10002, "写入数据无内容"),
    FILE_PARENT_CREATE_FAILURE(10003, "创建父级目录失败"),
    CSV_HEAD_NOT_SAME(10004, "CSV追加数据时，表头不相同"),
    //========================仓储服务错误=========================
    STORAGE_DATA_NULL(20001, "仓储数据为空"),
    //========================数据集错误=========================
    DATASET_NOT_EXIST(30001, "数据集不存在"),
    //========================数据源错误========================
    DATASOURCE_NOT_EXIST(40001, "数据源不存在");
    private final long code;

    private final String message;

}
