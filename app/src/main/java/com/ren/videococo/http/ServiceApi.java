package com.ren.videococo.http;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Ren on 2017/9/27.
 * TODO
 */

public interface ServiceApi {
    @GET("getCategorys.jsp")
    @Headers({"X-Channel-Code:official", "X-Client-Agent:Xiaomi", "X-Client-Hash:2f3d6ffkda95dlz2fhju8d3s6dfges3t"
            , "X-Client-ID:123456789123456", "X-Client-Version:2.3.2", "X-Serial-Num:1492140134"
            , "X-Long-Token: ", "X-Platform-Type:0", "X-Platform-Version:5.0", "X-User-ID: "})
    Single<HttpResult<String>> getList();
}
