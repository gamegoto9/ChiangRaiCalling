package com.devdrunk.chiangraicalling.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.fragment.AmpureFragment;
import com.devdrunk.chiangraicalling.fragment.PlanceFragment;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class ViewPagerAdaper extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[] { "Tab1", "Tab2"};
    private int[] imageResId = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    public ViewPagerAdaper(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return AmpureFragment.newInstance();
            case 1:
                return PlanceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
