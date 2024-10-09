package org.sckj.grid_list.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImageProcess {

    /**
     * 质量压缩
     * 设置bitmap options属性，降低图片的质量，像素不会减少
     * 第一个参数为需要压缩的bitmap图片对象，第二个参数为压缩后图片保存的位置
     * 设置options 属性0-100(100时不压缩)，来实现压缩（因为png是无损压缩，所以该属性对png是无效的）
     */
    public static Bitmap qualityCompress(Bitmap bitmap, int CompressionRatio) {
        Bitmap bitmapPro = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, CompressionRatio, byteArrayOutputStream);
        try {
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            bitmapPro = BitmapFactory.decodeStream(inputStream);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmapPro;
    }


    /**
     * 尺寸压缩（通过缩放图片像素来减少图片占用内存大小）
     * ratio=8 尺寸压缩倍数,值越大，图片尺寸越小
     */
    public static Bitmap sizeCompress(Bitmap bmp, int ratio) {
        Bitmap bitmap = null;
        Bitmap result = Bitmap.createBitmap(bmp.getWidth() / ratio, bmp.getHeight() / ratio, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, bmp.getWidth() / ratio, bmp.getHeight() / ratio);
        canvas.drawBitmap(bmp, null, rect, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        result.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            bitmap = BitmapFactory.decodeStream(inputStream);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    //采样率压缩
    public int computeSize(Bitmap bitmap) {
        int srcWidth = bitmap.getWidth();
        int srcHeight = bitmap.getHeight();
        srcWidth = srcWidth % 2 == 1 ? srcWidth + 1 : srcWidth;
        srcHeight = srcHeight % 2 == 1 ? srcHeight + 1 : srcHeight;

        int longSide = Math.max(srcWidth, srcHeight);
        int shortSide = Math.min(srcWidth, srcHeight);

        float scale = ((float) shortSide / longSide);
        if (scale <= 1 && scale > 0.5625) {
            if (longSide < 1664) {
                return 1;
            } else if (longSide < 4990) {
                return 2;
            } else if (longSide > 4990 && longSide < 10240) {
                return 4;
            } else {
                return longSide / 1280;
            }
        } else if (scale <= 0.5625 && scale > 0.5) {
            return longSide / 1280 == 0 ? 1 : longSide / 1280;
        } else {
            return (int) Math.ceil(longSide / (1280.0 / scale));
        }
    }
}
