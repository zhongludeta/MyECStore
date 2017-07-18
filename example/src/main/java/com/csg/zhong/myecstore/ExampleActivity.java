package com.csg.zhong.myecstore;

import com.csg.zhong.latte.activities.ProxyActivity;
import com.csg.zhong.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}
