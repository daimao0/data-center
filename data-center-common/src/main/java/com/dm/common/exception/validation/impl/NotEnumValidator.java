package com.dm.common.exception.validation.impl;

import com.dm.common.exception.validation.NotEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 01:17
 */
public class NotEnumValidator implements ConstraintValidator<NotEnum, String> {
    private Class<?> clazz;
    private String method;

    @Override
    public void initialize(NotEnum constraintAnnotation) {
        this.method = constraintAnnotation.method();
        this.clazz = constraintAnnotation.clazz();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            //获得枚举的方法
            Method method = clazz.getMethod(this.method, value.getClass());
            Object val = method.invoke(clazz, value);
            return val != null;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
