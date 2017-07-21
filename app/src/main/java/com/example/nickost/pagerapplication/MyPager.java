package com.example.nickost.pagerapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Sample adapter for pager view
 */

class MyPager extends PagerAdapter {
    private static final String TAG = "MyPager";
    private String[] colors = {"#EEEEEE", "#CCCCCC", "#555555"};
    private String[] texts = {"First", "Second", "Third"};
    private Context context;


    MyPager(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: at position" + position);
        TextView tv = new TextView(context);
        tv.setText(texts[position]);
        tv.setBackgroundColor(Color.parseColor(colors[position]));
        container.addView(tv);
        return tv;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
