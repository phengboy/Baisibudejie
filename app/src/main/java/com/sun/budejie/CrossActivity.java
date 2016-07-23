package com.sun.budejie;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Urls.Url;
import fragment.EssenceZiFragment;

public class CrossActivity extends FragmentActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    private TextView mTextView;

    ArrayList<Fragment> list=new ArrayList<>();
    String[] titles={"全部","视频","图片","段子"};
    String[] urls={Url.URL_All_3, Url.URL_VIDEO_3, Url.URL_PICTURE_3, Url.URL_JOKE_3};
    private FragmentManager mManager;
    private MyAdapter adapter;
    private EssenceZiFragment ziFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross);

        mTextView= (TextView) findViewById(R.id.text_cross);
        initTabLayout();
        initViewPager();
        mTabLayout.setupWithViewPager(mViewPager);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initViewPager() {
        mViewPager= (ViewPager)findViewById(R.id.viewpager4);
        mManager=getSupportFragmentManager();
        for (int i=0;i<urls.length;i++){
            ziFragment=new EssenceZiFragment();
            ziFragment.setUrl(urls[i]);
            list.add(ziFragment);
        }
        adapter=new MyAdapter(mManager);
        mViewPager.setAdapter(adapter);
    }

    private void initTabLayout() {
        mTabLayout= (TabLayout) findViewById(R.id.tablayout4);
        mTabLayout.setSelectedTabIndicatorHeight(2);
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);

    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        public CharSequence getPageTitle(int position) {

            return titles[position];
        }
    }
}
