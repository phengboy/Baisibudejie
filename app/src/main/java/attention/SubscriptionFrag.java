package attention;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.sun.budejie.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import Urls.Url;
import adapter.SubAdapter;
import application.MyApplication;
import bean.SubBean;
import sub_activity.SubActivity;
import utils.MyGsonTask;

/**
 * Created by pheng on 2016/5/9.
 */
public class SubscriptionFrag extends Fragment {
    private ListView lv_sub;
    private List<SubBean.RecTagsBean> listSub;
    private SubAdapter mAdapter;
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sub_fragment, container, false);
        //初始化控件
        initViews(view);
        //添加数据
        initDatas();
        //初始化adapter
        initAdapter();
        //更新数据

        return view;
    }

    private void setLVListener() {
        MyApplication.logI("click  click    click");

        lv_sub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Intent intent = new Intent(MyApplication.mContext, SubActivity.class);
                    intent.putExtra("imageUrl", listSub.get(position - 1).getImage_detail());
                    intent.putExtra("position", position - 1);
                    intent.putExtra("title", listSub.get(position - 1).getTheme_name());
                    startActivity(intent);
                }
            }
        });
    }


    /**
     * 初始化adapter
     */
    private void initAdapter() {
        mAdapter = new SubAdapter(listSub);
        lv_sub.setAdapter(mAdapter);

    }

    /**
     * 初始化数据
     * 通过联网获取数据
     */
    private void initDatas() {
        listSub = new ArrayList<>();
        new MyGsonTask<SubBean>(new MyGsonTask.DoBackListener<SubBean>() {

            @Override
            public void onBack(SubBean subBean) {
                listSub.addAll(subBean.getRec_tags());
                mAdapter.notifyDataSetChanged();
            }
        }, SubBean.class).executeOnExecutor(Executors.newFixedThreadPool(4), Url.URL_SUBSCRIPTION);


    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initViews(View view) {
        lv_sub = (ListView) view.findViewById(R.id.lv_sub);
        TextView tv_head = new TextView(getContext());
        tv_head.setText(R.string.head);
        tv_head.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//        tv_head.setCompoundDrawablesRelative();
        lv_sub.addHeaderView(tv_head);
        //设置listview的监听
        setLVListener();

    }
}
