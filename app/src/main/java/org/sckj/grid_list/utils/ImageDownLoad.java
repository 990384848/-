package org.sckj.grid_list.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import org.sckj.grid_list.cache.RunNeedProperHolder;
import org.sckj.grid_list.common.Constant;

import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownLoad {
    public static BitmapDrawable downloadBitmap(String imageUrl, int CompressionRatio) {
        Bitmap bitmap = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(imageUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(3000);
            bitmap = ImageProcess.qualityCompress(BitmapFactory.decodeStream(connection.getInputStream()), CompressionRatio);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return new BitmapDrawable(((Context) RunNeedProperHolder.getInstance().getSource(Constant.main)).getResources(), bitmap);
    }
}
