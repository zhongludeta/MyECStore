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
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    /**
     * 返回配置项内各项内容的集合
     *
     * @return 配置项内各项内容的HashMap对象
     */
    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    /**
     * 按枚举对象返回配置项内各项内容的集合
     * @param key 枚举对象
     * @param <T> 返回配置项类型的泛型
     * @return 返回的配置项
     */
    public static <T> T getConfiguration(Enum<ConfigKeys> key) {
        return Configurator.getInstance().getLatteConfig(key);
    }

    /**
     * 获取APP的Application对象
     * @return
     */
    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

}
