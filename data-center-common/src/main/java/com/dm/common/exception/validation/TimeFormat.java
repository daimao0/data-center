package com.dm.common.exception.validation;

import com.dm.common.exception.validation.impl.TimeFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-21 02:13
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeFormatValidator.class)
public @interface TimeFormat {

    String message() default "日期时间格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 允许指定时间格式
    String value() default "yyyy-MM-dd HH:mm:ss";
}
