package com.csg.zhong.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Interceptor;

/**
 * Created by 王修智 on 2017-07-15-0015.
 * <p>配置信息的存储和获取</p>
 */
public class Configurator {

    /**
     * 用于储存APP通用参数的各项内容
     */
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    /**
     * 用于储存字体库
     */
    private static final List<IconFontDescriptor> ICONS = new ArrayList<>();

    /**
     * 拦截器
     */
    private static final List<Interceptor> INTERCEPTORS = new ArrayList<>();

    /**
     * 私有构造方法（单例模式）
     */
    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
    }

    /**
     * 返回保存各项参数的HashMap对象
     *
     * @return 保存各项参数的HashMap对象
     */
    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    /**
     * 根据具体枚举类型名字得到配置项参数
     *
     * @param key 配置项名字
     * @param <T> 配置项类型的泛型
     * @return 具体配置项对象
     */
    @SuppressWarnings("unchecked")
    final <T> T getLatteConfig(Enum<ConfigKeys> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key);
    }

    /**
     * 单例模式getInstance方法
     *
     * @return Configurator对象
     */
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 单例模式所需的Holder私有静态内部类
     */
    private static class Holder {
        /**
         * 全局唯一Configurator实例
         */
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 完成Configurator对象初始化的标记，并且初始化字体库
     */
    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    /**
     * 设置服务器主机域名
     *
     * @param host 主机域名
     * @return Configurator对象
     */
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    /**
     * 初始化字体库方法
     */
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 添加字体库方法
     *
     * @param descriptor 字体参数
     * @return Configurator对象
     */
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(List<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    /**
     * 检查Configurator初始化是否完毕，未完毕则抛出异常
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, please call method ‘configure’.");
        }
    }

}
