package org.sckj.grid_list.adapter;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import uk.co.senab.photoview.PhotoView;

public class PictureShowAdapter extends PagerAdapter {
    public BitmapDrawable[] source = null;

    public PictureShowAdapter(BitmapDrawable[] o) {
        source = o;
    }

    @Override
    public int getCount() {
        return source.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageDrawable(source[position]);
        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
