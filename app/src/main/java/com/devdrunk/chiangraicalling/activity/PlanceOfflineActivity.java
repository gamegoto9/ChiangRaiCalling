package com.devdrunk.chiangraicalling.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.fragment.OfflineTypePlanceFragment;

public class PlanceOfflineActivity extends AppCompatActivity {

    Toolbar toolbar;
    String typeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plance_offline);

        String typeId = getIntent().getStringExtra("typeId");
        typeName = getIntent().getStringExtra("typeName");
        initInstances();



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, OfflineTypePlanceFragment.newInstance(typeId))
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
        actionBar.setTitle(typeName);

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
}