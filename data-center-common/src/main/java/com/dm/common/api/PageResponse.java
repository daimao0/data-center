package com.dm.common.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2023-01-04 2:38 PM
 */
@Data
@Schema(title = "分页响应")
@NoArgsConstructor
public class PageResponse<T> {
    /**
     * 响应码
     */
    @Schema(title = "响应码")
    private long code;

    /**
     * 返回信息
     */
    @Schema(title = "返回信息")
    private String message;

    /**
     * 返回值
     */
    @Schema(title = "返回值")
    private Page<T> data;

    PageResponse(long code, String message, Page<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> PageResponse<T> success(Page<T> data) {
        return new PageResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }


    public static <T> PageResponse<T> success(Page<T> data, String message) {
        return new PageResponse<>(ResponseCode.SUCCESS.getCode(), message, data);
    }


    public static <T> PageResponse<T> failed(String message) {
        return new PageResponse<>(ResponseCode.FAILED.getCode(), message, null);
    }

    public static <T> PageResponse<T> failed(ResponseCode responseCode) {
        return new PageResponse<>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> PageResponse<T> unauthorized(String message) {
        return new PageResponse<>(ResponseCode.UNAUTHORIZED.getCode(), message, null);
    }


    public static <T> PageResponse<T> forbidden(String message) {
        return new PageResponse<>(ResponseCode.FORBIDDEN.getCode(), message, null);
    }

}
