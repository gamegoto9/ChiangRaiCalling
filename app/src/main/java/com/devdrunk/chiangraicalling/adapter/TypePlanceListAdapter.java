package com.devdrunk.chiangraicalling.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.PlanceItemDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.dao.TypePlanceItemDao;
import com.devdrunk.chiangraicalling.view.PlanceListItem;
import com.devdrunk.chiangraicalling.view.TypeListItem;
import com.devdrunk.chiangraicalling.view.TypePlanceListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class TypePlanceListAdapter extends BaseAdapter implements Filterable ,Parcelable{

    List<TypePlanceItemDao> orgData;
    List<TypePlanceItemDao> filterData;

    private int parcelData;
    AmpureItemCollectionDao dao;


   // public void setDao(AmpureItemCollectionDao dao) {
   //     this.dao = dao;
   // }

    public TypePlanceListAdapter(List<TypePlanceItemDao> itemDao ) {
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

    public static final Creator<TypePlanceListAdapter> CREATOR = new Creator<TypePlanceListAdapter>() {
        public TypePlanceListAdapter createFromParcel(Parcel in) {
            return new TypePlanceListAdapter(in);
        }

        public TypePlanceListAdapter[] newArray(int size) {
            return new TypePlanceListAdapter[size];
        }
    };

    private TypePlanceListAdapter(Parcel in) {
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
        return filterData.get(i).getlId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TypePlanceListItem item;
        if (convertView != null)
            item = (TypePlanceListItem) convertView;
        else
            item = new TypePlanceListItem(parent.getContext());

        TypePlanceItemDao dao = (TypePlanceItemDao) getItem(position);
        item.setNameText(dao.getlName());
        item.setTelText(dao.getlTel());

        return item;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filterData = (List<TypePlanceItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<TypePlanceItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (TypePlanceItemDao searchingContact : orgData) {

                    if (searchingContact.getlName().contains(constraint)) {
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

