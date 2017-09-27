package com.ren.videococo.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ren on 2017/9/27.
 * TODO
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
                .header("X-Channel-Code", "official")
                .header("X-Client-Agent", "Xiaomi")
                .header("X-Client-Hash", "2f3d6ffkda95dlz2fhju8d3s6dfges3t")
                .header("X-Client-ID", "123456789123456")
                .header("X-Client-Version", "2.3.2")
                .header("X-Long-Token", " ")
                .header("X-Platform-Type", "0")
                .header("X-Platform-Version", "5.0")
                .header("X-Serial-Num", "1492140134")
                .header("X-User-ID", " ")
                .method(original.method(), original.body())
                .build();

        return chain.proceed(request);
    }
}
