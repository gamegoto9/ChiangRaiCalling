package com.devdrunk.chiangraicalling.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.AmpureListAdapter;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.dao.PlanceItemDao;
import com.devdrunk.chiangraicalling.fragment.AmpureFragment;
import com.devdrunk.chiangraicalling.fragment.OnlineFragment;
import com.devdrunk.chiangraicalling.fragment.PlanceFragment;

public class OnlineActivity extends AppCompatActivity
        implements AmpureFragment.FragmentListener{

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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onAmpureItemClicked(AmpureItemDao dao) {
        Intent intent = new Intent(OnlineActivity.this,
                TypeActivity.class);
        intent.putExtra("dao",dao);
        startActivity(intent);
    }
}
