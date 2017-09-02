package com.csg.zhong.myecstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.csg.zhong.latte.delegates.LatteDelegate;
import com.csg.zhong.latte.net.RestClient;
import com.csg.zhong.latte.net.callback.IError;
import com.csg.zhong.latte.net.callback.IFailure;
import com.csg.zhong.latte.net.callback.ISuccess;

/**
 * Created by 王修智 on 2017-07-18-0018.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder().url("http://s1.music.126.net/download/android/CloudMusic_official_4.1.3_193341.apk")//
                .loader(getContext())//
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).name("CloudMusic_official_4.1.3_193341.apk").build().download();

    }

}
