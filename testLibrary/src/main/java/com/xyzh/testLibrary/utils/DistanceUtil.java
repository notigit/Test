package com.xyzh.testLibrary.utils;

import java.math.BigDecimal;

/**
 * Auther: Scott
 * Date: 2017/11/2 0002
 * E-mail:hekescott@qq.com
 */

public class DistanceUtil {

    /**
     * km不足.足千米时，保留一位小数，2.不足km，显示m
     *
     * @param distance 单位km
     * @return
     */
    public static String getDistance(double distance) {
        try {
            if (distance < 1) {
                return ((int) (distance * 1000)) + "m";
            } else {
                String tmp = distance + "";
                if (!TextUtil.isEmpty(tmp)) {
                    if (tmp.length() > 1) {
                        return NumFormatUtil.getFmtOneNum(distance) + "km";
                    }
                }
            }
            return " ";
        } catch (Exception e) {
            e.printStackTrace();
            return " ";
        }
    }

    /**
     * 足千米时，保留一位小数，2.不足km，显示m
     *
     * @param distanceStr 单位km
     * @return
     */
    public static String getDistance(String distanceStr) {
        try {
            double distance = Double.parseDouble(distanceStr);
            if (distance < 1) {
                return ((int) (distance * 1000)) + "m";
            } else {
                String tmp = distance + "";
                if (!TextUtil.isEmpty(tmp)) {
                    if (tmp.length() > 1) {
                        return NumFormatUtil.getFmtOneNum(distance) + "km";
                    }
                }
            }
            return 0 + "m";
        } catch (Exception e) {
            e.printStackTrace();
            return 0 + "m";
        }
    }

}
