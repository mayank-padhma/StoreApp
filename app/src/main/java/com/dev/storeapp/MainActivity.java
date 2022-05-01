package com.dev.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.storeapp.Adapters.HomeAdapter;
import com.dev.storeapp.MainFragments.HomeFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton backNav = findViewById(R.id.backNav);
        RelativeLayout navBar = findViewById(R.id.navBar);
        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab);
        TabItem item1 = findViewById(R.id.item1);
        TabItem item2 = findViewById(R.id.item2);
        TabItem item3 = findViewById(R.id.item3);
        viewPager.setCurrentItem(new HomeFragment().getId());
        backNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navBar.animate().translationX(-2000).setDuration(1000);
            }
        });

        HomeAdapter pagerAdapter =new HomeAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setCurrentItem(1);
    }
}