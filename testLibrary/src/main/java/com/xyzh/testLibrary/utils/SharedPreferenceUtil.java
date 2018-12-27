package com.xyzh.testLibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Auther: Scott
 * Date: 2017/1/20 0020
 * E-mail:hekescott@qq.com
 */

public class SharedPreferenceUtil {
    private static final String spFile = "moto";
    private static final String KEY_SP_EXHIBID = "exhibitid";
    private static final String KEY_SP_BRANDLIST = "branlist";
    private static final String KEY_SP_SEARCHLIST = "search";
    private static final String KEY_SP_IASKSEARCHLIST = "iask_search";
    private static final String KEY_SP_ISEECAR = "seecarname";
    private static final String KEY_SP_ISBACK = "isback";
    private static final String KEY_SP_CITYLIST = "citylist";//城市列表
    private static final String KEY_SP_LOCATION = "location"; //定位城市
    private static final String KEY_SP__CITYTIME = "citytime"; //获取城市列表时间
    private static final String KEY_SP__UPDATEURL = "updateurl"; //更新下载地址
    private static final String KEY_SP__UPDATESHOW = "updateshowl"; //更新下载地址
    private static final String KEY_SP__UPDATEUVER = "updatever"; //获取城市列表时间
    private static final String KEY_SP__EASE_USERNAME = "ease_username"; //获取城市列表时间
    private static final String KEY_SP__EASE_USERATTACHED = "ease_userattached"; //获取城市列表时间
    private static final String KEY_SP_ISVIBRATE = "isvibrate";//是否震动
    private static final String KEY_SP_ISVOICE = "isvoice";//是否声音
    private static final String KEY_SP_ISCHAT_NOTI = "ischat_noti";//是否私聊
    private static final String KEY_SP_NEW_FANS = "is_new_fans";//是否是新粉丝
    private static final String KEY_SP_COMMENT_REPLY = "is_comment_reply";//是否评论和回复
    private static final String KEY_SP_ZAN = "is_zan";//是否赞
    private static final String KEY_SP_NIGHT_MODE = "is_night_mode";//是否夜间模式
    private static final String KEY_SP_CONTACTS = "is_contacts";//允许匹配手机通讯录
    private static final String KEY_SP_CONTACTS_ADD = "is_contacts_add";//允许手机通讯录加我好友
    private static final String KEY_SP_MAIN_PAGE = "is_main_page";//个人主页仅向好友开放
    private static final String KEY_SP_CHAT = "is_chat";//允许我未关注的人跟我私聊
    private static final String KEY_SP_NEAR = "is_near";//对附近的人可见
    private static final String KEY_SP_SAVE_PHOTO = "is_save_photo";//允许他人保存我的照片
    private static final String KEY_SP_HINT = "is_hint";//允许我未关注的人@我

    public static final String KEY_SP_THREAD_ID = "thread_id";//提交申请时的id
    private static final String KEY_SP_APPLY_ID = "apply_id";//提交审核后返回的申请id
    private static SharedPreferenceUtil inStance;
    private static SharedPreferences mSharedPreferences;
    private static final String KEY_SP_FIRST_RAP = "is_firstrap";//是否第一次抢单
    private static final String KEY_SP_FIRSTAPP = "firstapp";//是否第一次启动
    private static final String KEY_SP_SHOWHOMEFULL= "homefull";//是否首页全屏广告
    private static final String KEY_SP_STARTPAGE = "startpage";//允许我未关注的人@我
    private static final String KEY_SP_LOGINOTHER= "loginother";//是否首页全屏广告
    private static final String KEY_IS_FIRST_SHOW_CAR_GUIDE= "is_first_show_car_guide";//是否首页全屏广告
    private static final String KEY_IS_FIRST_SHOW_STORE_CAR_GUIDE= "is_first_show_store_car_guide";//店内车翻页提示
    private SharedPreferenceUtil() {
    }

    ;
    public static int getThreadId(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getInt(KEY_SP_THREAD_ID, -1);
    }

    public static void putThreadId(Context context, int value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(KEY_SP_THREAD_ID, value);
        ed.commit();
    }
    public static int getApplyId(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getInt(KEY_SP_APPLY_ID, 0);
    }

    public static void putApplyId(Context context, int value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(KEY_SP_APPLY_ID, value);
        ed.commit();
    }

    public static String getKeyValue(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static void putKeyValue(Context context, String key, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(key, value);
        ed.commit();
    }

    public static void removeKey(Context context, String key) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.remove(key);
        ed.commit();
    }

    public static int getExhibitId(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getInt(KEY_SP_EXHIBID, 0);
    }

    private static synchronized SharedPreferences getSharedPreferences(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = context.getApplicationContext().getSharedPreferences(spFile, Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }

    public static void putExhibitId(Context context, int value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(KEY_SP_EXHIBID, value);
        ed.commit();
    }

    public static void putBrandlist(Context context, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_BRANDLIST, value);
        ed.commit();
    }

    public static String getBrandlist(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(KEY_SP_BRANDLIST, "");
    }

    public static String getCitylist(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(KEY_SP_CITYLIST, "");
    }

    public static void putCitylist(Context context, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_CITYLIST, value);
        ed.commit();
    }
    public static String getStartpageUrl(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(KEY_SP_STARTPAGE, "");
    }

    public static void setStartpageUrl(Context context, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_STARTPAGE, value);
        ed.commit();
    }

    public static String getLocation(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(KEY_SP_LOCATION, "");
    }

    public static void putLocation(Context context, String value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_LOCATION, value);
        ed.commit();
    }

    public static Long getUpdateShow(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getLong(KEY_SP__UPDATESHOW,0);
    }

    public static void setUpdateShow(Context context, long value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putLong(KEY_SP__UPDATESHOW, value);
        ed.commit();
    }

    public static String getUpdateVer(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(KEY_SP__UPDATEUVER, "");
    }

    public static void putUpdateVer(Context context, String value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP__UPDATEUVER, value);
        ed.commit();
    }

    public static long getCityTime(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getLong(KEY_SP__CITYTIME, 0);
    }

    public static void putCityTime(Context context, long value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putLong(KEY_SP__CITYTIME, value);
        ed.commit();
    }

    public static boolean getIsJpush(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getBoolean(KEY_SP_ISEECAR, false);
    }

    public static void setIsJpush(Context context, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_ISEECAR, value);
        ed.commit();
    }

//    public static boolean getIsBack(Context context) {
//        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
//        return sp.getBoolean(KEY_SP_ISBACK, false);
//    }

//    public static void setIsBack(Context context, boolean value) {
//        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed = sp.edit();
//        ed.putBoolean(KEY_SP_ISBACK, value);
//        ed.commit();
//    }

    public static void putEaseaUserName(Context context, String value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP__EASE_USERNAME, value);
        ed.commit();
    }

    public static String getEaseaUserName(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(KEY_SP__EASE_USERNAME, "");
    }

    public static void putEaseAttached(Context context, String value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP__EASE_USERATTACHED, value);
        ed.commit();
    }

    public static String getEaseAttached(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(KEY_SP__EASE_USERATTACHED, "");
    }

    public static boolean getIsVibrate(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_ISVIBRATE, true);
    }

    public static void setIsVibrate(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_ISVIBRATE, value);
        ed.commit();
    }

    public static boolean getIsVoice(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_ISVOICE, true);
    }

    public static void setIsVoice(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_ISVOICE, value);
        ed.commit();
    }

    public static boolean getIsChatNoti(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_ISCHAT_NOTI, true);
    }

    public static void setIsChatNoti(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_ISCHAT_NOTI, value);
        ed.commit();
    }

    public static boolean getIsNewFans(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_NEW_FANS, true);
    }

    public static void setIsNewFans(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_NEW_FANS, value);
        ed.commit();
    }

    public static boolean getIsCommentReply(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_COMMENT_REPLY, true);
    }

    public static void setIsCommentReply(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_COMMENT_REPLY, value);
        ed.commit();
    }

    public static boolean getIsZan(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_ZAN, true);
    }

    public static void setIsZan(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_ZAN, value);
        ed.commit();
    }

    public static boolean getNightMode(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_NIGHT_MODE, true);
    }

    public static void setNightMode(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_NIGHT_MODE, value);
        ed.commit();
    }

    public static boolean getContacts(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_CONTACTS, true);
    }

    public static void setContacts(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_CONTACTS, value);
        ed.commit();
    }

    public static boolean getContactsAdd(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_CONTACTS_ADD, true);
    }

    public static void setContactsAdd(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_CONTACTS_ADD, value);
        ed.commit();
    }

    public static boolean getMainPage(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_MAIN_PAGE, true);
    }

    public static void setMainPage(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_MAIN_PAGE, value);
        ed.commit();
    }

    public static boolean getChat(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_CHAT, true);
    }

    public static void setChat(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_CHAT, value);
        ed.commit();
    }

    public static boolean getNear(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_NEAR, true);
    }

    public static void setNear(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_NEAR, value);
        ed.commit();
    }

    public static boolean getSavePhoto(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_SAVE_PHOTO, true);
    }

    public static void setSavePhoto(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_SAVE_PHOTO, value);
        ed.commit();
    }

    public static boolean getHint(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_HINT, true);
    }

    public static void setHint(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_HINT, value);
        ed.commit();
    }

    private static String KEY_SP_TFID = "exhibitid";
    private static String KEY_SP_DISTRIBUTEIDID = "distributeId";

    public static int getTFId(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getInt(KEY_SP_TFID, 1);
    }

    public static void putTFId(Context context, int value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(KEY_SP_TFID, value);
        ed.commit();
    }

    public static int getDistributeId(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getInt(KEY_SP_DISTRIBUTEIDID, 1);
    }

    public static void putDistributeId(Context context, int value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt(KEY_SP_DISTRIBUTEIDID, value);
        ed.commit();
    }

    public static void putSearchHistory(Context context, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_SEARCHLIST, value);
        ed.commit();
    }

    public static String getSearchHistory(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(KEY_SP_SEARCHLIST, "");
    }
    public static void putIaskSearchHistory(Context context, String value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP_IASKSEARCHLIST, value);
        ed.commit();
    }

    public static String getIaskSearchHistory(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(KEY_SP_IASKSEARCHLIST, "");
    }
    public static void setIsFirstRap(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_FIRST_RAP, value);
        ed.commit();
    }
    public static boolean getIsFirstRap(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_FIRST_RAP, true);
    }
    public static void setIsFirstAPP(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_FIRSTAPP, value);
        ed.commit();
    }
    public static boolean getIsFirstAPP(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_FIRSTAPP, true);
    }
    public static void showHomeAd(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_SHOWHOMEFULL, value);
        ed.commit();
    }
    public static boolean getshowHomeAd(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_SHOWHOMEFULL, true);
    }
    public static String getUpdateUrl(Context context) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        return sp.getString(KEY_SP__UPDATEURL, "");
    }

    public static void putUpdateUrl(Context context, String value) {
        SharedPreferences sp = context.getSharedPreferences(spFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(KEY_SP__UPDATEURL, value);
        ed.commit();
    }
    public static void loginOther(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_SP_LOGINOTHER, value);
        ed.commit();
    }
    public static boolean getloginOther(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_SP_LOGINOTHER, false);
    }

    public static boolean isFirstShowCarGuide(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_IS_FIRST_SHOW_CAR_GUIDE, true);
    }
    public static void setIsFirstShowCarGuide(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_IS_FIRST_SHOW_CAR_GUIDE, value);
        ed.commit();
    }

    public static boolean isFirstShowStoreCarGuide(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(KEY_IS_FIRST_SHOW_STORE_CAR_GUIDE, true);
    }
    public static void setIsFirstShowStoreCarGuide(Context context, boolean value) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean(KEY_IS_FIRST_SHOW_STORE_CAR_GUIDE, value);
        ed.commit();
    }
}
