package com.sun.budejie;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by pheng on 2016/5/11.
 */
public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_click_item);
    }
}
