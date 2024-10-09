package org.sckj.grid_list.listener;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import org.sckj.grid_list.MainActivity;
import org.sckj.grid_list.PictureShowActivity;
import org.sckj.grid_list.adapter.GridListAdapter;
import org.sckj.grid_list.bean.GridListBean;
import org.sckj.grid_list.cache.RunNeedProperHolder;
import org.sckj.grid_list.common.Constant;
import org.sckj.grid_list.utils.RandomData;

import java.util.concurrent.atomic.AtomicInteger;

public class GridListClickListener {
    private static boolean isLoad;

    public static void imgOnClick(ImageView[] views, String[] img) {

        views[0].setOnClickListener(view -> showImg(views[0].getDrawable()));
        views[1].setOnClickListener(view -> jumpPager(img, 1));
        views[2].setOnClickListener(view -> jumpPager(img, 2));
        views[3].setOnClickListener(view -> jumpPager(img, 3));
        views[4].setOnClickListener(view -> jumpPager(img, 4));
        views[5].setOnClickListener(view -> jumpPager(img, 5));
        views[6].setOnClickListener(view -> jumpPager(img, 6));
        views[7].setOnClickListener(view -> jumpPager(img, 7));
        views[8].setOnClickListener(view -> jumpPager(img, 8));
        views[9].setOnClickListener(view -> jumpPager(img, 9));

    }

    private static void jumpPager(String[] imgUrl, int current) {
        try {
            String[] img = new String[imgUrl.length - 1];
            System.arraycopy(imgUrl, 1, img, 0, imgUrl.length - 1);
            String ont = img[0];
            img[0] = img[current - 1];
            img[current - 1] = ont;
            Intent intent = new Intent(((Context) RunNeedProperHolder.getInstance().getSource(Constant.main)), PictureShowActivity.class);
            intent.putExtra("url", img);
            ((Context) RunNeedProperHolder.getInstance().getSource(Constant.main)).startActivity(intent);
        } catch (Exception e) {
            Log.d("JumpPage", "跳转页面出现异常..." + e.getMessage());
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private static void showImg(Drawable bitmapDrawable) {
        ((ListView) RunNeedProperHolder.getInstance().getSource(Constant.listview)).setVisibility(View.GONE);
        ((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).setVisibility(View.VISIBLE);
        ((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).setImageDrawable(bitmapDrawable);
        ((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).setOnTouchListener(new OnMultiTouchListener(new OnMultiTouchListener.MyClickCallBack() {
            @Override
            public void oneClick() {
                if (((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).getVisibility() == View.VISIBLE) {
                    ((ListView) RunNeedProperHolder.getInstance().getSource(Constant.listview)).setVisibility(View.VISIBLE);
                    ((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).setVisibility(View.GONE);
                }
            }

            @Override
            public void doubleClick() {

            }
        }) {
        });
    }

    public static void listener() {
        ((ListView) RunNeedProperHolder.getInstance().getSource(Constant.listview)).setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (!isLoad) {
                        isLoad = true;
                        for (int j = 0; j < 20; j++) {
                            GridListBean gridListBean1 = new GridListBean("第" + (j + 1) + "个九宫格", "第" + (j + i) + "个九宫格", "2022-03-09", "http://baidu.com", RandomData.getData());
                            MainActivity.gridListBeans.add(gridListBean1);
                        }
                        ((GridListAdapter) RunNeedProperHolder.getInstance().getSource(Constant.adapter)).notifyDataSetChanged();
                        isLoad = false;
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }
}
