package com.example.nickost.pagerapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
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
            Log.d(TAG, "run: triggering scroll view");
            binding.viewPager.setCurrentItem(page);

            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myPager = new MyPager(this);

        binding.viewPager.setAdapter(myPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(binding.viewPager, true);

        //get the party  started!!
        handler = new Handler();
        handler.postDelayed(runnable, delay);
    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh: ");
        binding.activityMain.setRefreshing(true);
        binding.activityMain.setRefreshing(false);
    }
}
