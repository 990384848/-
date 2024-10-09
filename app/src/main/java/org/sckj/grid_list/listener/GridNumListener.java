package org.sckj.grid_list.listener;

import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class GridNumListener {

    public static void setImg(ImageView[] imageViews, BitmapDrawable[] drawable, int length) {
        try {
            for (int i = 0; i < length; i++) {
                if (drawable[i] != null)
                    imageViews[i].setImageDrawable(drawable[i]);
            }
        } catch (Exception e) {
            Log.d(String.valueOf(GridNumListener.class), "设置图片出现异常" + e.getMessage());
        }
    }

    public static void setVisible(ImageView[] imageViews, int length) {
        for (int i = 0; i < imageViews.length; i++) {
            if (i < length) {
                imageViews[i].setVisibility(View.VISIBLE);
            } else
                imageViews[i].setVisibility(View.GONE);
        }
    }
}
