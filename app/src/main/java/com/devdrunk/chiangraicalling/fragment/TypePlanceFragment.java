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
import android.widget.SearchView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.activity.MainActivity;
import com.devdrunk.chiangraicalling.adapter.TypePlanceListAdapter;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.dao.TypePlanceItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypePlanceItemDao;
import com.devdrunk.chiangraicalling.manager.TypePlanceListManager;
import com.devdrunk.chiangraicalling.manager.http.ApiServiceTypePlance;
import com.devdrunk.chiangraicalling.manager.http.HttpManager;
import com.devdrunk.chiangraicalling.manager.http.HttpManagerTypePlance;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class TypePlanceFragment extends Fragment {

    public TypePlanceFragment() {
        super();
    }

    TypeItemDao  dao;
    public String amphurId;
    ListView listView;
    SearchView searchView;
    TypePlanceListAdapter listAdapter;

    @SuppressWarnings("unused")
    public static TypePlanceFragment newInstance(TypeItemDao dao,String amphurId) {
        TypePlanceFragment fragment = new TypePlanceFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao",dao);
        args.putString("amphurId",amphurId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        dao = getArguments().getParcelable("dao");
        amphurId = getArguments().getString("amphurId");


        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_type_plan, container, false);
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

        //int lId = dao.gettId();
        //Toast.makeText(getContext(),""+lId+"-------- "+amphurId,Toast.LENGTH_LONG).show();


        searchView.setOnQueryTextListener(searchItem);


        CallServer();


        listView.setOnItemClickListener(Onitemclicklistener);
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
        listAdapter = savedInstanceState.getParcelable("listAdapter");
        // Restore Instance State here
    }


    private void CallServer() {
        Call<TypePlanceItemCollectionDao> call = HttpManagerTypePlance
                .getInstance()
                .getService()
                .selectTypePlance(Integer.parseInt(amphurId),dao.gettId());
        call.enqueue(new Callback<TypePlanceItemCollectionDao>() {
            @Override
            public void onResponse(Call<TypePlanceItemCollectionDao> call, Response<TypePlanceItemCollectionDao> response) {
                //ติดต่อ server สำเร็จ
                if (response.isSuccessful()) {
                    TypePlanceItemCollectionDao dao = response.body();
                    TypePlanceListManager.getInstance().setDao(dao);

                    List<TypePlanceItemDao> items = TypePlanceListManager.getInstance().getDao().getData();
                    listAdapter = new TypePlanceListAdapter(items);

                    //listAdapter.setDao(AmpureListManager.getInstance().getDao());

                    listView.setAdapter(listAdapter);



                    //listAdapter.notifyDataSetChanged();
                    Toast.makeText(Contextor.getInstance().getContext(),
                            dao.getData().get(0).getlName(),
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
            public void onFailure(Call<TypePlanceItemCollectionDao> call, Throwable t) {
                //ติดต่อ server ไม่สำเร็จ
                Toast.makeText(Contextor.getInstance().getContext(),
                        t.toString(),
                        Toast.LENGTH_LONG)
                        .show();

            }
        });
    }

    final SearchView.OnQueryTextListener searchItem = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {

            String criteria = s.toString();
            listAdapter.getFilter().filter(criteria);
            return false;
        }
    };

    final AdapterView.OnItemClickListener Onitemclicklistener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

            ViewGroup vg = (ViewGroup) view;
            ImageView imgCall = (ImageView) vg.findViewById(R.id.imvCall);
            ImageView imgMap = (ImageView) vg.findViewById(R.id.imvProfile);


            imgMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(i < TypePlanceListManager.getInstance().getCount()) {
                        TypePlanceItemDao dao = (TypePlanceItemDao) listAdapter.getItem(i);
                        String leg_log = dao.getlCodeMap();
                        String planceName = dao.getlName();
                        String planceAddress = dao.getlAddress();


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
                    if(i < TypePlanceListManager.getInstance().getCount()) {
                        TypePlanceItemDao dao = (TypePlanceItemDao) listAdapter.getItem(i);
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+dao.getlTel()));
                        startActivity(intent);
                    }
                }
            });
        }
    };

}
