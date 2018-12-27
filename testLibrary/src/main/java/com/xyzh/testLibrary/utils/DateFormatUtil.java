package com.xyzh.testLibrary.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author jenny
 * @date 2015/11/4.
 * @email fishloveqin@gmail.com
 * <p/>
 * 日期格式化工具类
 */
public final class DateFormatUtil {

    //构造方法私有
    private DateFormatUtil() {

    }


    /**
     * 判断当前 距离该时间是否大于一天
     *
     * @return
     */
    public static boolean comparisonTime(long cityTime) {
        // long cityTime = date.getTime();
        if (cityTime == 0) {
            return true;
        }
        long ltime = gaiPresentTime();
        long diff = ltime - cityTime;
        if (diff > 0) {
            if (diff <= (1 * 24 * 60 * 60 * 1000)) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }


    public static long gaiPresentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        long time = curDate.getTime();
        String str = formatter.format(curDate);
        return time;
    }

    /**
     * 获取当前时间HH:mm
     *
     * @return
     */
    public static String getCurrentHHmmTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param timeText
     * @return
     */
    public static final long getTime(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return -1L;
        }
        return d.getTime();
    }

    /**
     * 字符串日期转换为DATE对象
     *
     * @param timeText
     * @return
     */
    public static final Date getDate(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return new Date();
        }
        return d;
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param timeText
     * @return
     */
    public static final long getTime2(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return -1L;
        }
        return d.getTime();
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param timeText
     * @return
     */
    public static final long getLongDate(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return -1L;
        }
        return d.getTime();
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param timeText
     * @return
     */
    public static final long getTime3(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return -1L;
        }
        return d.getTime();
    }

    /**
     * 将字符串数据转化为毫秒数
     */
    public static final long getTime7(String timeStr) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(timeStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.getTimeInMillis();
    }

    /**
     * 字符串日期转换为毫秒
     *
     * @param timeText
     * @return
     */
    public static final long getTime6(String timeText) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date d = null;

        try {
            d = s.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
            d = null;
        }

        if (d == null) {
            return -1L;
        }
        return d.getTime();
    }

    /**
     * 毫秒转字符串文本 yyyy.MM.dd
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getText(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 yyyy-MM-dd
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getText8(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 yyyy.MM.dd HH:mm
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getText1(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 MM.dd
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getTextPlus2(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("MM.dd");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 MM.dd
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getTextPlus3(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("MM:dd");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 M.d
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getText2(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("M.d");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 yyyy.M.d
     *
     * @param ms M.d H:s
     * @return
     */
    public static final String getText4(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("MM.dd HH:mm");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 yyyy.M.d
     *
     * @param ms M.d H:s
     * @return
     */
    public static final String getText6(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 hh:mm
     *
     * @param ms M.d H:s
     * @return
     */
    public static final String getText7(long ms) {

        SimpleDateFormat s = new SimpleDateFormat(" HH:mm");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 毫秒转字符串文本 yyyy-MM-dd HH:mm:ss
     *
     * @param ms 毫秒
     * @return
     */
    public static final String getText3(long ms) {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        d.setTime(ms);
        String time = s.format(d);
        return time;
    }

    /**
     * 格式化时间 :显示年-月-日
     *
     * @param time
     * @return
     */
    public static final String formatTime(String time) {

        return DateFormatUtil.getText(DateFormatUtil.getTime2(time));
    }

    /**
     * 格式化时间 :显示年-月-日 时 分
     *
     * @param time
     * @return
     */
    public static final String formatTime6(String time) {

        return DateFormatUtil.getText6(DateFormatUtil.getTime6(time));
    }

    /**
     * 格式化时间 yyyy-MM-dd HH:mm:ss :显示 月.日 时:分
     *
     * @param time
     * @return
     */
    public static final String formatTime1(String time) {

        return DateFormatUtil.getText4(DateFormatUtil.getTime(time));
    }

    /**
     * 格式化时间 显示月.日
     *
     * @param time
     * @return
     */
    public static final String formatTimePlus2(String time) {

        return DateFormatUtil.getTextPlus2(DateFormatUtil.getTime(time));
    }

    /**
     * 格式化时间 显示月.日
     *
     * @param time
     * @return
     */
    public static final String formatTime2(String time) {

        return DateFormatUtil.getText2(DateFormatUtil.getTime2(time));
    }

    /**
     * 格式化时间 :  显示年.月.日
     * yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static final String formatTime3(String time) {

        return DateFormatUtil.getText(DateFormatUtil.getTime(time));
    }

    /**
     * 格式化时间 :  显示yyyy-MM-dd
     * @param time
     * @return
     */
    public static final String formatTime8(String time) {

        return DateFormatUtil.getText8(DateFormatUtil.getTime(time));
    }

    /**
     * 年-月-日 时:分:秒 格式化时间为 :  显示年.月.日 时分
     * yyyy-MM-dd HH:mm:ss 转为 2017.12.08 13:21
     *
     * @param time
     * @return
     */
    public static final String formatTime5(String time) {

        return DateFormatUtil.getText6(DateFormatUtil.getTime(time));
    }

    /**
     * 年-月-日 时:分:秒 格式化时间为 :  时:分
     * yyyy-MM-dd HH:mm:ss 转为  13:21
     *
     * @param time
     * @return
     */
    public static final String formatTime7(String time) {

        return DateFormatUtil.getText7(DateFormatUtil.getTime(time));
    }

    /**
     * 年-月-日 时:分:秒 格式化时间为 :  显示年.月.日 时分
     * yyyy-MM-dd HH:mm:ss 转为 2017.12.08 13:21
     *
     * @param time
     * @return
     */
    public static final String formatTime3Plus(String time) {

        return DateFormatUtil.getText3(DateFormatUtil.getTime(time));
    }

    /**
     * 显示活动时间
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static final String dispActiveTime(String startTime, String endTime) {

        startTime = startTime.replaceAll("-", ".");
        endTime = endTime.replaceAll("-", ".");
        if (null == startTime || startTime.length() == 0) {
            startTime = getText(System.currentTimeMillis());
        }
        if (null == endTime || endTime.length() == 0) {
            endTime = getText(System.currentTimeMillis());
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(startTime.substring(0, 10));
        stringBuffer.append("-");
        stringBuffer.append(endTime.substring(8, 11));

        return stringBuffer.toString();
    }


    /**
     * 显示活动时间
     *
     * @param time
     * @return
     */
    public static final String getFormatTime(String time) {

        time = time.replaceAll("-", ".");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(time.substring(0, time.lastIndexOf(":")));


        return stringBuffer.toString();
    }

    /**
     * yy--MM--dd
     *
     * @param createTime
     * @return
     */
    public static final String getCreateTime(String createTime) {

        return createTime.substring(0, 10);
    }

    /**
     * 显示活动时间
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static final String dispActiveTime2(String startTime, String endTime) {

        startTime = startTime.replaceAll("-", ".");
        endTime = endTime.replaceAll("-", ".");
        if (null == startTime || startTime.length() == 0) {
            startTime = getText(System.currentTimeMillis());
        }
        if (null == endTime || endTime.length() == 0) {
            endTime = getText(System.currentTimeMillis());
        }
        if (startTime.substring(0, 10).equals(endTime.substring(0, 10))) {

            return startTime.substring(0, 10);
        }


        if ("0000.00.00 00:00:00".equals(endTime)) {

            return startTime.substring(0, 10);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(startTime.substring(0, 10));
        stringBuffer.append(" - ");
        stringBuffer.append(endTime.substring(0, 10));

        return stringBuffer.toString();
    }


    /**
     * 显示活动时间
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static final String dispActiveTime3(String startTime, String endTime) {
        StringBuffer stringBuffer = new StringBuffer();
        startTime = startTime.replaceAll("-", ".");
        endTime = endTime.replaceAll("-", ".");
        if (null == startTime || startTime.length() == 0) {
            startTime = getText(System.currentTimeMillis());
        }
        if (null == endTime || endTime.length() == 0) {
            endTime = getText(System.currentTimeMillis());
        }
        if (startTime.substring(0, 10).equals(endTime.substring(0, 10))) {

            stringBuffer.append(startTime.substring(0, 10));
            stringBuffer.append("  ");
            stringBuffer.append(startTime.substring(11, startTime.length() - 3));

            stringBuffer.append("-");
            stringBuffer.append(endTime.substring(11, endTime.length() - 3));
            return stringBuffer.toString();
        }


        if ("0000.00.00 00:00:00".equals(endTime)) {

            return startTime.substring(0, startTime.length() - 3);
        }

        stringBuffer.append(startTime.substring(0, startTime.length() - 3));
        stringBuffer.append("-");
        stringBuffer.append(endTime.substring(0, endTime.length() - 3));

        return stringBuffer.toString();
    }


    public static String getFilterTime(int addTime) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MONTH, addTime);

        return simpleDateFormat.format(calendar.getTime());

    }

    /**
     * 字符串日期转换为毫秒
     * 获取当前0点时间 ,用于商旅时间旆选
     *
     * @return
     */
    public static final String getStartTime() {

        long current = System.currentTimeMillis();//当前时间毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24)
                - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        //long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒的毫秒数
        //long yesterday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;//昨天的这一时间的毫秒数
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = new Date();
        d.setTime(zero);
        String zeroTime = s.format(d);
        return zeroTime;
    }

    public static String getBeforeDay(String dateStr) {
        String result;
        int diffday = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(dateStr);
            Date date2 = new Date();
            diffday = differentDays(date1, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (diffday == 0) {
            result = "今天";
        } else {
            result = diffday + "天前";
        }

        return result;
    }

    public static int getLeftDay(String dateStr) {
        int diffday = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(dateStr);
            Date date2 = new Date();
            diffday = differentDays(date2, date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diffday;
    }

    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) //闰年
                {
                    timeDistance += 366;
                } else //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * 日期逻辑
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static String timeLogic(String dateStr) {
        long time = 0;
        if (TextUtils.isEmpty(dateStr)) {
            dateStr = "2018--01-02 12:12:12";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.DAY_OF_MONTH);
        long now = calendar.getTimeInMillis();
        Date date = strToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        calendar.setTime(date);
        long past = calendar.getTimeInMillis();

        // 相差的秒数
        time = (now - past) / 1000;

        StringBuffer sb = new StringBuffer();
        if ( time < 60) { // 1小时内
            return sb.append("刚刚").toString();
        } else if (time > 60 && time < 3600) {
            return sb.append(time / 60 + "分钟前").toString();
        } else if (time >= 3600 && time < 3600 * 24) {
            return sb.append(time / 3600 + "小时前").toString();
        } else if (time >= 3600 * 24 && time < 3600 * 48) {
            return sb.append("昨天").toString();
        } else if (time >= 3600 * 48 && time < 3600 * 72) {
            return sb.append("前天").toString();
        } else if (time >= 3600 * 72) {
            return dateToString(dateStr, DATE_FORMAT);
        }
        return dateToString(dateStr, DATE_FORMAT2);
    }


    /**
     * 日期逻辑
     * 到秒
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static String timeLogi(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.DAY_OF_MONTH);
        long now = calendar.getTimeInMillis();
        Date date = strToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        calendar.setTime(date);
        long past = calendar.getTimeInMillis();

        // 相差的秒数
        long time = (now - past) / 1000;

        StringBuffer sb = new StringBuffer();
        if (time <= 0){
            return sb.append("刚刚").toString();
        }else if (time > 0 && time < 60) { // 1小时内
            return sb.append(time + "秒前").toString();
        } else if (time > 60 && time < 3600) {
            return sb.append(time / 60 + "分钟前").toString();
        } else if (time >= 3600 && time < 3600 * 24) {
            return sb.append(time / 3600 + "小时前").toString();
        } else if (time >= 3600 * 24 && time < 3600 * 48) {
            return sb.append("昨天").toString();
        } else if (time >= 3600 * 48 && time < 3600 * 72) {
            return sb.append("前天").toString();
        } else if (time >= 3600 * 72) {
            return dateToString(dateStr, DATE_FORMAT3);
        }
        return dateToString(dateStr, DATE_FORMAT2);
    }

    /*
 * 毫秒转化时分秒
 */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            //sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }

    /*
    * 毫秒转化时分
    */
    public static String formatTimeMin(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            //sb.append(milliSecond+"毫秒");
        }
        return sb.toString();
    }

    //2018-05-31 00:00:00 转化时分
    public static String formatTimeMin(String endTimeStr) {
        long endTimeLong = getTime(endTimeStr);
        long diff = System.currentTimeMillis() - endTimeLong;
        if (diff < 0) {
            return " ";
        }
        return formatTimeMin(diff);
    }

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    private static String DATE_FORMAT2 = "yyyy-MM-dd";
    private static String DATE_FORMAT3 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转换为字符串
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static String dateToString(String timeStr, String format) {
        // 判断是否是今年
        Date date = strToDate(timeStr, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 如果是今年的话，才去“xx月xx日”日期格式
        if (calendar.get(Calendar.YEAR) == getYear()) {
            return DATE_FORMAT_TILL_SECOND.format(date);
        }

        return DATE_FORMAT_TILL_SECOND.format(date);
    }

    private static SimpleDateFormat DATE_FORMAT_TILL_SECOND = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * 日期字符串转换为Date
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date strToDate(String dateStr, String format) {
        Date date = null;

        if (!TextUtils.isEmpty(dateStr)) {
            DateFormat df = new SimpleDateFormat(format);
            try {
                date = df.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static String timeLogic(Date date) {
        long delta = new Date().getTime() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < 12L * 4L * ONE_WEEK) {
            long months = toMonths(delta);
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        } else {
            long years = toYears(delta);
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */

//  String pTime = "2012-03-12";
    public static String getWeek(String pTime) {
        String week = "周";
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            week += "日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            week += "六";
        }
        return week;
    }

}
