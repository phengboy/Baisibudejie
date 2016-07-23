package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.budejie.R;

import java.util.ArrayList;
import java.util.List;

import attention.AttentionFrag;
import attention.SubscriptionFrag;

/**
 * Created by pheng on 2016/5/6.
 */
public class AttentionFragment extends Fragment {
    private TabLayout mTabLayout;
    private List<Fragment> listFrags;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attention_fragment, container, false);
        //初始化TabLayout
        initTabLayout(view);
        //添加显示的fragment
        setDatas();
        //设置tabLayout的监听
        setTabListener();
        return view;
    }

    /**
     * 添加fragment（订阅/关注）
     */
    private void setDatas() {
        manager = getFragmentManager();
        listFrags = new ArrayList<>();
        listFrags.add(new SubscriptionFrag());
        listFrags.add(new AttentionFrag());
        //首次进入显示订阅界面
        manager.beginTransaction().add(R.id.framelayout_att, listFrags.get(0), "0").commit();
    }

    /**
     * 设置tablayout的监听事件，选中  订阅/关注  切换到相应的fragment
     */
    private void setTabListener() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //选中时处理的操作
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //获取不同的被点击tab的唯一标识
                int tag = Integer.parseInt(tab.getTag().toString());
                //通过tag得到对应的fragment，如果为空则为首次加载，重新添加
                Fragment curFrag = manager.findFragmentByTag(tag + "");
                if (curFrag == null) {
                    manager.beginTransaction().add(R.id.framelayout_att, listFrags.get(tag), tag + "").commit();
                }
                //判断当前点击的是哪个tab,对应显示和隐藏相应的fragment
                FragmentTransaction tran = manager.beginTransaction();
                for (int i = 0; i < listFrags.size(); i++) {
                    if (i == tag) {
                        tran.show(listFrags.get(i));
                    } else {
                        tran.hide(listFrags.get(i));
                    }
                }
                tran.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 初始化TabLayout的显示
     *
     * @param view 当前显示的view，即关注主页面
     */
    private void initTabLayout(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout3);
        mTabLayout.setSelectedTabIndicatorHeight(2);
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.sub).setTag("0"));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.attention).setTag("1"));
    }
}
