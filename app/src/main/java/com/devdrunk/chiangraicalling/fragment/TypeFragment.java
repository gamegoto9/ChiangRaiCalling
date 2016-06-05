package com.devdrunk.chiangraicalling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.adapter.TypeListAdapter;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.manager.TypeListManager;
import com.devdrunk.chiangraicalling.manager.http.HttpManagerType;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class TypeFragment extends Fragment {

    AmpureItemDao dao;
    ListView listView;
    String locationId;
    TypeListAdapter listAdapter;

    public TypeFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static TypeFragment newInstance(AmpureItemDao dao) {
        TypeFragment fragment = new TypeFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao",dao);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        dao = getArguments().getParcelable("dao");

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_type, container, false);
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

        locationId = dao.getProvinceId();

        Toast.makeText(getContext(),locationId,Toast.LENGTH_SHORT).show();

        CallServer();

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
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    public void CallServer(){
        Call<TypeItemCollectionDao> call = HttpManagerType.getInstance().getService().loadTypeListData();
        call.enqueue(new Callback<TypeItemCollectionDao>() {
            @Override
            public void onResponse(Call<TypeItemCollectionDao> call, Response<TypeItemCollectionDao> response) {
                //ติดต่อ server สำเร็จ
                if (response.isSuccessful()) {
                    TypeItemCollectionDao dao = response.body();
                    TypeListManager.getInstance().setDao(dao);

                    List<TypeItemDao> items = TypeListManager.getInstance().getDao().getData();
                    listAdapter = new TypeListAdapter(items);

                    //listAdapter.setDao(AmpureListManager.getInstance().getDao());

                    listView.setAdapter(listAdapter);



                    //listAdapter.notifyDataSetChanged();
                    Toast.makeText(Contextor.getInstance().getContext(),
                            dao.getData().get(0).gettName(),
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
            public void onFailure(Call<TypeItemCollectionDao> call,
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
