package com.devdrunk.chiangraicalling.fragment;

import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.AmpureListAdapter;
import com.devdrunk.chiangraicalling.adapter.ViewPagerAdaper;
import com.inthecheesefactory.thecheeselibrary.view.SlidingTabLayout;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class OnlineFragment extends Fragment {


    ViewPager viewPager;
    //private SlidingTabLayout slidingTabLayout;
    private TabLayout tabLayout;


    public OnlineFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static OnlineFragment newInstance() {
        OnlineFragment fragment = new OnlineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_online, container, false);

        initInstances(rootView, savedInstanceState);


        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        ViewPagerAdaper viewPagerAdaper = new ViewPagerAdaper(getChildFragmentManager());


        viewPager.setAdapter(viewPagerAdaper);

        tabLayout.setupWithViewPager(viewPager);

        /*
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.ic_launcher);
        }
        */




    }




    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

}
