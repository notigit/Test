package com.xyzh.testLibrary.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Paul Z on 2018/7/4.
 * Description:
 * 动态选择图片尺寸版本
 * 根据尺寸比例分组储存
 * 人工升序排列每组尺寸
 * 匹配的算法都基于已经排好序的前提
 *
 */

public class ImageDimentionSelector {
    public final static HashMap<Integer,Dimention[]> map=new HashMap();
    private static Integer[] orderKeys;
    public final static boolean IS_ENABLE=true;
    public final static float STANDARD_WIDTH=720f;
    public final static int UP_VALUE=100;//为了比例取整，方便比较

    private static int width=0;

    public static void init(Context context){
        if(width==0){
            WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            width = dm.widthPixels;
            Dimention[] dims=null;
            dims=new Dimention[1];
            dims[0]=new Dimention(750,1344);
            map.put(UP_VALUE*750/1344,dims);
            dims=new Dimention[5];
            dims[0]=new Dimention(100,100);
            dims[1]=new Dimention(180,180);
            dims[2]=new Dimention(240,240);
            dims[3]=new Dimention(350,350);
            dims[4]=new Dimention(750,750);
            map.put(UP_VALUE*1/1,dims);
            dims=new Dimention[2];
            dims[0]=new Dimention(240,180);
            dims[1]=new Dimention(360,270);
            map.put(UP_VALUE*4/3,dims);
            dims=new Dimention[4];
            dims[0]=new Dimention(150,100);
            dims[1]=new Dimention(225,150);
            dims[2]=new Dimention(330,220);
            dims[3]=new Dimention(750,500);
            map.put(UP_VALUE*3/2,dims);
            dims=new Dimention[3];
            dims[0]=new Dimention(220,124);
            dims[1]=new Dimention(338,190);
            dims[2]=new Dimention(750,422);
            map.put(UP_VALUE*16/9,dims);
            dims=new Dimention[2];
            dims[0]=new Dimention(320,160);
            dims[1]=new Dimention(750,375);
            map.put(UP_VALUE*2/1,dims);
            dims=new Dimention[1];
            dims[0]=new Dimention(750,240);
            map.put(UP_VALUE*750/240,dims);
            dims=new Dimention[1];
            dims[0]=new Dimention(750,160);
            map.put(UP_VALUE*750/160,dims);

            autoFitDpi();
            sortKeys();
        }
    }

    private static void autoFitDpi(){

        float dpi=width/STANDARD_WIDTH;
        Iterator<Dimention[]> iterator=map.values().iterator();
        Dimention[] group=null;
        while (iterator.hasNext()){
            group=iterator.next();

            if(group.length==0){
                continue;
            }
            group[0].width*=dpi;
            group[0].height*=dpi;
            if(group.length>1){
                for(int i=1;i<group.length;i++){
                    group[i].width*=dpi;
                    group[i].height*=dpi;
                    group[i-1].max=(group[i].width+group[i-1].width)/2;
                    group[i].min=group[i-1].max+1;
                }
                group[group.length-1].max=Integer.MAX_VALUE;
            }
        }
    }

    private static void sortKeys(){
        orderKeys=new Integer[map.size()];
        map.keySet().toArray(orderKeys);
        Arrays.sort(orderKeys);
    }

    private static class Dimention{
        public String dimen;
        public int min;
        public int max=Integer.MAX_VALUE;
        public int height;
        public int width;

        public Dimention(int width,int height){
            this.dimen=width+""+height;
            this.height=height;
            this.width=width;
        }
    }

    public static String matchingDimen(int width,int height){
//        long time=System.currentTimeMillis();
        int scale=UP_VALUE*width/height;
        String dimen=null;
        Dimention[] target=map.get(scale);
        if(target!=null){
            dimen=matchingDimen(target,width,height);
        }else {
            Iterator<Integer> iterator=map.keySet().iterator();
            int min=0;
            int max=Integer.MAX_VALUE;
            for(int key:orderKeys) {
                if(key<scale){
                    min=key;
                }else {
                    max=key;
                    break;
                }
            }
            if(min>0){
                if(scale>=min/2+max/2){
                    scale=max;
                }else {
                    scale=min;
                }
            }else {
                scale=min;
            }
            target=map.get(scale);
            dimen=matchingDimen(target,width,height);
        }
//        Logger.d("paulz----------matchingDimen---dimen="+dimen+"---time="+(System.currentTimeMillis()-time));
        return dimen;
    }

    public static String matchingDimen(Dimention[] dimenGroup,int width,int height){
        for(Dimention dimen:dimenGroup){
            if(width<=dimen.max&&width>=dimen.min){
                return dimen.dimen;
            }
        }
        return "";
    }
}
