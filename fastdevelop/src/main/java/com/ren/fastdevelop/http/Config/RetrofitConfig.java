package com.ren.fastdevelop.http.Config;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/**
 * Created by Ren on 2017/9/26
 */

public class RetrofitConfig {
    private String baseUrl;
    private Converter.Factory factory;
    private CallAdapter.Factory rxFactory;
    private OkHttpClient okHttpClient;
    private Gson gson;

    public RetrofitConfig(Builder builder) {
        baseUrl = builder.baseUrl;
        factory = builder.factory;
        rxFactory = builder.rxFactory;
        okHttpClient = builder.okHttpClient;
        gson = builder.gson;
    }

    public RetrofitConfig() {
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Converter.Factory getFactory() {
        return factory;
    }

    public void setFactory(Converter.Factory factory) {
        this.factory = factory;
    }

    public CallAdapter.Factory getRxFactory() {
        return rxFactory;
    }

    public void setRxFactory(CallAdapter.Factory rxFactory) {
        this.rxFactory = rxFactory;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public static class Builder {
        private String baseUrl;
        private Converter.Factory factory;
        private CallAdapter.Factory rxFactory;
        private OkHttpClient okHttpClient;
        private Gson gson;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder converterFactory(Converter.Factory factory) {
            this.factory = factory;
            return this;
        }

        public Builder callAdapterFactory(CallAdapter.Factory rxFactory) {
            this.rxFactory = rxFactory;
            return this;
        }

        public Builder okHttpClient(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            return this;
        }

        public Builder gson(Gson gson) {
            this.gson = gson;
            return this;
        }

        public RetrofitConfig build() {
            return new RetrofitConfig(this);
        }
    }
}
