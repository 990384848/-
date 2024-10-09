package org.sckj.grid_list;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import org.sckj.grid_list.adapter.GridListAdapter;
import org.sckj.grid_list.bean.GridListBean;
import org.sckj.grid_list.cache.RunNeedProperHolder;
import org.sckj.grid_list.cache.SourceHolder;
import org.sckj.grid_list.common.Constant;
import org.sckj.grid_list.listener.GridListClickListener;
import org.sckj.grid_list.utils.ImageDownLoad;
import org.sckj.grid_list.utils.RandomData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public static final List<GridListBean> gridListBeans = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("InflateParams")
    private void init(Context context) {
        RunNeedProperHolder.getInstance().setSource(Constant.main, context);
        ListView listView = findViewById(R.id.listv);
        RunNeedProperHolder.getInstance().setSource("show_img", findViewById(R.id.show_img));
        RunNeedProperHolder.getInstance().setSource("listview", findViewById(R.id.listv));
        GridListAdapter gridListAdapter = new GridListAdapter(context, R.layout.items_layout, gridListBeans);
        RunNeedProperHolder.getInstance().setSource("adapter", gridListAdapter);
        for (int i = 0; i < 20; i++) {
            GridListBean gridListBean1 = new GridListBean("第" + (i + 1) + "个九宫格", "第" + (1 + i) + "个九宫格", "2022-03-09", "http://baidu.com", RandomData.getData());
            gridListBeans.add(gridListBean1);
        }
        listView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.head_layout, null)); //设置头布局
        listView.setAdapter(gridListAdapter);
        GridListClickListener.listener();

    }

    @Override
    public void onBackPressed() {
        if (((ListView) RunNeedProperHolder.getInstance().getSource(Constant.listview)).getVisibility() == View.GONE) {
            ((ListView) RunNeedProperHolder.getInstance().getSource(Constant.listview)).setVisibility(VISIBLE);
            ((ImageView) RunNeedProperHolder.getInstance().getSource(Constant.show_img)).setVisibility(GONE);
        }
    }
}