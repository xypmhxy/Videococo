package com.ren.fastdevelop.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.jaeger.library.StatusBarUtil;
import com.ren.fastdevelop.utils.ToastUtil;

/**
 * Created by Administrator on 2017/9/26
 */

public class BaseActivity extends AppCompatActivity implements IBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setStatusBarColor(int color) {
        StatusBarUtil.setColor(this, color);
    }

    @Override
    public void setStatusBarColor(int color, int alph) {
        StatusBarUtil.setColor(this, color, alph);
    }

    @Override
    public void launchActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public void launchActivityWithData(Class cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void showInputMethod() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void showToast(Context context, String text) {
        ToastUtil.makeText(context, text);
    }
}
