package com.project.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.project.android.Adapter.MyViewPagerAdapter;
import com.project.android.Adapter.usertabadapter;
import com.project.android.R;

public class UserActitity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private usertabadapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_actitity);

        tabLayout = findViewById(R.id.tabLayoutAdmin);
        viewPager2 = findViewById(R.id.viewAdmin);

        myViewPagerAdapter = new usertabadapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Thông tin người dùng");
                    break;
                case 1:
                    tab.setText("Quản lý đơn hàng");
                    break;
                case 2:
                    tab.setText("Chỉnh sửa thông tin");
                    break;
            }
        }).attach();


    }
}