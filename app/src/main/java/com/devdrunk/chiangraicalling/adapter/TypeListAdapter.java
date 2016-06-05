package com.devdrunk.chiangraicalling.adapter;

import android.animation.TypeEvaluator;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemDao;
import com.devdrunk.chiangraicalling.view.AmpureListItem;
import com.devdrunk.chiangraicalling.view.TypeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class TypeListAdapter extends BaseAdapter implements Filterable ,Parcelable{

    List<TypeItemDao> orgData;
    List<TypeItemDao> filterData;

    private int parcelData;
    AmpureItemCollectionDao dao;


   // public void setDao(AmpureItemCollectionDao dao) {
   //     this.dao = dao;
   // }

    public TypeListAdapter(List<TypeItemDao> itemDao ) {
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

    public static final Creator<TypeListAdapter> CREATOR = new Creator<TypeListAdapter>() {
        public TypeListAdapter createFromParcel(Parcel in) {
            return new TypeListAdapter(in);
        }

        public TypeListAdapter[] newArray(int size) {
            return new TypeListAdapter[size];
        }
    };

    private TypeListAdapter(Parcel in) {
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
        return filterData.get(i).gettId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TypeListItem item;
        if (convertView != null)
            item = (TypeListItem) convertView;
        else
            item = new TypeListItem(parent.getContext());

        TypeItemDao dao = (TypeItemDao) getItem(position);
        item.setNameText(dao.gettName());
        item.setImgProfile(dao.gettImg());
        item.setId(dao.gettId());

        return item;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filterData = (List<TypeItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<TypeItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (TypeItemDao searchingContact : orgData) {

                    if (searchingContact.gettName().contains(constraint)) {
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

