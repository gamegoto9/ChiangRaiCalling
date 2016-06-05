package com.devdrunk.chiangraicalling.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.fragment.OnlineFragment;
import com.devdrunk.chiangraicalling.fragment.TypeFragment;

public class TypeActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        initInstances();

        AmpureItemDao dao = getIntent().getParcelableExtra("dao");




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, TypeFragment.newInstance(dao))             //แปะ fragment
                    .commit();
        }
    }




    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);         // set toolbar
        setSupportActionBar(toolbar);                           // set toolbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo_app);
        actionBar.setDisplayUseLogoEnabled(true);
       // actionBar.setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // if(item.getItemId() == ){
       //     finish();
       //     return true;
       // }

        return super.onOptionsItemSelected(item);
    }
}
