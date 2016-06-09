package com.devdrunk.chiangraicalling.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.activity.PlanceOfflineActivity;
import com.devdrunk.chiangraicalling.adapter.TypeOfflineAdapter;
import com.devdrunk.chiangraicalling.dao.TypeOfflineItemDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class OfflineTypeFragment extends Fragment {

    ListView listView;
    SearchView searchView;




    // Out custom adapter
    TypeOfflineAdapter adapter;

    // contains our listview items
    ArrayList<TypeOfflineItemDao> listItems;

    // database
    DatabaseHelper DatabaseHelper;

    // list of todo titles
    ArrayList<TypeOfflineItemDao> newData;

    // contains the id of the item we are about to delete
    public int deleteItem;

    public OfflineTypeFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static OfflineTypeFragment newInstance() {
        OfflineTypeFragment fragment = new OfflineTypeFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_offline, container, false);
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


        DatabaseHelper = new DatabaseHelper(Contextor.getInstance().getContext());

        // This returns a list of all our current available notes
        listItems = DatabaseHelper.getAllNotes();

        newData = new ArrayList<TypeOfflineItemDao>();

        // Assigning the title to our global property so we can access it
        // later after certain actions (deleting/adding)


        for (TypeOfflineItemDao note : listItems) {
            newData.add(note);
        }

        // We're initialising our custom adapter with all our data from the
        // database

        adapter = new TypeOfflineAdapter(Contextor.getInstance().getContext(), newData);

        // Assigning the adapter to ListView



        listView.setAdapter(adapter);


        // Assigning an event to the listview
        // This event will be used to delete records
        //listView.setOnItemLongClickListener(myClickListener);


        searchView.setOnQueryTextListener(SearchListener);

        listView.setOnItemClickListener(listener);

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
        outState.putParcelable("listAdapter", adapter);
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
        adapter = savedInstanceState.getParcelable("listAdapter");
    }

    final SearchView.OnQueryTextListener SearchListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            String criteria = s.toString();
            adapter.getFilter().filter(criteria);
            return false;
        }
    };

    final AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            TypeOfflineItemDao dao = (TypeOfflineItemDao) adapter.getItem(i);

            String typeId = String.valueOf(dao.gettId());
            Intent intent = new Intent(Contextor.getInstance().getContext(),
                    PlanceOfflineActivity.class);
            intent.putExtra("typeId",typeId);
            intent.putExtra("typeName",dao.gettName());
            startActivity(intent);

            //Contextor.getInstance().getContext().deleteDatabase("App");
            //Contextor.getInstance().getContext().deleteDatabase("App6");


        }
    };

}
