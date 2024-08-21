package com.dm.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-21 02:34
 */
public class ConvertUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 字符串转本地时间
     *
     * @param datetimeStr 2024-08-21 02:34:00
     * @return 本地时间
     */
    public static LocalDateTime toLocalDateTime(String datetimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        return LocalDateTime.parse(datetimeStr, dateTimeFormatter);
    }

    /**
     * 字符串转本地时间
     *
     * @param datetimeStr 20240821
     * @param format yyyyMMdd
     * @return 本地时间
     */
    public static LocalDateTime toLocalDateTime(String datetimeStr,String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(datetimeStr, dateTimeFormatter);
    }
}
