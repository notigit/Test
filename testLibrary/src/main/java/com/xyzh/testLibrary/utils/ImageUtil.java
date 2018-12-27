package com.xyzh.testLibrary.utils;

/**
 * Created by Paul Z on 2018/7/20.
 * Description:
 */

public class ImageUtil {

    public static boolean isLongPic(int width,int height){
        if(width==0||height==0){
            return false;
        }

        return height>360&&height/(float)width>2.5;
    }
}
