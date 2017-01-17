package com.androidbie.slidingtabsupportdesign.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.androidbie.slidingtabsupportdesign.fragments.FirstFragment;
import com.androidbie.slidingtabsupportdesign.fragments.SecondFragment;
import com.androidbie.slidingtabsupportdesign.fragments.ThirdFragment;

/**
 * Created by putuguna on 13/01/17.
 */

public class SlidingTabAdapter extends FragmentStatePagerAdapter {

    public SlidingTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FirstFragment();
        }else if(position==1){
            return new SecondFragment();
        }else {
            return new ThirdFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
