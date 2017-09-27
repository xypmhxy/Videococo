package com.ren.videococo.fragment;

import android.os.Bundle;

import com.ren.fastdevelop.base.BaseFragment;
import com.ren.fastdevelop.http.Factory.RetrofitFactory;
import com.ren.fastdevelop.http.RxJava.RxJavaUtils;
import com.ren.videococo.R;
import com.ren.videococo.beans.ContList;
import com.ren.videococo.beans.Tittle;
import com.ren.videococo.http.HttpResultForList;
import com.ren.videococo.http.HttpResultSubscriberForList;
import com.ren.videococo.http.ServiceApi;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Ren on 2017/09/27 0027.
 * TODO
 */

public class ContentFragment extends BaseFragment {
    public static final String KEY_BUNDLE = "bundle";
    private Tittle mTittle;

    @Override
    public int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void lazyLoad() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTittle = bundle.getParcelable(KEY_BUNDLE);
            Single<HttpResultForList<List<ContList>>> call = RetrofitFactory.getInstance().createService(ServiceApi.class).getDetail("1", mTittle.getCategoryId());
            RxJavaUtils.startDefaultRequest(call, new HttpResultSubscriberForList<List<ContList>>() {
                @Override
                public void _onStartRequest() {

                }

                @Override
                public void _onSuccess(List<ContList> contLists) {
                    showLog("");
                }

                @Override
                public void _onError(Throwable e) {
                    showLog(e.getMessage());
                }
            });
        }
    }
}
