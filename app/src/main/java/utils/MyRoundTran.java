package utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;

/**
 * Created by samsung on 2016/4/13.
 */
public class MyRoundTran implements Transformation {

    /*
    * 参数：下载好的原图片
    * 返回值： 裁剪好的图片
    *
    * 处理图片的裁剪
    * */
    @Override
    public Bitmap transform(Bitmap source) {

        Bitmap bitmap = Bitmap.createBitmap(source.getWidth(),source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);

        RectF rc = new RectF(0,0,source.getWidth(),source.getHeight());
        canvas.drawRoundRect(rc,30,30,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(source,0,0,paint);

        source.recycle();
        return bitmap;
    }

    //通过返回值给自定义的裁剪方式设置一个名字key
    @Override
    public String key() {
        return "ayRound";
    }
}
