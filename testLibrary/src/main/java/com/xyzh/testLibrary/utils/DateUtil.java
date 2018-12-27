package com.xyzh.testLibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liuli on 2015/11/27.
 */
public class DateUtil {

    public final static String STR_FORMAT_YYYY_MM_DD="yyyy-MM-dd";
    public final static String STR_FORMAT_NORMAL="yyyy-MM-dd hh:mm:ss";

    public final static SimpleDateFormat FORMAT_YYYY_MM_DD=new SimpleDateFormat(STR_FORMAT_YYYY_MM_DD, Locale.CHINA);
    public final static SimpleDateFormat FORMAT_NORMAL=new SimpleDateFormat(STR_FORMAT_NORMAL, Locale.CHINA);

    public final static int SECOND=1000;
    public final static int MINUTE=60*SECOND;
    public final static int HOUR=60*MINUTE;
    public final static int DAY=24*HOUR;

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */

    public static Date parse(String strDate, String pattern) {

        if (TextUtil.isEmpty(strDate)) {
            return null;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */

    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }


    public static long getResidueTimeMill(String date){
        try {
            long timeMill=FORMAT_NORMAL.parse(date).getTime();
            return timeMill-System.currentTimeMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getResidueTimeStr(String date){
        long residue=getResidueTimeMill(date);
        int s=(int)(residue%MINUTE)/SECOND;
        int m=(int)(residue% HOUR)/MINUTE;
        int h=(int)(residue% DAY)/HOUR;
        int d=(int)residue/ DAY;
        StringBuilder sb=new StringBuilder();
        if(d>0){
            sb.append(d).append("天");
        }
        if(h>0){
            sb.append(h).append("小时");
        }
        if(m>0){
            sb.append(m).append("分");
        }
        if(s>0){
            sb.append(s).append("秒");
        }
        return sb.toString();
    }


}
