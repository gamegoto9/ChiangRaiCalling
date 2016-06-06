package com.devdrunk.chiangraicalling.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.AmpureListAdapter;
import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.manager.AmpureListManager;
import com.devdrunk.chiangraicalling.manager.http.HttpManager;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class AmpureFragment extends Fragment {

    public interface FragmentListener{
        void onAmpureItemClicked(AmpureItemDao dao);
    }


    ListView listView;
    AmpureListAdapter listAdapter;
    android.widget.SearchView searchView;
    ProgressBar progressBar;


    public AmpureFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static AmpureFragment newInstance() {
        AmpureFragment fragment = new AmpureFragment();
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
    private void initInstances(View rootView, final Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here

        listView = (ListView) rootView.findViewById(R.id.listView);
        searchView = (android.widget.SearchView) rootView.findViewById(R.id.searchData);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressbar);

        progressBar.getProgressDrawable().setColorFilter(
                Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        CellServer();

        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position < AmpureListManager.getInstance().getCount()) {
                    AmpureItemDao dao = (AmpureItemDao) listAdapter.getItem(position);
                    FragmentListener listener = (FragmentListener) getActivity();
                    listener.onAmpureItemClicked(dao);
                }
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





    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Onstop :", "Onstop+++");
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
/*
        outState.putBundle("AmpureListManager",AmpureListManager
                .getInstance()
                .onSaveInstanceState());
*/
//        Log.e("Onsave :", criteria.toString());
//        outState.putString("criteria", criteria.toString());
        outState.putParcelable("listAdapter", listAdapter);


    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
        /*
        AmpureListManager.getInstance().OnRestoreInstanceState(
                savedInstanceState.getBundle("AmpureListManager")
        );
        */

 //       criteria = savedInstanceState.getString("criteria");
 //       Log.e("OnRestore :", criteria);
        listAdapter = savedInstanceState.getParcelable("listAdapter");

    }

    private void CellServer (){
        Call<AmpureItemCollectionDao> call = HttpManager.getInstance().getService().loadAmpureList();
        call.enqueue(new Callback<AmpureItemCollectionDao>() {
            @Override
            public void onResponse(Call<AmpureItemCollectionDao> call,
                                   Response<AmpureItemCollectionDao> response) {
                //ติดต่อ server สำเร็จ
                if (response.isSuccessful()) {
                    AmpureItemCollectionDao dao = response.body();
                    AmpureListManager.getInstance().setDao(dao);

                    List<AmpureItemDao> items = AmpureListManager.getInstance().getDao().getData();
                    listAdapter = new AmpureListAdapter(items);

                    //listAdapter.setDao(AmpureListManager.getInstance().getDao());

                    listView.setAdapter(listAdapter);

                    progressBar.setVisibility(View.GONE);

                    //listAdapter.notifyDataSetChanged();
                    Toast.makeText(Contextor.getInstance().getContext(),
                            dao.getData().get(0).getProvinceId(),
                            Toast.LENGTH_LONG)
                            .show();
                } else {
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
            public void onFailure(Call<AmpureItemCollectionDao> call,
                                  Throwable t) {
                //ติดต่อ server ไม่สำเร็จ
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.toString(),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }


}
