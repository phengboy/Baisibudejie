package adapter;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.sun.budejie.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Urls.Url;
import ViewHolder.FirstViewHolder;
import ViewHolder.FouthViewHolder;
import ViewHolder.SecViewHolder;
import ViewHolder.ThirdViewHolder;
import application.MyApplication;
import bean.MineBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pheng on 2016/5/10.
 */
public class MinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MineBean.SquareListBean> square_list = new ArrayList<>();
    private Handler handler;
    private MineFourthAdapter adapter;
    private MineFourthAdapter fourthAdapter;

    public MinAdapter() {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new FirstViewHolder(LayoutInflater.from(MyApplication.mContext).inflate(R.layout.first_item, parent, false));
            case 1:
                return new SecViewHolder(LayoutInflater.from(MyApplication.mContext).inflate(R.layout.sec_item, parent, false));
            case 2:
                return new ThirdViewHolder(LayoutInflater.from(MyApplication.mContext).inflate(R.layout.third_item, parent, false));
            case 3:
                return new FouthViewHolder(LayoutInflater.from(MyApplication.mContext).inflate(R.layout.mine_fouth_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:         //我的页面第四个item的操作    通过联网获取内容数据
                FouthViewHolder mHolder = (FouthViewHolder) holder;

                //设置recyclerView
                setRecyclerView(mHolder);

                //通过联网下载数据
                downloadDatas();

                //通过handler将接收的数据更新
                updateDatas();

                break;
        }

    }
    /**
     * 初始化handler对象
     * 通过handler将下载完成的数据更新
     *
     */
    private void updateDatas() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    String result = msg.obj.toString();
                    MineBean mineBean = new Gson().fromJson(result, MineBean.class);
                    square_list.addAll(mineBean.getSquare_list());
                    fourthAdapter.notifyDataSetChanged();
                    MyApplication.logI("handleMessage" + "  " + square_list.toString());
                }
            }
        };
    }

    /**
     * 联网下载数据的操作
     * 下载完成通过handler将数据传送出去
     *
     */
    private void downloadDatas() {
        MyApplication.client.newCall(new Request.Builder().url(Url.URL_MINE_FOURTH).build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();
                        Message msg = Message.obtain();
                        msg.what = 1;
                        msg.obj = result;
                        handler.sendMessage(msg);
                        MyApplication.logI("MinAdapter" + "  " + result);
                    }
                });
    }

    /**
     * 设置recyclerview
     * 网格布局，4列
     * 设置adapter
     *
     * @param mHolder
     */
    private void setRecyclerView(FouthViewHolder mHolder) {
        GridLayoutManager layout = new GridLayoutManager(MyApplication.mContext, 4);
//        layout.
        mHolder.rv_mine.setLayoutManager(layout);

        fourthAdapter = new MineFourthAdapter(square_list);
        mHolder.rv_mine.setAdapter(fourthAdapter);
    }

    @Override
    public int getItemCount() {
        //因为布局是固定的，定义全局常量 4，
        return MyApplication.ITEM_NUM;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

