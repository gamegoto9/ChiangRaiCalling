package com.devdrunk.chiangraicalling.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.PlanceListAdapter;
import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.PlanceItemDao;
import com.devdrunk.chiangraicalling.manager.AmpureListManager;
import com.devdrunk.chiangraicalling.manager.PlanceListManager;
import com.devdrunk.chiangraicalling.manager.http.HttpManager;
import com.devdrunk.chiangraicalling.manager.http.HttpManagerPlance;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class PlanceFragment extends Fragment {


    ListView listView;
    SearchView searchView;
    PlanceListAdapter listAdapter;
    ProgressBar progressBar;

    public PlanceFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static PlanceFragment newInstance() {
        PlanceFragment fragment = new PlanceFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_plance, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView) rootView.findViewById(R.id.listView);
        searchView = (SearchView) rootView.findViewById(R.id.searchData);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressbar);




        CallServer();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                ViewGroup vg = (ViewGroup) view;
                ImageView imgCall = (ImageView) vg.findViewById(R.id.imvCall);
                ImageView imgMap = (ImageView) vg.findViewById(R.id.imvProfile);

                /*
                imgCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+PlanceListManager.getInstance()
                        .getDao().getData().get(position).getLocationTel()));
                        startActivity(intent);
                    }
                });
                */
                imgMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(position < PlanceListManager.getInstance().getCount()) {
                            PlanceItemDao dao = PlanceListManager.getInstance().getDao().getData().get(position);
                            String leg_log = dao.getLocationCodeMap();
                            String planceName = dao.getLocationName();
                            String planceAddress = dao.getLocationAddress();

                            //Toast.makeText(getContext(),planceName,Toast.LENGTH_SHORT).show();

/*
                            Uri gmmIntentUri = Uri.parse("geo:"+leg_log+"?z=18");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            startActivity(mapIntent.createChooser(mapIntent,planceName));
*/

                            String strUri = "http://maps.google.com/maps?q=loc:" + leg_log + " (" + planceName + ")";
                            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                            startActivity(intent);

                        }
                    }
                });

                imgCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(position < PlanceListManager.getInstance().getCount()) {
                            PlanceItemDao dao = PlanceListManager.getInstance().getDao().getData().get(position);
                            Toast.makeText(getContext(),dao.getLocationTel(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                String criteria = newText.toString();
                listAdapter.getFilter().filter(criteria);

                return false;
            }
        });
        //listAdapter = new PlanceListAdapter();
        //listView.setAdapter(listAdapter);




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
        outState.putParcelable("listAdapter", listAdapter);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
        listAdapter = savedInstanceState.getParcelable("listAdapter");
    }

    public void CallServer(){
        Call<PlanceItemCollectionDao> call = HttpManagerPlance.getInstance().getServicePlance().loadPlanceList();

        call.enqueue(new Callback<PlanceItemCollectionDao>() {
            @Override
            public void onResponse(Call<PlanceItemCollectionDao> call, Response<PlanceItemCollectionDao> response) {
                //ติดต่อ server สำเร็จ
                if (response.isSuccessful()) {
                    PlanceItemCollectionDao dao = response.body();
                    PlanceListManager.getInstance().setDao(dao);

                    List<PlanceItemDao> items = PlanceListManager.getInstance().getDao().getData();
                    listAdapter = new PlanceListAdapter(items);

                    listView.setAdapter(listAdapter);
                    //listAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Contextor.getInstance().getContext(),
                            dao.getData().get(0).getLocationId(),
                            Toast.LENGTH_LONG)
                            .show();
                }else{
                    try {
                        Toast.makeText(Contextor.getInstance().getContext(),
                                response.errorBody().string(),
                                Toast.LENGTH_LONG)
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<PlanceItemCollectionDao> call, Throwable t) {
                //ติดต่อ server ไม่สำเร็จ
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.toString(),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

}
