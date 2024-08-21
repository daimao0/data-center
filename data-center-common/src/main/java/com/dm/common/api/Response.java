package com.dm.common.api;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daimao
 * @date 2022/8/2 0:42
 */
@Data
@Schema(title = "响应")
@NoArgsConstructor
public class Response<T> {
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
    private T data;


    Response(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }


    public static <T> Response<T> success(T data, String message) {
        return new Response<>(ResponseCode.SUCCESS.getCode(), message, data);
    }


    public static <T> Response<T> failed(String message) {
        return new Response<>(ResponseCode.FAILED.getCode(), message, null);
    }

    public static <T> Response<T> validateFailed(String message) {
        return new Response<>(ResponseCode.VALIDATE_FAILED.getCode(), message, null);
    }

    public static <T> Response<T> failed(ResponseCode responseCode) {
        return new Response<>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> Response<T> failed(ResponseCode responseCode, String message) {
        return new Response<>(responseCode.getCode(), message, null);
    }


    public static <T> Response<T> unauthorized(String message) {
        return new Response<>(ResponseCode.UNAUTHORIZED.getCode(), message, null);
    }


    public static <T> Response<T> forbidden(String message) {
        return new Response<>(ResponseCode.FORBIDDEN.getCode(), message, null);
    }

    public static <T> Response<T> loginFailed(long code, String message) {
        return new Response<>(code, message, null);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
