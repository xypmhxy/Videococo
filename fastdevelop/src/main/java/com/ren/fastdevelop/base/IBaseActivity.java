package com.ren.fastdevelop.base;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/09/26 0026
 */

public interface IBaseActivity {
    void setStatusBarColor(int color);

    void setStatusBarColor(int color, int alph);

    void launchActivity(Class cls);

    void launchActivityWithData(Class cls, Bundle bundle);

    void hideSoftInput();

    void showInputMethod();

    void showToast(Context context, String text);
}
