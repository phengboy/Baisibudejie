package utils;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MyGsonTask<T> extends AsyncTask<String, Void, T> {

    public interface DoBackListener<T> {
        void onBack(T t);
    }

    DoBackListener<T> listener;

    private Class<T> cls;

    public MyGsonTask(DoBackListener listener, Class<T> cls) {
        this.listener = listener;
        this.cls = cls;
    }

    @Override
    protected T doInBackground(String... params) {

        if (params != null && params.length > 0) {
            String path = params[0];
            byte[] b = doget(path);
            if (b != null) {
                String json = new String(b);
                Gson gson = new Gson();
                T t = gson.fromJson(json, cls);
                return t;
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(T t) {
        listener.onBack(t);
    }

    public static byte[] doget(String apiURL) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream input = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = -1;
                while ((len = input.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                byte[] b = baos.toByteArray();
                return b;
            } else {
                // 终止数据访问的操作，并提示用户；
                throw new RuntimeException("网络访问失败：" + code);
            }
        } catch (Exception e) {
            return null;
        }
    }

}
