package com.ren.videococo.http;


import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.CancellationException;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by _SOLID
 * Date:2016/7/27
 * Time:21:27
 */
public abstract class HttpResultSubscriberForList<T> implements SingleObserver<HttpResultForList<T>> {

    private Context context;

    public HttpResultSubscriberForList() {
    }

    public HttpResultSubscriberForList(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        _onStartRequest();
    }

    @Override
    public void onSuccess(@NonNull HttpResultForList<T> result) {
        _onSuccess(result.getContList());
    }

    @Override
    public void onError(Throwable e) {
        if (e != null) {
            //处理RxLife取消订阅的问题,这实际上并不是一个真正的错误
            if (!(e instanceof CancellationException)) {
                e.printStackTrace();
                if (e.getMessage() == null) {
                    if (context != null)
                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                    _onError(new Throwable(e.toString()));
                } else {
                    if (context != null)
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    _onError(new Throwable(e.getMessage()));
                }
            }
        } else {
            _onError(new Exception("null message"));
        }
    }

    public abstract void _onStartRequest();

    public abstract void _onSuccess(T t);

    public abstract void _onError(Throwable e);
}

