package org.sckj.grid_list;

import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import org.sckj.grid_list.adapter.PictureShowAdapter;
import org.sckj.grid_list.cache.SourceHolder;

public class PictureShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_pager);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PictureShowAdapter(getSource(getIntent().getStringArrayExtra("url"))));
    }

    private BitmapDrawable[] getSource(String[] url) {
        BitmapDrawable[] bitmapDrawables = new BitmapDrawable[url.length];
        for (int i = 0; i < url.length; i++) {
            bitmapDrawables[i] = SourceHolder.getInstance().getSource(url[i]);
        }
        return bitmapDrawables;
    }
}