package com.ren.fastdevelop.http.Converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Ren on 2017/9/21
 */

public class CustomGsonConverterFactory extends Converter.Factory {

    private final Gson gson;
    private ResultMode mode;

    public static CustomGsonConverterFactory create() {
        return create(new Gson(), null);
    }

    public static CustomGsonConverterFactory create(Gson gson, ResultMode mode) {
        return new CustomGsonConverterFactory(gson, mode);
    }

    private CustomGsonConverterFactory(Gson gson, ResultMode mode) {
        if (null == gson) {
            throw new NullPointerException("gson is null");
        }
        this.gson = gson;
        this.mode = mode;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        if (mode != null)
            return new CustomGsonResponseBodyConverter<>(gson, adapter, mode);
        return new CustomGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(gson, adapter);
    }

}
