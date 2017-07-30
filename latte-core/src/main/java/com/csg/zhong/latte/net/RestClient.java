package com.csg.zhong.latte.net;

import com.csg.zhong.latte.net.callback.IError;
import com.csg.zhong.latte.net.callback.IFailure;
import com.csg.zhong.latte.net.callback.IRequest;
import com.csg.zhong.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by 王修智 on 2017-07-18-0018.
 * 网络请求框架
 * 设计模式：建造者模式
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    /**
     * 构造方法，初始化私有常量。
     *
     * @param url     地址
     * @param params  参数
     * @param request 请求始末
     * @param success 请求成功
     * @param failure 请求失败
     * @param error   请求错误
     * @param body    请求体
     */
    public RestClient(String url,//
                      WeakHashMap<String, Object> params,//
                      IRequest request,//
                      ISuccess success,//
                      IFailure failure,//
                      IError error,//
                      RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

}
