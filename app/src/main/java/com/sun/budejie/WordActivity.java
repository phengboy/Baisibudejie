package com.sun.budejie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Y.vn on 2016/5/11.
 */
public class WordActivity extends Activity {
    private EditText et;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pic_word);
        initView();
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.pic_drop:
                finish();
                break;
            case R.id.pic_write:
                String s = et.getText().toString();
                Intent in = new Intent(this, PubActivity.class);
                in.putExtra("mess", s);
                startActivity(in);
                finish();
                break;
        }

    }

    private void initView() {
        et = (EditText) findViewById(R.id.pic_et);
        tv = (TextView) findViewById(R.id.pic_tv);
        tv.setText("发表文字");
    }

}
