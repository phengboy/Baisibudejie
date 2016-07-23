package com.sun.budejie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Urls.Url;
import bean.CommendBean;
import utils.MyGsonTask;
import utils.MyRoundTran;

public class CommendActivity extends Activity {
    RecyclerView mRecyclerView;
    ArrayList<CommendBean.DataBean> list1=new ArrayList<>();
    private MyAdapter adapter;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_commend);

        mTextView= (TextView) findViewById(R.id.tv1_commend);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView_commend);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter();
        mRecyclerView.setAdapter(adapter);
        new MyGsonTask<CommendBean>(new MyGsonTask.DoBackListener<CommendBean>() {
            @Override
            public void onBack(CommendBean bean) {
                list1.clear();
                list1.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            }
        }, CommendBean.class).execute(Url.URL_COMMEND);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(CommendActivity.this).inflate(R.layout.commend_item,parent,false));
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            Picasso.with(CommendActivity.this).load(list1.get(position).getUser().getProfile_image()).transform(new MyRoundTran())
                    .resize(70, 70).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.iv);
            holder.tv1.setText(list1.get(position).getUser().getUsername());
            holder.tv2.setText(list1.get(position).getContent());
            holder.tv3.setText(list1.get(position).getLike_count());
            holder.iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.iv2.setImageResource(R.mipmap.ding_has_clicked);
                    int count=Integer.parseInt(list1.get(position).getLike_count());
                    holder.tv3.setText(count+1+"");
                }
            });
        }

        @Override
        public int getItemCount() {
            return list1.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            ImageView iv2;
            TextView tv1;
            TextView tv2;
            TextView tv3;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv= (ImageView) itemView.findViewById(R.id.imageView1_item1);
                iv2= (ImageView) itemView.findViewById(R.id.iv2_item);
                tv1= (TextView) itemView.findViewById(R.id.tv1_item);
                tv2= (TextView) itemView.findViewById(R.id.tv2_item);
                tv3= (TextView) itemView.findViewById(R.id.tv3_item);
            }
        }
    }
}
