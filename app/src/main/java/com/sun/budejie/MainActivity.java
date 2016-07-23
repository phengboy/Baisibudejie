package com.sun.budejie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;

import application.MyApplication;
import fragment.AttentionFragment;
import fragment.EssenceFragment;
import fragment.MineFragment;
import fragment.Up_To_DateFragment;

public class MainActivity extends FragmentActivity {
    TabLayout mTabLayout;
    FragmentManager mFragmentManager;
    ArrayList<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initTabView();

        initFragmentView();

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
             public void onTabSelected(TabLayout.Tab tab) {
                int tag=Integer.parseInt(tab.getTag().toString());
                FragmentTransaction ft = mFragmentManager.beginTransaction();
                if(tag==2){
                    startActivity(new Intent(MyApplication.mContext, AddActivity.class));
                    SystemClock.sleep(1000);
                }else if(tag>2){
                    tag--;
                }
                Fragment fragment=mFragmentManager.findFragmentByTag(tag + "");
                if(fragment==null){
                    mFragmentManager.beginTransaction().add(R.id.framelayout,list.get(tag),tag+"").commit();
                }

                for(int i=0;i<list.size();i++){
                    if (i==tag){
                        ft.show(list.get(i));
                    }else{
                        ft.hide(list.get(i));
                    }
                }
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (Integer.parseInt(tab.getTag().toString()) == 2) {
                    Log.i("mlog", "reselected");
                    startActivity(new Intent(MyApplication.mContext, AddActivity.class));

                }
            }
        });
    }

    private void initFragmentView() {
        list.add(new EssenceFragment());
        list.add(new Up_To_DateFragment());
        list.add(new AttentionFragment());
        list.add(new MineFragment());
        mFragmentManager=getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.framelayout,list.get(0),"0").commit();
    }

    private void initTabView() {
        mTabLayout= (TabLayout) findViewById(R.id.tablayout);
        mTabLayout.setSelectedTabIndicatorHeight(1);
        mTabLayout.setTabTextColors(Color.BLACK, Color.RED);
        mTabLayout.addTab(mTabLayout.newTab().setText("精华").setTag(0).setIcon(R.drawable.bg1));
        mTabLayout.addTab(mTabLayout.newTab().setText("最新").setTag(1).setIcon(R.drawable.bg2));
        mTabLayout.addTab(mTabLayout.newTab().setText("").setTag(2));
        mTabLayout.addTab(mTabLayout.newTab().setText("关注").setTag(3).setIcon(R.drawable.bg3));
        mTabLayout.addTab(mTabLayout.newTab().setText("我的").setTag(4).setIcon(R.drawable.bg4));
    }
}
