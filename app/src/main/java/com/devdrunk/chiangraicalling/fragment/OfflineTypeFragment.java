package com.devdrunk.chiangraicalling.fragment;

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
import android.widget.SearchView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class OfflineTypeFragment extends Fragment {

    ListView listView;
    SearchView searchView;

    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor mCursor;

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


        mHelper = new MyDbHelper(Contextor.getInstance().getContext());
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        mCursor = mDb.rawQuery("SELECT " + MyDbHelper.COL_NAME + ", "
                + MyDbHelper.COL_PIECE_PRICE + ", " + MyDbHelper.COL_CAKE_PRICE
                + " FROM " + MyDbHelper.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();

        mCursor.moveToFirst();
        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_NAME)) + "\n"
                    + "Piece : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_PIECE_PRICE)) + "\t\t"
                    + "Cake : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_CAKE_PRICE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(Contextor.getInstance().getContext()
                ,R.layout.list_item_type, dirArray);
        listView.setAdapter(adapterDir);



    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
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

}
