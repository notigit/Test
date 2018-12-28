package com.xyzh.testLibrary.utils;

import android.text.TextUtils;

/**
 * Author:Jenny
 * Date:2017/6/5
 * E-mail:fishloveqin@gmail.com
 */

public final class DeviceUtil {

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        String brand = android.os.Build.BRAND;
        if (TextUtils.isEmpty(brand)) {
            brand = "未知";
        }
        return brand;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        String model = android.os.Build.MODEL;

        if (TextUtils.isEmpty(model)) {

            model = "未知";
        }
        return model.trim();
    }
}
