package com.dm.common.exception.validation;

import com.dm.common.exception.validation.impl.NotEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举类型校验
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 01:15
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEnumValidator.class)
public @interface NotEnum {

    String message() default "枚举不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举类
     *
     * @return 枚举类
     */
    Class<?> clazz();

    /**
     * 获得的枚举的方法名
     *
     * @return 枚举方法名
     */
    String method();
}
