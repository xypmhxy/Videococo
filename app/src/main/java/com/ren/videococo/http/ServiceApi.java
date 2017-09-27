package com.ren.videococo.http;

import com.ren.videococo.beans.ContList;
import com.ren.videococo.beans.Tittle;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ren on 2017/9/27.
 * TODO
 */

public interface ServiceApi {
    @GET("getCategorys.jsp")
    Single<HttpResult<List<Tittle>>> getTittle();

    @POST("getCategoryConts.jsp")
    @FormUrlEncoded
    Single<HttpResultForList<List<ContList>>> getDetail(@Field("hotPageidx") String hotPageidx, @Field("categoryId") String categoryId);
}
