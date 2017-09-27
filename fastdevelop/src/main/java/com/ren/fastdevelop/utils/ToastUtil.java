package com.ren.fastdevelop.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/09/26 0026
 */

public class ToastUtil {

    private static Toast toast;

    public static void makeText(Context context, String text) {
        if (toast == null)
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setText(text);
        toast.show();
    }
}
