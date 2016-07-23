package com.sun.budejie;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

/**
 * Created by Y.vn on 2016/5/10.
 */
public class PicActivity extends Activity {

    private ImageView imageView;
    private EditText et;
    private TextView tv;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pic_word);
        initView();
        selectPic();

    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.pic_drop:
                finish();
                break;
            case R.id.pic_write:
                String s = et.getText().toString();
                Intent in = new Intent(this, PubActivity.class);
                in.putExtra("bitmap", bitmap);
                in.putExtra("mess", s);
                startActivity(in);
                finish();
                break;
        }

    }

    private void selectPic() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.pic_iv);
        et = (EditText) findViewById(R.id.pic_et);
        tv = (TextView) findViewById(R.id.pic_tv);
        tv.setText("发表图片");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                ContentResolver cr = this.getContentResolver();
                try {
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    Log.e("Exception", e.getMessage(), e);
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
