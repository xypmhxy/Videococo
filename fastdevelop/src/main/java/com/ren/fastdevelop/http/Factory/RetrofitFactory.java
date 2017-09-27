package com.ren.fastdevelop.http.Factory;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ren.fastdevelop.http.Config.RetrofitConfig;
import com.ren.fastdevelop.http.OkHttp.OkHttpProvider;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ren on 2017/6/29 0029
 */

public class RetrofitFactory {

    private static RetrofitFactory retrofitFactory;
    private Retrofit retrofit;

    private RetrofitFactory(RetrofitConfig config) {
        if (config == null)
            throw new NullPointerException("RetrofitConfig不可为空");

        if (TextUtils.isEmpty(config.getBaseUrl()))
            throw new RuntimeException("baseUrl不能为空");

        OkHttpClient client = OkHttpProvider.getOkHttpClient(null);
        Converter.Factory factory = getGsonConverterFactory(config.getGson());
        CallAdapter.Factory rxFactory = RxJava2CallAdapterFactory.create();

        if (config.getOkHttpClient() != null)
            client = config.getOkHttpClient();

        if (config.getFactory() != null)
            factory = config.getFactory();

        if (config.getRxFactory() != null)
            rxFactory = config.getRxFactory();
        retrofit = new Retrofit.Builder()
                .baseUrl(config.getBaseUrl())
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(rxFactory)
                .build();

    }

    private Converter.Factory getGsonConverterFactory(Gson gson) {
        if (gson == null) {
            Gson mGson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .create();
            return GsonConverterFactory.create(mGson);
        } else return GsonConverterFactory.create(gson);
    }

    public static RetrofitFactory getInstance() {
        if (retrofitFactory == null)
            throw new NullPointerException("RetrofitFactory为Null，请先调用newInstance");
        return retrofitFactory;
    }

    public static RetrofitFactory newInstance(RetrofitConfig config) {
        return retrofitFactory = new RetrofitFactory(config);
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
