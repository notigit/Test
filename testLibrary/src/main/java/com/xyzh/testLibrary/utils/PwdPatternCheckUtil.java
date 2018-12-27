package com.xyzh.testLibrary.utils;

/**
 * Author:Jenny
 * Date:2017/10/30
 * E-mail:fishloveqin@gmail.com
 */

public final class PwdPatternCheckUtil {


    /**
     * SM 校验字符串连续多少位是纯数字或者纯字母，默认6位(字母区分大小写)
     *
     * @param value 密码
     * @return
     */
    public static boolean simpleLetterAndNumCheck(String value) {
        //
        return simpleLetterAndNumCheck(value, 6);
    }

    /**
     * SM 校验字符串连续多少位是纯数字或者纯字母，默认6位(字母区分大小写)
     *
     * @param value  密码
     * @param length 校验长度,默认6为
     * @return
     */
    public static boolean simpleLetterAndNumCheck(String value, int length) {
        //是否不合法
        boolean isValidate = false;
        //
        int i = 0;
        //计数器
        int counter = 1;
        //
        for (; i < value.length() - 1; ) {
            //当前ascii值
            int currentAscii = Integer.valueOf(value.charAt(i));
            //下一个ascii值
            int nextAscii = Integer.valueOf(value.charAt(i + 1));
            //满足区间进行判断
            if ((rangeInDefined(currentAscii, 48, 57) || rangeInDefined(currentAscii, 65, 90) || rangeInDefined(currentAscii, 97, 122))
                    && (rangeInDefined(nextAscii, 48, 57) || rangeInDefined(nextAscii, 65, 90) || rangeInDefined(nextAscii, 97, 122))) {
                //计算两数之间差一位则为连续
                if (Math.abs((nextAscii - currentAscii)) == 1) {
                    //计数器++
                    counter++;
                } else {
                    //否则计数器重新计数
                    counter = 1;
                }
            }
            //满足连续数字或者字母
            if (counter >= length) return !isValidate;
            //
            i++;
        }

        //
        return isValidate;
    }

    /**
     * SM 判断一个数字是否在某个区间
     *
     * @param current 当前比对值
     * @param min     最小范围值
     * @param max     最大范围值
     * @return
     */
    public static boolean rangeInDefined(int current, int min, int max) {
        //
        return Math.max(min, current) == Math.min(current, max);
    }


    /**
     * SM 校验字符串连续多少位是纯数字或者纯字母，默认6位(字母区分大小写)
     *
     * @param value  密码
     * @param length 校验长度,默认6为
     * @return
     */
    public static boolean simpleNumCheck(String value, int length) {
        //是否不合法
        boolean isValidate = false;
        //
        int i = 0;
        //计数器
        int counter = 1;
        //
        for (; i < value.length() - 1; ) {
            //当前ascii值
            int currentAscii = Integer.valueOf(value.charAt(i));
            //下一个ascii值
            int nextAscii = Integer.valueOf(value.charAt(i + 1));
            //满足区间进行判断
            if ((rangeInDefined(currentAscii, 48, 57))
                    && (rangeInDefined(nextAscii, 48, 57))) {
                //计算两数之间差一位则为连续
                if (Math.abs((nextAscii - currentAscii)) == 1) {
                    //计数器++
                    counter++;
                } else if (Math.abs((nextAscii - currentAscii)) == 0) {
                    counter++;
                } else {
                    //否则计数器重新计数
                    counter = 1;
                }
            }
            //满足连续数字或者字母
            if (counter >= length) return !isValidate;
            //
            i++;
        }

        //
        return isValidate;
    }


}
