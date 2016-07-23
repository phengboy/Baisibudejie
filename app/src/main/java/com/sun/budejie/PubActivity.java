package com.sun.budejie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import application.MyApplication;
import bean.Pub;

/**
 * Created by Y.vn on 2016/5/11.
 */
public class PubActivity extends Activity {

    private Parcelable bitmap;
    ArrayList<Pub> list = new ArrayList<>();
    private String title;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pub);
        lv = (ListView) findViewById(R.id.pub_list);

        Intent intent = getIntent();
        if (intent != null) {
            bitmap = intent.getParcelableExtra("bitmap");
            title = intent.getStringExtra("mess");
            list.add(new Pub(title, bitmap));
        }
        lv.setAdapter(new MyAdapter());
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.pub_back:
                finish();
                break;
        }
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(PubActivity.this, R.layout.pub_listitem, null);

                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.pub_listtv);
                holder.iv = (ImageView) convertView.findViewById(R.id.pub_listiv);

                ViewGroup.MarginLayoutParams margin9 = new ViewGroup.MarginLayoutParams(
                        holder.iv.getLayoutParams());
                margin9.setMargins(MyApplication.mScreenWidth/6, 0, MyApplication.mScreenWidth/6, 0);//在左右边距0像素，顶边距10像素的位置显示图片
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(margin9);
                layoutParams9.height = MyApplication.mScreenHeight / 5;//设置图片的高度
                layoutParams9.width = MyApplication.mScreenWidth*2/3; //设置图片的宽度
                holder.iv.setLayoutParams(layoutParams9);
                convertView.setTag(holder);

            } else {
                holder =(ViewHolder) convertView.getTag();
            }
            Pub pub = list.get(position);
            holder.tv.setText(pub.getTitle());
            holder.iv.setImageBitmap((Bitmap) pub.getBitmap());
            return convertView;
        }

        class ViewHolder {
            TextView tv;
            ImageView iv;
        }
    }

}
