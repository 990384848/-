package org.sckj.grid_list.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.sckj.grid_list.R;
import org.sckj.grid_list.bean.GridListBean;
import org.sckj.grid_list.cache.SourceHolder;
import org.sckj.grid_list.listener.GridListClickListener;
import org.sckj.grid_list.listener.GridNumListener;
import org.sckj.grid_list.utils.ImageDownLoad;

import java.util.LinkedList;
import java.util.List;

public class GridListAdapter extends ArrayAdapter<GridListBean> {
    private static List<GridListBean> listBeans = new LinkedList<>();
    public int resource;

    public GridListAdapter(@NonNull Context context, int source, @NonNull List<GridListBean> objects) {
        super(context, source, objects);
        listBeans = objects;
        resource = source;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        GridListBean gridListBean = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resource, parent, false); //用布局裁剪器(又叫布局膨胀器)，将导入的布局裁剪并且放入到当前布局中
        TextView title = view.findViewById(R.id.title);
        title.setText(gridListBean.getTitle());
        TextView content = view.findViewById(R.id.content);
        content.setText(gridListBean.getContent());
        TextView time = view.findViewById(R.id.time);
        time.setText(gridListBean.getTime());
        ImageView avatar = view.findViewById(R.id.avatar);
        ImageView img_one = view.findViewById(R.id.img_one);
        ImageView img_two = view.findViewById(R.id.img_two);
        ImageView img_three = view.findViewById(R.id.img_three);
        ImageView img_four = view.findViewById(R.id.img_four);
        ImageView img_five = view.findViewById(R.id.img_five);
        ImageView img_six = view.findViewById(R.id.img_six);
        ImageView img_seven = view.findViewById(R.id.img_seven);
        ImageView img_eight = view.findViewById(R.id.img_eight);
        ImageView img_nine = view.findViewById(R.id.img_nine);
        try {
            ImageView[] imageViews = new ImageView[]{avatar, img_one, img_two, img_three, img_four, img_five, img_six, img_seven, img_eight, img_nine};
            GridNumListener.setVisible(imageViews, getItem(position).getImgUrl().length);
            BitmapDrawable[] drawable = getBitmapFromMemory(getItem(position).getImgUrl());
            if (drawable != null) {
                GridNumListener.setImg(imageViews, drawable, getItem(position).getImgUrl().length);
            } else {
                BitmapWorkerTask task = new BitmapWorkerTask(imageViews);  //内存没有，开启异步任务去下载
                task.execute(getItem(position).getImgUrl());
            }
            GridListClickListener.imgOnClick(imageViews,getItem(position).getImgUrl());
        } catch (Exception e) {
            Log.d(String.valueOf(this), "加载图片异常..." + e);
        }
        return view;
    }

    public BitmapDrawable[] getBitmapFromMemory(String[] key) {
        BitmapDrawable[] bitmapDrawable = new BitmapDrawable[key.length];
        for (int i = 0; i < key.length; i++) {
            BitmapDrawable bitmapDrawable1 = SourceHolder.getInstance().getSource(key[i]);
            if (bitmapDrawable1 == null)
                return null;
            bitmapDrawable[i] = bitmapDrawable1;
        }
        return bitmapDrawable;
    }

    /**
     * 将图片添加到lruCache中
     */
    public void addBitmapToMemory(String[] key, BitmapDrawable[] drawable) {
        for (int i = 0; i < key.length; i++) {
            SourceHolder.getInstance().setSource(key[i], drawable[i]);
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class BitmapWorkerTask extends AsyncTask<String, Void, BitmapDrawable[]> {
        private final ImageView[] imageViews;
        String[] imageUrl = null;

        private BitmapWorkerTask(ImageView[] imageViews) {
            this.imageViews = imageViews;
        }

        protected BitmapDrawable[] doInBackground(String... params) {
            try {
                imageUrl = params;//获取当前图片的地址
                BitmapDrawable[] bitmapDrawable1 = new BitmapDrawable[10];
                for (int i = 0; i < imageUrl.length; i++) {
                    bitmapDrawable1[i] = ImageDownLoad.downloadBitmap(imageUrl[i], 80);
                }
                addBitmapToMemory(imageUrl, bitmapDrawable1);
                return bitmapDrawable1;
            } catch (Exception e) {
                return null;
            }
        }

        protected void onPostExecute(BitmapDrawable[] result) {
            super.onPostExecute(result);
            try {
                if (imageViews != null && result != null) {
                    GridNumListener.setImg(imageViews, result, imageUrl.length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
