package fragment;

import android.content.Intent;
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
import android.widget.ImageButton;

import com.sun.budejie.CrossActivity;
import com.sun.budejie.R;
import com.sun.budejie.RedManActivity;

import java.util.ArrayList;

import Urls.Url;

/**
 * Created by Y.vn on 2016/5/6.
 */
public class EssenceFragment extends Fragment {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ArrayList<Fragment> list=new ArrayList<>();
    String[] titles={"推荐","视频","图片","段子","网红","排行","社会","美女","冷知识","游戏",};
    String[] urls={Url.URL_RECOMMENT_1,Url.URL_VIDEO_1,Url.URL_PICTURE_1,Url.URL_JOKE_1,Url.URL_NETHOT_1,Url.URL_RANK_1,Url.URL_SOCIETY_1,Url.URL_BEAUTYWOMEN_1,Url.URL_TRIVIA_1,Url.URL_GAME_1};
    private FragmentManager mManager;
    private MyAdapter adapter;
    private EssenceZiFragment ziFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.essence_fragment,container,false);

        initTabLayout(view);
        initViewPager(view);
        mTabLayout.setupWithViewPager(mViewPager);

        initListener(view);
        return view;
    }

    private void initListener(View view) {
        ImageButton iv1= (ImageButton) view.findViewById(R.id.imageButton1);
        ImageButton iv2=(ImageButton) view.findViewById(R.id.imageButton2);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RedManActivity.class));
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CrossActivity.class));
            }
        });
    }

    private void initViewPager(View view) {
        mViewPager= (ViewPager) view.findViewById(R.id.viewpager1);
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
        mTabLayout= (TabLayout) view.findViewById(R.id.tablayout1);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setSelectedTabIndicatorHeight(2);
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);

    }

    class MyAdapter extends FragmentPagerAdapter{

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
