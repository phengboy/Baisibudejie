package ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sun.budejie.R;

/**
 * Created by pheng on 2016/5/10.
 */
public class FouthViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView rv_mine;
    public FouthViewHolder(View itemView) {
        super(itemView);
        rv_mine = (RecyclerView) itemView.findViewById(R.id.rv_mine_forth);
    }
}
