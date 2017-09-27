package com.ren.fastdevelop.http.RxJava;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/30
 */

public class RxJavaUtils {
    public static <T> void startDefaultRequest(Single<T> single, SingleObserver<T> subscriber) {
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
