package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.budejie.R;

import java.util.ArrayList;

import Urls.Url;

/**
 * Created by Y.vn on 2016/5/6.
 */
public class Up_To_DateFragment extends Fragment {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    ArrayList<Fragment> list=new ArrayList<>();
    String[] titles={"全部","视频","图片","段子","网红","美女","冷知识","游戏","声音"};
    String[] urls={Url.URL_ALL_2,Url.URL_VIDEO_2,Url.URL_PICTURE_2,Url.URL_JOKE_2,Url.URL_NETHOT_2,Url.URL_BEAUTYWOMEN_2,Url.URL_TRIVIA_2,Url.URL_GAME_2,Url.URL_VOICE_2};
    private FragmentManager mManager;
    private MyAdapter adapter;
    private EssenceZiFragment ziFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.uptodate_fragment,container,false);
/*
        TextView tv = (TextView) view.findViewById(R.id.biaoti);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/lishu.ttf");
        tv.setTypeface(face);*/
        initTabLayout(view);
        initViewPager(view);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }

    private void initViewPager(View view) {
        mViewPager= (ViewPager) view.findViewById(R.id.viewpager2);
        mManager=getFragmentManager();
        for (int i=0;i<urls.length;i++){
             ziFragment=new EssenceZiFragment();
            ziFragment.setUrl(urls[i]);
            list.add(ziFragment);
        }
        adapter=new MyAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    private void initTabLayout(View view) {
        mTabLayout= (TabLayout) view.findViewById(R.id.tablayout2);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
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
