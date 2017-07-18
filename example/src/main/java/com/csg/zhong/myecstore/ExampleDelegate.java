package com.csg.zhong.myecstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.csg.zhong.latte.delegates.LatteDelegate;

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

    }
}
