package com.xyzh.testLibrary.utils;

import java.text.DecimalFormat;

/**
 * Author:Jenny
 * Date:2017/5/6
 * E-mail:fishloveqin@gmail.com
 */

public final class NumFormatUtil {

    /**
     * 保留两位小数
     *
     * @param var
     * @return
     */
    public static double getFmtTwoNum(double var) {

        //方案二:
        DecimalFormat df = new DecimalFormat("#.##");
        double result = Double.parseDouble(df.format(var));

        return result;
    }


    /**
     * 保留两位小数
     *
     * @param var
     * @return
     */
    public static String getFmtMoneyTwoNum(double var) {
        //方案二:
        DecimalFormat df = new DecimalFormat("#.##");
        double result = Double.parseDouble(df.format(var));
        String value = result + "";
        int index = value.indexOf(".");
        String temp = "";
        if (index >= 0) {
            temp = value.substring(index + 1, value.length());
            if (temp.length() == 2) {
                return value;
            } else {
                value = result + "0";
            }
        }

        return value;
    }


    /**
     * 保留1位小数
     *
     * @param var
     * @return
     */
    public static double getFmtOneNum(double var) {

        //方案二:
        DecimalFormat df = new DecimalFormat("#.#");
        double result = Double.parseDouble(df.format(var));

        return result;
    }

    /**
     * 保留整数
     *
     * @param var
     * @return
     */
    public static double getFmtNum(double var) {

        //方案二:
        DecimalFormat df = new DecimalFormat("#");
        double result = Double.parseDouble(df.format(var));

        return result;
    }
    public static float getRatingNum(String ratingNum) {

        return getFmtString(ratingNum);
    }

    /**
     * 保留整数 四舍五入
     *
     * @return
     */
    public static int getFmtString(String numStr) {

        if (TextUtil.isEmpty(numStr)) {
            return 0;
        }
        float numFloat = Float.parseFloat(numStr);
        return (int) (numFloat + 0.5);
    }
    /**
     *
     * 如果有小数取整再加0.5,int强转为整数
     * @return
     */
    public static float getRatingScore(float numStr) {
        float result=0;
        double floorScore = Math.floor(numStr);
        result =(int) ((numStr-floorScore)==0?numStr: (floorScore + 0.5));
        return result;
    }
    public static float getRatingScore(String numStr) {
        double numFloat = Double.parseDouble(numStr);
        float result=0;
        double floorScore = Math.floor(numFloat);
        result =(int) ((numFloat-floorScore)==0?numFloat: (floorScore + 0.5));
        return result;
    }
}
