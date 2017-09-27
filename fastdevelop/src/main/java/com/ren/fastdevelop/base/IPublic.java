package com.ren.fastdevelop.base;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by Ren on 2017/09/27 0027.
 * TODO
 */

public interface IPublic {
    void launchActivity(Class cls);

    void launchActivityWithData(Class cls, Bundle bundle);

    void hideSoftInput();

    void showInputMethod();

    void showToast(Context context, String text);

    void showLog(String log);
}
