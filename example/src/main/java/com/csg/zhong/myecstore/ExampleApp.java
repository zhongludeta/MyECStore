package com.csg.zhong.myecstore;

import android.app.Application;

import com.csg.zhong.latte.app.Latte;
import com.csg.zhong.latte.ec.icon.FontEcModule;
import com.csg.zhong.latte.net.interceptor.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by 王修智 on 2017-07-18-0018.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)//
                .withIcon(new FontAwesomeModule())//
                .withIcon(new FontEcModule())//
                .withApiHost("http://127.0.0.1")//
                .withInterceptor(new DebugInterceptor("index", R.raw.test))//
                .configure();
    }
}
