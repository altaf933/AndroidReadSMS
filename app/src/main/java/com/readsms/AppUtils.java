package com.readsms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by altaf.h.shaikh on 1/7/2017.
 */

public class AppUtils {

    //Default date formate
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /*
    * Conver milli second into String date format
    * */
    public static String millisecToString(long milliSecond) {
        return milliseconds2String(milliSecond, SDF);
    }

    public static String milliseconds2String(long milliseconds, SimpleDateFormat format) {
        return format.format(new Date(milliseconds));
    }

}
