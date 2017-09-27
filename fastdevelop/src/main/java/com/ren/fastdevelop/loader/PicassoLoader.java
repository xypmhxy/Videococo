package com.ren.fastdevelop.loader;

import android.content.Context;
import android.widget.ImageView;

import com.ren.fastdevelop.utils.ToastUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;

/**
 * @Description: 使用Picasso框架加载图片
 * @author: <a href="http://www.xiaoyaoyou1212.com">DAWI</a>
 * @date: 2016-12-19 15:16
 */
public class PicassoLoader implements ILoader {
    private static final String PICASSO_CACHE = "picasso-cache";

    @Override
    public void init(Context context) {
//        try {
//            Class.forName("com.bumptech.glide.Glide");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Must be dependencies Glide!");
//        }
    }

    @Override
    public void loadNet(ImageView target, String url, Options options) {
        load(getRequestManager(target.getContext()).load(url), target, options);
    }

    @Override
    public void loadResource(ImageView target, int resId, Options options) {
        load(getRequestManager(target.getContext()).load(resId), target, options);
    }

    @Override
    public void loadAssets(ImageView target, String assetName, Options options) {
        load(getRequestManager(target.getContext()).load("file:///android_asset/" + assetName), target, options);
    }

    @Override
    public void loadFile(ImageView target, File file, Options options) {
        load(getRequestManager(target.getContext()).load(file), target, options);
    }

    @Override
    public void clearMemoryCache(Context context) {
//        Picasso picasso=new Picasso.Builder(context).
    }

    @Override
    public void clearDiskCache(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (cache.exists() && cache.isDirectory()) {
            if (cache.delete())
                ToastUtil.makeText(context, "所有图片缓存清除成功");
        }
//        Glide.get(context).clearDiskCache();
    }

    private Picasso getRequestManager(Context context) {
        return Picasso.with(context);
    }

    private void load(RequestCreator request, ImageView target, Options options) {
        if (options == null) options = Options.defaultOptions();

        if (options.loadingResId != Options.RES_NONE) {
            request.placeholder(options.loadingResId);
        }
        if (options.loadErrorResId != Options.RES_NONE) {
            request.error(options.loadErrorResId);
        }
        request.into(target);
    }
}
