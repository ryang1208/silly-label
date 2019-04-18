package com.label.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    public static Date addTime(long second) {
        long time = System.currentTimeMillis();
        time += second * 1000;
        return new Date(time);
    }
    
}
