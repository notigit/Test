package com.xyzh.testLibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;

import java.io.File;

/**
 * Created by jeff on 2016/5/25.
 */
public class SystemInvoker {
    public static final int PICTURE_REQUEST_CAMERA = 1;// 拍照
    public static final int PICTURE_REQUEST_GALLERY = 2;// 从相册中选择
    public static final int PICTURE_REQUEST_CUT = 3;// 结果

    public static void launchDailPage(Context context, String phoneNumber) {
        // 1）直接拨打
        //Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        //startActivity(intentPhone);

        // 2）跳转到拨号界面
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void viewPicturePySystem(Activity activity, File file) {
        Intent it =new Intent(Intent.ACTION_VIEW);
        it.setDataAndType(Uri.fromFile(file), "image/*");
        activity.startActivity(it);
    }

    /**
     * 选择提示对话框
     */
    public static void showPickDialog(final Activity activity, String title, final Uri savedUri) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
//                .setNegativeButton("相册", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        Intent intent = new Intent(Intent.ACTION_PICK);
//                        intent.setDataAndType(
//                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                                "image/*");
//                        intent.putExtra("return-data", false);
//                        activity.startActivityForResult(intent, PICTURE_REQUEST_GALLERY);
//
//                    }
//                })
                .setPositiveButton("拍照", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        /**
                         * 下面这句还是老样子，调用快速拍照功能，至于为什么叫快速拍照，大家可以参考如下官方
                         * 文档，you_sdk_path/docs/guide/topics/media/camera.html
                         * 我刚看的时候因为太长就认真看，其实是错的，这个里面有用的太多了，所以大家不要认为
                         * 官方文档太长了就不看了，其实是错的
                         * MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
                         * MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
                         * MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
                         * MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。
                         */
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //下面这句指定调用相机拍照后的照片存储的路径
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, savedUri);
                        activity.startActivityForResult(intent, PICTURE_REQUEST_CAMERA);
                    }
                }).show();
    }

    public static void showPictureCrop(Activity activity, Uri pictrueUri, Bundle cropParams, Uri output) {
        /*
         * 至于下面这个Intent的ACTION是怎么知道的，大家可以看下自己路径下的如下网页
		 * yourself_sdk_path/docs/reference/android/book_line_content_list/Intent.html
		 */
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(pictrueUri, "image/*");
        if(cropParams != null) {
            intent.putExtras(cropParams);
        }
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);//// 输出文件
        intent.putExtra("crop", "true");
        intent.putExtra("return-data", false);// 不返回缩略图
        activity.startActivityForResult(intent, SystemInvoker.PICTURE_REQUEST_CUT);
    }
}
