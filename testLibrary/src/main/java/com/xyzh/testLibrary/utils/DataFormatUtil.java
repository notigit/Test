package com.xyzh.testLibrary.utils;

import java.text.DecimalFormat;

/**
 * 数字数据格式话
 * Auther: Scott
 * Date: 2017/9/15 0015
 * E-mail:hekescott@qq.com
 */

public class DataFormatUtil {
    /**
     * 0.00的str转为0.0 str
     *
     * @param doubleStr
     * @return
     */
    public static String getOneDoubleStr(String doubleStr) {

        DecimalFormat df = new DecimalFormat("0.0");
        if (TextUtil.isEmpty(doubleStr)) {
            return "0.0";
        }
        String str = df.format(Double.parseDouble(doubleStr));
        if (".0".equals(str.trim())) {
            return "0.0";
        }
        return str;
    }


    /**
     * 0.0的str转为0.00 str
     *
     * @param doubleStr
     * @return
     */
    public static String getTwoDoubleStr(String doubleStr) {

        DecimalFormat df = new DecimalFormat("0.00");
        if (TextUtil.isEmpty(doubleStr)) {
            return "0.00";
        }
        String str = df.format(Double.parseDouble(doubleStr));
        if (".0".equals(str.trim())) {
            return "0.00";
        }
        return str;
    }

    public static String getFormatMoney(String money) {

        if (money.indexOf(".") >= 0) {

            money = money + "0";
        }
        if (money.indexOf(".00") >= 0) {

            money = money.substring(0, money.indexOf("."));
            return money;
        }

        return getTwoDoubleStr(money);


    }
}
