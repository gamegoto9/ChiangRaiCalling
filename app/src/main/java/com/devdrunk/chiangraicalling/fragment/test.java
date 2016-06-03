package com.devdrunk.chiangraicalling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class test extends Fragment {

    ListView lv;
    SearchView sv;

    String[] name={"Juan Mata","ander Herera"};
    int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher};

    public test() {
        super();
    }

    @SuppressWarnings("unused")
    public static test newInstance() {
        test fragment = new test();
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
        View rootView = inflater.inflate(R.layout.fragment_ampure, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        lv = (ListView) rootView.findViewById(R.id.listView);
        sv = (SearchView) rootView.findViewById(R.id.searchData);

        final test adapter = new test(this,getPlayers());
        lv.setAdapter(adapter);
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

    private ArrayList<AmpureItemDao> getPlayers(){
        ArrayList<AmpureItemDao> players = new ArrayList<AmpureItemDao>();
        AmpureItemDao p;

        for(int i =0;i<name.length;i++){
            p = new AmpureItemDao(name[i]);
            players.add(p);
        }
        return players;

    }

}
