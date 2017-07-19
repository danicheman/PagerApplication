package com.example.nickost.pagerapplication;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by suprise on 7/13/17.
 */

public class MyPager extends PagerAdapter {


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    public void setCurrentItem(int page, boolean b) {
    }
}
