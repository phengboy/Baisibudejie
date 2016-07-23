package com.sun.budejie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

/**
 * Created by Y.vn on 2016/5/12.
 */
public class MovieActivity extends Activity {

    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initView();

    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.movie_vv);

    }

}
