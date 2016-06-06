package com.devdrunk.chiangraicalling.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.fragment.TypeFragment;
import com.devdrunk.chiangraicalling.fragment.TypePlanceFragment;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

public class TypePlanActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_plan);

        initInstances();

        TypeItemDao dao = getIntent().getParcelableExtra("dao");
        String amphurId = getIntent().getStringExtra("amphurId");

        //Toast.makeText(Contextor.getInstance().getContext(),"TTTTTTTTTTTTTT : "+amphurId,Toast.LENGTH_SHORT).show();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, TypePlanceFragment.newInstance(dao,amphurId))             //แปะ fragment
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
