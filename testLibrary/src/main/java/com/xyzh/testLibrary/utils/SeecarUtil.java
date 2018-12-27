package com.xyzh.testLibrary.utils;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Auther: Scott
 * Date: 2017/12/11 0011
 * E-mail:hekescott@qq.com
 */

public class SeecarUtil {
    public static void seecarColorView(View layout, TextView colorTextView, String outColor, String inColor){
        TextView lookingTv =  colorTextView;
        StringBuilder lookingStr = new StringBuilder("");
        if(TextUtil.isEmpty(outColor)&&TextUtil.isEmpty(inColor)) {
            layout.setVisibility(View.GONE);
        }else {
            layout.setVisibility(View.VISIBLE);
        }
        if(!TextUtil.isEmpty(outColor)){

            lookingStr.append("外观: <font color=\"#323539\">" +outColor + "</font>"+"\t\t");
        }
        if(!TextUtil.isEmpty(inColor)){
            lookingStr.append(" 内饰: <font color=\"#323539\">" +inColor+ "</font>");
        }
        lookingTv.setText(Html.fromHtml(lookingStr.toString()));
    }
    public static void seecarColorView(TextView textView, String value ){
        TextView lookingTv =  textView;
        StringBuilder lookingStr = new StringBuilder("");
        if(TextUtil.isEmpty(value)) {
            lookingTv.setVisibility(View.GONE);
        }else {
            lookingTv.setVisibility(View.VISIBLE);
        }
        if(!TextUtil.isEmpty(value)){

            lookingStr.append("外观: <font color=\"#323539\">" +value + "</font>");
        }
        lookingTv.setText(Html.fromHtml(lookingStr.toString()));
    }
    public static void seecarColorImage(Context context, ImageView colorImage, String colorValue){
        if(TextUtil.isEmpty(colorValue)){
            colorImage.setVisibility(View.INVISIBLE);
        }
    }

}
