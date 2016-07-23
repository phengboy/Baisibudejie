package bean;

import android.os.Parcelable;

/**
 * Created by Y.vn on 2016/5/11.
 */
public class Pub {
    private String title;
    private Parcelable Bitmap;

    public Pub(String title, Parcelable bitmap) {
        this.title = title;
        Bitmap = bitmap;
    }

    public Parcelable getBitmap() {
        return Bitmap;
    }

    public void setBitmap(Parcelable bitmap) {
        Bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Pub{" +
                "title='" + title + '\'' +
                ", Bitmap=" + Bitmap +
                '}';
    }
}
