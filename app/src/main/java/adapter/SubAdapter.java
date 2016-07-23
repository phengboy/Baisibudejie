package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sun.budejie.R;

import java.util.List;

import ViewHolder.SubViewHolder;
import application.MyApplication;
import bean.SubBean;

/**
 * Created by pheng on 2016/5/9.
 */
public class SubAdapter extends BaseAdapter {
    private List<SubBean.RecTagsBean> list;
    private final int MWIDTH = MyApplication.mScreenWidth / 8;

    public SubAdapter(List<SubBean.RecTagsBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
        SubViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(MyApplication.mContext).inflate(R.layout.text_sub_item, null);
            holder = new SubViewHolder();
            holder.iv_sub = (ImageView) convertView.findViewById(R.id.iv_sub);
            holder.tv1_sub = (TextView) convertView.findViewById(R.id.tv1_sub);
            holder.tv2_sub = (TextView) convertView.findViewById(R.id.tv2_sub);
            holder.tv4_sub = (TextView) convertView.findViewById(R.id.tv4_sub);
            holder.but_sub = (Button) convertView.findViewById(R.id.btn_sub);
            convertView.setTag(holder);
        } else {
            holder = (SubViewHolder) convertView.getTag();
        }
        holder.tv1_sub.setText(list.get(position).getTheme_name());
        holder.tv2_sub.setText((float) (list.get(position).getSub_number()) / 10000 + "");
        holder.tv4_sub.setText(list.get(position).getPost_num() + "");
        String ima_url = list.get(position).getImage_list();
        ViewGroup.LayoutParams layoutParams1 = holder.but_sub.getLayoutParams();
        layoutParams1.width = MyApplication.mScreenWidth / 6;
        holder.but_sub.setLayoutParams(layoutParams1);
        if (!"".equals(ima_url)) {
            Picasso.with(MyApplication.mContext)
                    .load(list.get(position).getImage_list())
                    .resize(MWIDTH, MWIDTH)
                    .error(R.mipmap.label_default_icon)
                    .placeholder(R.mipmap.label_default_icon)
                    .into(holder.iv_sub);
        } else {
            ViewGroup.LayoutParams layoutParams = holder.iv_sub.getLayoutParams();
            layoutParams.width = MWIDTH;
            layoutParams.height = MWIDTH;
            holder.iv_sub.setLayoutParams(layoutParams);
            holder.iv_sub.setImageResource(R.mipmap.label_default_icon);
        }
        return convertView;
    }
}
