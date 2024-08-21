package com.dm.common.exception.validation.impl;

import com.dm.common.exception.validation.TimeFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-21 02:15
 */
public class TimeFormatValidator implements ConstraintValidator<TimeFormat, String> {
    private String dateFormat;


    @Override
    public void initialize(TimeFormat constraintAnnotation) {
        this.dateFormat = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isBlank()) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        try {
            LocalDateTime.parse(value, formatter);
            return true;
        } catch (Exception e) {
            // 如果解析失败，则格式不正确
            return false;
        }
    }
}
