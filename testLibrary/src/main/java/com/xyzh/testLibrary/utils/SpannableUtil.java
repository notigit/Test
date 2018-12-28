package com.xyzh.testLibrary.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auther: Scott
 * Date: 2017/1/5 0005
 * E-mail:hekescott@qq.com
 */

public class SpannableUtil {
    //给String设置中划线
    public static SpannableString getDelLineString(String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new StrikethroughSpan(), 0, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    //给String设置中划线 从1开始
    public static SpannableString getDelLineString(int startIdex, String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new StrikethroughSpan(), startIdex, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    //给String设置辖划线 从1开始
    public static SpannableString getUnderlineString(int startIdex, String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new UnderlineSpan(), startIdex, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getColorString(String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getColorString(String string, int start, int end, int color) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getColorString(int color, String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getColorSubString(int color, String string, String subStr) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), string.indexOf(subStr), string.indexOf(subStr) + subStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
    public static SpannableString getColorSubString(int color, SpannableString span, String subStr) {
        String spaStr = span.toString();

        span.setSpan(new ForegroundColorSpan(color), spaStr.indexOf(subStr), spaStr.indexOf(subStr) + subStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return span;
    }


    /**
     * 缩小第一个字符
     *
     * @param context context
     * @param string
     * @param sizeDp  第一个字符大小
     * @return
     */
    public static SpannableString getSpanMoneyString(Context context, String string, int sizeDp) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtils.dip2px(context, sizeDp)), 0, 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getRedpackMoneyString(Context context, String string, int sizeDp) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtils.dip2px(context, sizeDp)), 0, string.length() - 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        int color = 1;
        spannableString.setSpan(new ForegroundColorSpan(color), 0, string.length() - 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }


    public static SpannableString getSpanEmptyString(Context context, String string, int sizeDp) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtils.dip2px(context, sizeDp)), string.indexOf("\n") + 1, string.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getSpanCHMoneyString(Context context, String string, int sizeDp) {
        SpannableString spannableString = new SpannableString("￥" + string);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtils.dip2px(context, sizeDp)), 0, 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public static SpannableString getPicMixText(Context context, String text, int drawbleID) {
        Drawable drawable = context.getResources().getDrawable(drawbleID);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannable = new SpannableString(text);


        int startInt = text.indexOf("[");
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannable.setSpan(span, startInt, startInt + "[smile]".length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    static final Pattern pattern = Pattern.compile("smile");

    public static SpannableString getPicsMixText(Context context, String text, int drawbleID) {
//        Drawable drawable = context.getResources().getDrawable(drawbleID);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannable = new SpannableString(text);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
//            spannable.setSpan(new ImageSpan(context, Uri.fromFile(file)),
//                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            int startInt = text.indexOf("["); , ImageSpan.ALIGN_BASELINE
            CustomImageSpan span = new CustomImageSpan(context,drawbleID);
            spannable.setSpan(span, matcher.start(), matcher.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }


    /**
     * 大小不同的字符串
     *
     * @param context
     * @param string
     * @param subStr
     * @param sizeDp
     * @return
     */
    public static SpannableString getSpanS2LoneyString(Context context, String string, String subStr, int sizeDp) {
        SpannableString spannableString = new SpannableString(string);
        int startIndex = string.indexOf(subStr);
        spannableString.setSpan(new AbsoluteSizeSpan(DensityUtils.dip2px(context, sizeDp)), startIndex, startIndex + subStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
