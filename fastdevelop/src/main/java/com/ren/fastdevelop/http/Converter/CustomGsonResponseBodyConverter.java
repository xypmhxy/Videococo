package com.ren.fastdevelop.http.Converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2017/9/21
 */

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private ResultMode mode;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, ResultMode mode) {
        this(gson, adapter);
        this.mode = mode;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            if (mode != null) {
                JSONObject jsonObject = new JSONObject(response);
                if (!jsonObject.getString(mode.getCodeKey()).equals(mode.getCode())) {
                    throw new RuntimeException(jsonObject.optString(mode.getMsgKey()));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
