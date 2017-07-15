package com.csg.zhong.myecstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csg.zhong.latte.app.Latte;
import com.csg.zhong.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Latte.init(this)//
                .withIcon(new FontAwesomeModule())//
                .withIcon(new FontEcModule())//
                .withApiHost("http://127.0.0.1")//
                .configure();
        setContentView(R.layout.activity_main);
    }
}
