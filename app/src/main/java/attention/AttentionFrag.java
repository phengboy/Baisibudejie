package attention;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.sun.budejie.LoginActivity;
import com.sun.budejie.R;
import com.sun.budejie.RegistActivity;

import application.MyApplication;

/**
 * Created by pheng on 2016/5/9.
 */
public class AttentionFrag extends Fragment implements View.OnClickListener{
    private Button login;
    private Button regest;
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attention_frag, container, false);
        initView(view);

        setParams();

        setListener();
        return view;
    }

    private void setListener() {
        login.setOnClickListener(this);
        regest.setOnClickListener(this);
    }

    private void setParams() {
        login.setWidth(MyApplication.mScreenWidth / 3);
        regest.setWidth(MyApplication.mScreenWidth / 3);
        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
        layoutParams.width = MyApplication.mScreenWidth / 2;
        layoutParams.height = MyApplication.mScreenWidth / 2;
        iv.setLayoutParams(layoutParams);
    }

    private void initView(View view) {
        login = (Button) view.findViewById(R.id.btn_login);
        regest = (Button) view.findViewById(R.id.btn_regest);
        iv = (ImageView) view.findViewById(R.id.iv_attention);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                startActivity(new Intent(MyApplication.mContext,LoginActivity.class));
                break;
            case R.id.btn_regest:
                startActivity(new Intent(MyApplication.mContext,RegistActivity.class));
                break;
        }

    }
}
