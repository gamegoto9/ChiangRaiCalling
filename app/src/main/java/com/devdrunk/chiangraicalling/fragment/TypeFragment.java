package com.devdrunk.chiangraicalling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
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

    public interface FragmentListener{
        void onTypeItemClicked(TypeItemDao dao,String amphurId);
    }


    AmpureItemDao dao;
    ListView listView;
    String locationId;
    SearchView searchView;
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
        searchView = (SearchView) rootView.findViewById(R.id.searchData);


        locationId = dao.getProvinceId();

        //Toast.makeText(getContext(),locationId,Toast.LENGTH_SHORT).show();

        CallServer();

        searchView.setOnQueryTextListener(listener);


        listView.setOnItemClickListener(OnclickItemListview);

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

    public void CallServer(){
        Call<TypeItemCollectionDao> call = HttpManagerType.getInstance()
                .getService()
                .loadTypeListData(Integer.parseInt(locationId));
        call.enqueue(new Callback<TypeItemCollectionDao>() {
            @Override
            public void onResponse(Call<TypeItemCollectionDao> call, Response<TypeItemCollectionDao> response) {
                //ติดต่อ server สำเร็จ
                if(response.body().getData() == null){
                    //Log.e("null = == =  = = ","Null");
                    Toast.makeText(Contextor.getInstance().getContext(),"* ไม่มีข้อมูลในระบบ *",
                            Toast.LENGTH_SHORT).show();


                }else {
                    if (response.isSuccessful()) {
                        TypeItemCollectionDao dao = response.body();
                        TypeListManager.getInstance().setDao(dao);

                        List<TypeItemDao> items = TypeListManager.getInstance().getDao().getData();
                        listAdapter = new TypeListAdapter(items);

                        //listAdapter.setDao(AmpureListManager.getInstance().getDao())
                        listView.setAdapter(listAdapter);


                        //listAdapter.notifyDataSetChanged();
                        /*
                        Toast.makeText(Contextor.getInstance().getContext(),
                                dao.getData().get(0).gettName(),
                                Toast.LENGTH_LONG)
                                .show();
                                */
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

    final SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
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
    };

    final AdapterView.OnItemClickListener OnclickItemListview = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            if(i < TypeListManager.getInstance().getCount()) {
                TypeItemDao dao = (TypeItemDao) listAdapter.getItem(i);
                FragmentListener listener = (FragmentListener) getActivity();
                listener.onTypeItemClicked(dao,locationId);
               // Toast.makeText(getContext(),dao.gettId()+" : To : "+locationId,Toast.LENGTH_SHORT).show();
            }

        }
    };

}
