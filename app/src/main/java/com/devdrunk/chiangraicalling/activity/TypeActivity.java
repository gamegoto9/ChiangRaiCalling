package com.devdrunk.chiangraicalling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.fragment.OnlineFragment;
import com.devdrunk.chiangraicalling.fragment.TypeFragment;

public class TypeActivity extends AppCompatActivity implements TypeFragment.FragmentListener{

    Toolbar toolbar;
    AmpureItemDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        dao = getIntent().getParcelableExtra("dao");

        initInstances();




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, TypeFragment.newInstance(dao))             //แปะ fragment
                    .commit();
        }
    }




    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);         // set toolbar
        setSupportActionBar(toolbar);                           // set toolbar
        String pTitle = dao.getProvinceName();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.logo_app);
        actionBar.setDisplayUseLogoEnabled(true);
       // actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(pTitle);
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
    public void onTypeItemClicked(TypeItemDao dao,String amphurId) {
        Intent intent = new Intent(TypeActivity.this,
                TypePlanActivity.class);
        intent.putExtra("amphurId",amphurId);
        intent.putExtra("dao",dao);
        startActivity(intent);
    }
}
