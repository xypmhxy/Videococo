package com.ren.fastdevelop.http;

import android.app.Application;

import com.ren.fastdevelop.http.Config.RetrofitConfig;
import com.ren.fastdevelop.http.Factory.RetrofitFactory;


/**
 * Created by Ren on 2017/9/26
 */

public abstract class HttpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.newInstance(getRetrofitConfig());
    }

    public abstract RetrofitConfig getRetrofitConfig();
}
