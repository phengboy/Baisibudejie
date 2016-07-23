package com.sun.budejie;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class RedManActivity extends FragmentActivity {
    private ProgressBar pb;
    private WebView wv;
    private TextView mTextView;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_red_man);

        pb= (ProgressBar) findViewById(R.id.pb_net);
        wv= (WebView) findViewById(R.id.web_view);

        mImageView= (ImageView) findViewById(R.id.iv_redman);
        mTextView= (TextView) findViewById(R.id.tv_redman);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(RedManActivity.this);
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

                // title标题：微信、QQ（新浪微博不需要标题）
                oks.setTitle("我是分享标题");  //最多30个字符

                // text是分享文本：所有平台都需要这个字段
                oks.setText("我是分享文本，啦啦啦~http://uestcbmi.com/");  //最多40个字符

                // imagePath是图片的本地路径：除Linked-In以外的平台都支持此参数
                //oks.setImagePath(Environment.getExternalStorageDirectory() + "/meinv.jpg");//确保SDcard下面存在此张图片

                //网络图片的url：所有平台
                oks.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul

                // url：仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");   //网友点进链接后，可以看到分享的详情

                // Url：仅在QQ空间使用
                oks.setTitleUrl("http://www.baidu.com");  //网友点进链接后，可以看到分享的详情

                // 启动分享GUI
                oks.show(RedManActivity.this);
            }
        });

        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true); //支持javascript代码

        wv.loadUrl("http://d.api.budejie.com/user/hot/35?ver=6.3.9&client=android&market=360zhushou&udid=864394102121904&appname=baisibudejie&mac=D4:BE:D9:51:73:98time=1463218285010&uid=18292038");
        //wv.loadUrl("www.baidu.com");
        wv.setWebViewClient(new WebViewClient() {
            //如果想在自己的app中，通过webview打开网页的话，需要覆写这个方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                Log.e("tag", "onPageStarted");
//                mPbNet.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                Log.e("tag", "onPageFinished");
//                Javascript
//                mPbNet.setVisibility(View.GONE);
            }
        });

        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress > 0) {
                    pb.setVisibility(View.VISIBLE);
                }

                if (newProgress == 100) {
                    pb.setVisibility(View.GONE);
                }
                Log.i("newProgress", "progress:" + newProgress);
                pb.setProgress(newProgress);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()) {
            wv.goBack(); //返回
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
