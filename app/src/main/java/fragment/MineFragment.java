package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.budejie.R;

import adapter.MinAdapter;
import application.MyApplication;

/**
 * Created by Y.vn on 2016/5/6.
 */
public class MineFragment extends Fragment {
    RecyclerView mRecyclerView;
    private RecyclerView rv_min;
    //    private RecyclerView rv_min;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.minefragment,container,false);
        inintView(view);
        initAdapter();


        return view;
    }

    private void initAdapter() {
        rv_min.setLayoutManager(new LinearLayoutManager(MyApplication.mContext));
        rv_min.setAdapter(new MinAdapter());
    }

    private void inintView(View view) {
        rv_min = (RecyclerView) view.findViewById(R.id.rv_min);
    }
}
