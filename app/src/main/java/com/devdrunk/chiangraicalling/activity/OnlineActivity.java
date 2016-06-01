package com.devdrunk.chiangraicalling.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.AmpureListAdapter;
import com.devdrunk.chiangraicalling.fragment.OnlineFragment;

public class OnlineActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        initInstances();

        //PhotoItemDao dao = getIntent().getParcelableExtra("dao");


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, OnlineFragment.newInstance())             //แปะ fragment
                    .commit();
        }
    }




    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);         // set toolbar
        setSupportActionBar(toolbar);                           // set toolbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo_app);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
