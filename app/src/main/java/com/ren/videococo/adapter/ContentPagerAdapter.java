package com.ren.videococo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ren.videococo.R;
import com.ren.videococo.beans.Tittle;

import java.util.List;

/**
 * Created by Ren on 2017/09/27 0027.
 * TODO
 */

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<Tittle> mTittle;
    private Context context;

    public ContentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<Tittle> tittle,Context context) {
        super(fm);
        mFragments = fragments;
        mTittle = tittle;
        this.context =context;
        Log.e("rq", context + "rrrr");
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String text = mTittle.get(position).getName();
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(mTittle.get(position).getColor()));
        spannableString.setSpan(colorSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableString;

//        return mTittle.get(position).getName();
    }

    public View getTabView(int position) {
        Log.e("rq", context + "vvvaaa");
        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.text_layout);
        tv.setText(getPageTitle(position));
        return view;
    }

}
