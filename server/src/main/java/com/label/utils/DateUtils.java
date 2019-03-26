package com.label.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
            "yyyyMMdd HH:mm:ss");


    public static Date addTime(long second) {
        Long time = System.currentTimeMillis();
        time += second * 1000;
        return new Date(time);
    }

}
