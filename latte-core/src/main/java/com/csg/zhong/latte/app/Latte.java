package com.csg.zhong.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by 王修智 on 2017-07-15-0015.
 * <p>对外的工具类</p>
 */
public final class Latte {

    /**
     * 配置项初始化方法
     *
     * @param context 上下文
     * @return 配置类型对象
     */
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    /**
     * 初始化配置项，顺便返回配置项内各项内容的集合
     *
     * @return 配置项内各项内容的HashMap对象
     */
    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static <T> T getConfiguration(Enum<ConfigType> key) {
        return Configurator.getInstance().getLatteConfig(key);
    }

}
