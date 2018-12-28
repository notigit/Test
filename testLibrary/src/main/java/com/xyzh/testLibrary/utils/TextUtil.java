package com.xyzh.testLibrary.utils;

/**
 * Created by liuli on 2015/11/27.
 */
public class TextUtil {

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equalsIgnoreCase(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    public static String getColorText(String color,String text) {
//        (Html.fromHtml()

        return "<font color=\""+color+"\">" + text + "</font>";
    }
    public static String getColorText(String color,int text) {
//        (Html.fromHtml()

        return "<font color=\""+color+"\">" + text + "</font>";
    }
    public static String getColorText(String color,int size,int text) {
//        (Html.fromHtml()

        return "<font color=\""+color+"\">" + text + "</font>";
    }


}
