package com.csg.zhong.latte.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.csg.zhong.latte.app.Latte;

/**
 * Created by 王修智 on 2017-08-08-0008.
 * 获取屏幕像素的工具类
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
