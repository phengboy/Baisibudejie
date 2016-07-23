package sub_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sun.budejie.R;

import java.util.ArrayList;
import java.util.List;

import Urls.Url;
import application.MyApplication;
import fragment.EssenceZiFragment;

/**
 * Created by pheng on 2016/5/11.
 */
public class SubActivity extends FragmentActivity {
    private ImageView iv_item_sub;
    private TabLayout tb_item_sub;
    private List<Fragment> list_sub;
    private FragmentManager mFragmentManager;
    private int position;
    private String imageUrl;
    private Toolbar toolbar;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sub_click_item);
        getIntentDatas();
        initView();
        setTabLayout();
    }

    private void getIntentDatas() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        imageUrl = intent.getStringExtra("imageUrl");
        title = intent.getStringExtra("title");
    }

    private void setTabLayout() {
        addTab();
        addFrags();
        setListener();
    }

    private void addTab() {
        tb_item_sub.addTab(tb_item_sub.newTab().setText(R.string.cnew).setTag("0"));
        tb_item_sub.addTab(tb_item_sub.newTab().setText(R.string.hot).setTag("1"));
    }

    private void setListener() {
        tb_item_sub.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tag = Integer.parseInt(tab.getTag().toString());

                Fragment fragment = mFragmentManager.findFragmentByTag(tag + "");
                if (fragment == null) {
                    mFragmentManager.beginTransaction().add(R.id.framelayout_sub, list_sub.get(tag), tag + "").commit();
                }
                FragmentTransaction ft = mFragmentManager.beginTransaction();
                for (int i = 0; i < list_sub.size(); i++) {
                    if (i == tag) {
                        ft.show(list_sub.get(i));
                    } else {
                        ft.hide(list_sub.get(i));
                    }
                }
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void addFrags() {
        list_sub = new ArrayList<>();
        EssenceZiFragment cNewFrag = new EssenceZiFragment();
        cNewFrag.setUrl(Url.URL_SUB_ITEM[position][0]);
        list_sub.add(cNewFrag);
        EssenceZiFragment hotFrag = new EssenceZiFragment();
        hotFrag.setUrl(Url.URL_SUB_ITEM[position][1]);
        list_sub.add(hotFrag);
        mFragmentManager.beginTransaction().add(R.id.framelayout_sub, list_sub.get(0), "0").commit();

    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.sub_item_toolbar);
        iv_item_sub = (ImageView) findViewById(R.id.iv1_item_sub);
        tb_item_sub = (TabLayout) findViewById(R.id.tl_title);
        mFragmentManager = getSupportFragmentManager();
        setToolBar();
        setHeadImage();
    }

    private void setToolBar() {
        toolbar.setTitle(title);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case android.R.id.home:
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    private void setHeadImage() {
        ViewGroup.LayoutParams layoutParams = iv_item_sub.getLayoutParams();
        layoutParams.height = MyApplication.mScreenHeight * 2 / 7;
        iv_item_sub.setLayoutParams(layoutParams);
        if (position > 0) {
            Picasso.with(MyApplication.mContext)
                    .load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(iv_item_sub);
        }
    }


}
