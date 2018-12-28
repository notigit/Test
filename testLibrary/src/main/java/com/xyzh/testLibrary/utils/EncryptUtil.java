package com.xyzh.testLibrary.utils;


import java.security.MessageDigest;
import java.util.Random;

/**
 * Auther: Scott
 * Date: 2017/6/5 0005
 * E-mail:hekescott@qq.com
 */

public class EncryptUtil {
    private static StringBuilder stringBuilder = new StringBuilder("6");
    static {
        stringBuilder.append("f") ;
        stringBuilder.append("wed2").append("EPz").append("Q7fyl4w");
    }
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
   public static  String getEncyptStr(String randonStr,String str){



       String val =randonStr.substring(0,5)+stringBuilder.toString()+str;
       String md5 = encode(val);
       return md5;
   }
   public static  String getEncyptStr(String startStr,String randonStr,String secertBeforeStr,String endStr){

       String val =startStr+randonStr.substring(0,5)+secertBeforeStr+stringBuilder.toString()+endStr;
       String md5 = encode(val);
       return md5;
   }
    public static String encode(String sourceString) {
        String resultString = null;
        try {
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 进行加密
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    /**
     *
     * 方法说明:把字节数组转换成字符串.
     *
     * @param bytes
     * @return
     */
    private static final String byte2hexString(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }
}
