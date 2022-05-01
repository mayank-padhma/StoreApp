package com.dev.storeapp.Adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dev.storeapp.MainFragments.BlankFragment;
import com.dev.storeapp.MainFragments.CartFragment;
import com.dev.storeapp.MainFragments.HomeFragment;

public class HomeAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public HomeAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new BlankFragment();
            case 1: return new HomeFragment();
            case 2: return  new CartFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
