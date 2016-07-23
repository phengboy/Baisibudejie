package application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.sharesdk.framework.ShareSDK;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Y.vn on 2016/5/9.
 */
public class MyApplication extends Application {
    public static Context mContext;
    private static MyApplication instance;
    public static int mScreenWidth;
    public static int mScreenHeight;
    private static String mlog = "mlog";
    private static boolean isDebug = true;
    public static OkHttpClient client;
    public static final int ITEM_NUM = 4;
    public static final

    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
        this.mContext=getApplicationContext();
        initOkHttpClent();
        mScreenHeight=getResources().getDisplayMetrics().heightPixels;
        mScreenWidth=getResources().getDisplayMetrics().widthPixels;
        instance=this;
    }
    public static MyApplication instance() {
        return instance;
    }
    private void initOkHttpClent() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        client = builder.connectTimeout(30, TimeUnit.SECONDS)
                .cache(new Cache(new File("/mnt/sdcard/bsbdj"), 50 * 1024 * 1024))
                .build();
    }

    public static void logI(String log) {
        if (isDebug == true) {
            Log.i(mlog, log);
        }
    }

}
