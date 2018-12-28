package com.xyzh.testLibrary.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/**
 * Created by Paul Z on 2018/4/26.
 * Description:
 */

public class AnimUtil {

    public static void startAnim(Drawable drawable, int durationMillis){
        if(drawable instanceof TransitionDrawable){
            ((TransitionDrawable) drawable).startTransition(durationMillis);
        }
    }

    public static void reverseAnim(Drawable drawable, int durationMillis){
        if(drawable instanceof TransitionDrawable){
            ((TransitionDrawable) drawable).reverseTransition(durationMillis);
        }
    }
}
