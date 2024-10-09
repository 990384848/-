package org.sckj.grid_list.cache;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.util.LruCache;

import java.util.HashMap;
import java.util.Map;

public class SourceHolder {
    private static LruCache<String, BitmapDrawable> bitmapDrawableLruCache;

    public SourceHolder() {
        try {
            int maxMemory = (int) (Runtime.getRuntime().totalMemory() / 1024);
            //手机：268435456B = 256MB
            //模拟器：16777216B = 16MB
            int cacheSize = maxMemory / 8;//指定缓存大小为内存的八分之一
            bitmapDrawableLruCache = new LruCache<String, BitmapDrawable>(cacheSize) {
                //重写此方法，返回每张图片的大小
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight() / 1024;
                }
            };
        } catch (Exception e) {
            Log.d(String.valueOf(this), "初始化缓存异常..." + e.getMessage());
        }
    }

    private static final class SourceHolderInstance {
        private static final SourceHolder sourceHolder = new SourceHolder();
    }

    public static SourceHolder getInstance() {
        return SourceHolderInstance.sourceHolder;
    }

    public void setSource(String key, BitmapDrawable source) {
        bitmapDrawableLruCache.put(key, source);
    }

    public BitmapDrawable getSource(String key) {
        return bitmapDrawableLruCache.get(key);
    }

    public void clearCache(String key) {
        bitmapDrawableLruCache.remove(key);
    }
}
