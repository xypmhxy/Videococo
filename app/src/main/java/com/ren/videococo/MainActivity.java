package com.ren.videococo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ren.fastdevelop.base.BaseActivity;
import com.ren.fastdevelop.http.Factory.RetrofitFactory;
import com.ren.fastdevelop.http.RxJava.RxJavaUtils;
import com.ren.videococo.adapter.ContentPagerAdapter;
import com.ren.videococo.beans.Tittle;
import com.ren.videococo.fragment.ContentFragment;
import com.ren.videococo.http.HttpResult;
import com.ren.videococo.http.HttpResultSubscriber;
import com.ren.videococo.http.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        getTittle();
    }

    private void getTittle() {
        final Single<HttpResult<List<Tittle>>> tittle = RetrofitFactory.getInstance().createService(ServiceApi.class).getTittle();
        RxJavaUtils.startDefaultRequest(tittle, new HttpResultSubscriber<List<Tittle>>() {
            @Override
            public void _onStartRequest() {

            }

            @Override
            public void _onSuccess(List<Tittle> tittles) {
                showLog("");
                List<Fragment> fragments = new ArrayList<>();
//                int colors[] = new int[tittles.size()];
                for (int i = 0; i < tittles.size(); i++) {
                    ContentFragment fragment = new ContentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(ContentFragment.KEY_BUNDLE, tittles.get(0));
                    fragment.setArguments(bundle);
                    fragments.add(fragment);
//                    colors[i] = Color.parseColor(tittles.get(i).getColor());
                }
//                int[][] states = new int[6][];
//                tabLayout.setTabTextColors(new ColorStateList(states, colors));
                ContentPagerAdapter pagerAdapter = new ContentPagerAdapter(getSupportFragmentManager(), fragments, tittles,MainActivity.this);
                viewPager.setAdapter(pagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    TabLayout.Tab tab = tabLayout.getTabAt(i);
                    if (tab != null) {
                        tab.setCustomView(pagerAdapter.getTabView(i));
                        if (tab.getCustomView() != null) {
                            View tabView = (View) tab.getCustomView().getParent();
                            tabView.setTag(i);
//                            tabView.setOnClickListener(mTabOnClickListener);
                        }
                    }
                }
            }

            @Override
            public void _onError(Throwable e) {
                showLog("");
            }
        });
    }
}
