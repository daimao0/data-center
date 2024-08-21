package com.dm.common.exception;

import com.dm.common.api.ResponseCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 20:37
 */
@Setter
@Getter
public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -331394379665444736L;

    private ResponseCode responseCode;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
        this.responseCode = ResponseCode.FAILED;
    }

    public BaseException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public BaseException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

}
