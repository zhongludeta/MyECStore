package com.csg.zhong.latte.net;

import com.csg.zhong.latte.app.ConfigType;
import com.csg.zhong.latte.app.Latte;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 王修智 on 2017-07-26-0026.
 */

public class RestCreator {

    private static final int TIME_OUT = 60;

    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = //
                (String) Latte.getConfiguration(ConfigType.API_HOST);
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()//
                .baseUrl(BASE_URL)//
                .client(OKHttpHolder.OK_HTTP_CLIENT)//
                .addConverterFactory(ScalarsConverterFactory.create())//
                .build();
    }

    private static final class OKHttpHolder {
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()//
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)//
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = //
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);

    }

}
