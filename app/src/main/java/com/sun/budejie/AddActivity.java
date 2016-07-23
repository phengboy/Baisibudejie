package com.sun.budejie;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import application.MyApplication;

/**
 * Created by Y.vn on 2016/5/10.
 */
public class AddActivity extends Activity {
    private RelativeLayout rl;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        startAnimator();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = ObjectAnimator.ofFloat(rl, "translationY", MyApplication.mScreenHeight/ 3, MyApplication.mScreenHeight);
                animator.setDuration(1000);
                animator.start();
                finish();
            }
        });
    }
    public void click(View v){
        switch (v.getId()){
            case R.id.add_iv1:
                startActivity(new Intent(this,MovieActivity.class));
                break;
            case R.id.add_iv2:
                startActivity(new Intent(this,PicActivity.class));
                break;
            case R.id.add_iv3:
                startActivity(new Intent(this, WordActivity.class));
                break;
            case R.id.add_iv4:
                Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_iv5:
                Toast.makeText(this,"5",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_iv6:
                Toast.makeText(this,"6",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startAnimator() {
        Animator animator = ObjectAnimator.ofFloat(rl, "translationY", 0, MyApplication.mScreenHeight / 3);
        animator.setDuration(2000);
        animator.start();
    }
    private void initView() {
        rl= (RelativeLayout) findViewById(R.id.add_rl);
        tv= (TextView) findViewById(R.id.add_tv);
    }

}