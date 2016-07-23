package utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

    private static final String TAG = Utils.class.getSimpleName();

    public static boolean isNetworkConnected(Context ctx) {
        boolean isNetworkConnected;
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        isNetworkConnected = ni != null;
        return isNetworkConnected;
    }

}
