package com.ren.videococo.application;

import android.app.Application;

import com.ren.fastdevelop.http.Config.RetrofitConfig;
import com.ren.fastdevelop.http.Converter.CustomGsonConverterFactory;
import com.ren.fastdevelop.http.HttpApplication;
import com.ren.fastdevelop.http.OkHttp.OkHttpProvider;
import com.ren.videococo.http.HeaderInterceptor;

/**
 * Created by Ren on 2017/9/27.
 * TODO
 */

public class VideoApplication extends HttpApplication {
    @Override
    public RetrofitConfig getRetrofitConfig() {
        return new RetrofitConfig.Builder()
                .baseUrl("http://app.pearvideo.com/clt/jsp/v2/")
//                .baseUrl("http://171.217.92.174:17816/AirClass/interface/video/")
                .okHttpClient(OkHttpProvider.getOkHttpClient(new HeaderInterceptor()))
                .converterFactory(CustomGsonConverterFactory.create())
                .callAdapterFactory(null)
                .build();
    }
}
