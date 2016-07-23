package ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.budejie.R;

import application.MyApplication;

/**
 * Created by pheng on 2016/5/10.
 */
public class FourthItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView fourth_iv;
    public TextView fourth_tv;

    public FourthItemViewHolder(View itemView) {
        super(itemView);
        fourth_iv = (ImageView) itemView.findViewById(R.id.iv_fourth_item);
        ViewGroup.LayoutParams layoutParams = fourth_iv.getLayoutParams();
        layoutParams.width = MyApplication.mScreenWidth / 7;
        layoutParams.height = MyApplication.mScreenWidth / 7;
        fourth_iv.setLayoutParams(layoutParams);
        fourth_tv = (TextView) itemView.findViewById(R.id.tv_fourth_item);
    }
}
