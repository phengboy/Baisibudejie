package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.sun.budejie.R;

import java.util.List;

import ViewHolder.FourthItemViewHolder;
import application.MyApplication;
import bean.MineBean;

/**
 * Created by pheng on 2016/5/10.
 */
public class MineFourthAdapter extends RecyclerView.Adapter<FourthItemViewHolder> {
    private List<MineBean.SquareListBean> list;

    public MineFourthAdapter(List<MineBean.SquareListBean> square_list) {
        this.list = square_list;
    }

    @Override
    public FourthItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FourthItemViewHolder(LayoutInflater.from(MyApplication.mContext).inflate(R.layout.fourth_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FourthItemViewHolder holder, int position) {
        MyApplication.logI("FourthItemViewHolder" + "  " + position);
        holder.fourth_tv.setText(list.get(position).getName());
        Picasso.with(MyApplication.mContext).load(list.get(position).getIcon())
                .placeholder(R.mipmap.icon_new)
                .into(holder.fourth_iv);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}
