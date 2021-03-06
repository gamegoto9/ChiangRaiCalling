package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.manager.AmpureListManager;
import com.devdrunk.chiangraicalling.view.AmpureListItem;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class AmpureListAdapter extends BaseAdapter implements Filterable ,Parcelable{

    List<AmpureItemDao> orgData;
    List<AmpureItemDao> filterData;

    private int parcelData;
    AmpureItemCollectionDao dao;


   // public void setDao(AmpureItemCollectionDao dao) {
   //     this.dao = dao;
   // }

    public AmpureListAdapter(List<AmpureItemDao> itemDao) {
        orgData = itemDao;
        filterData = itemDao;
    }

    //Parcel เป็นการแปลง Object
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(parcelData);
    }

    public static final Parcelable.Creator<AmpureListAdapter> CREATOR = new Parcelable.Creator<AmpureListAdapter>() {
        public AmpureListAdapter createFromParcel(Parcel in) {
            return new AmpureListAdapter(in);
        }

        public AmpureListAdapter[] newArray(int size) {
            return new AmpureListAdapter[size];
        }
    };

    private AmpureListAdapter(Parcel in) {
        parcelData = in.readInt();
    }
    //End Parcel


    @Override
    public int getCount() {
/*
        if(AmpureListManager.getInstance().getDao() == null)
            return 0;
        if(AmpureListManager.getInstance().getDao().getData() == null)
            return 0;
        return AmpureListManager.getInstance().getDao().getData().size();
        */
        return filterData.size();
    }

    @Override
    public Object getItem(int i) {
        return filterData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(filterData.get(i).getProvinceId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AmpureListItem item;
        if (convertView != null)
            item = (AmpureListItem) convertView;
        else
            item = new AmpureListItem(parent.getContext());

        AmpureItemDao dao = (AmpureItemDao) getItem(position);
        item.setNameText(dao.getProvinceName());

        return item;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filterData = (List<AmpureItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<AmpureItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (AmpureItemDao searchingContact : orgData) {

                    if (searchingContact.getProvinceName().contains(constraint)) {
                        filteredResults.add(searchingContact);
                    }

                    //For Other Condition
                    /* else if(searchingContact.getProvinceId().contains(constraint))
                        filteredResults.add(searchingContact);*/

                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }
}

