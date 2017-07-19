package com.example.nickost.pagerapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nickost.pagerapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "MainActivity";
    Handler handler;
    MyPager myPager;
    private ActivityMainBinding binding;
    private int delay = 5000; //milliseconds
    private int page = 0;
    Runnable runnable = new Runnable() {
        public void run() {
            if (myPager.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            myPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myPager = new MyPager();
        binding.viewPager.setAdapter(myPager);
    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh: ");
        binding.activityMain.setRefreshing(false);
    }
}
