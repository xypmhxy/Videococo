package com.ren.fastdevelop.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.ren.fastdevelop.utils.ToastUtil;

import butterknife.ButterKnife;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Ren on 2017/09/27 0027.
 * TODO
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewId(), container, false);
        try {
            if (Class.forName("butterknife.ButterKnife") == ButterKnife.class)
                ButterKnife.bind(this, view);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser)
//            lazyLoad();
    }

    public abstract int getViewId();

    public abstract void lazyLoad();

    @Override
    public void launchActivity(Class cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    @Override
    public void launchActivityWithData(Class cls, Bundle bundle) {
        Intent intent = new Intent(mContext, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        if (getView() != null) {
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    @Override
    public void showInputMethod() {
        if (getView() != null) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(getView().getWindowToken(), 0);
        }
    }

    @Override
    public void showToast(Context context, String text) {
        ToastUtil.makeText(context, text);
    }

    @Override
    public void showLog(String log) {
        Log.e(" " + this, log);
    }

}
