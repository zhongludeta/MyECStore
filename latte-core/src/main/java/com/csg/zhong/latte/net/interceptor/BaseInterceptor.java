package com.csg.zhong.latte.net.interceptor;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by 王修智 on 2017-09-05-0005.
 */

public abstract class BaseInterceptor implements Interceptor {

    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i), url.queryParameterValue(i));
        }
        return params;
    }

    protected String getUrlParameterByKey(Chain chain, String key) {
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String, String> getBodyParameters(Chain chain) {
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        final FormBody formBody = (FormBody) chain.request().body();
        int size = formBody.size();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameter(Chain chain, String key) {
        return getBodyParameters(chain).get(key);
    }

}
