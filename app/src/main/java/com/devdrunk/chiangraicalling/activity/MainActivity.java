package com.devdrunk.chiangraicalling.activity;

import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initInstances();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }
    }
    /*
    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);         // set toolbar
        setSupportActionBar(toolbar);                           // set toolbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo_app);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }
    */


}
