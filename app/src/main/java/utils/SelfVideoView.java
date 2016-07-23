package utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class SelfVideoView extends VideoView {

    private int mVideoHeight;
    public SelfVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
        //设置自定义控件的大小
        setMeasuredDimension(width, height);
    }
}
