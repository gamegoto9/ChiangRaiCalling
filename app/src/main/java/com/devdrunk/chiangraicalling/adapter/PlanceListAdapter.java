package com.devdrunk.chiangraicalling.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import com.devdrunk.chiangraicalling.dao.PlanceItemDao;
import com.devdrunk.chiangraicalling.manager.PlanceListManager;
import com.devdrunk.chiangraicalling.view.PlanceListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class PlanceListAdapter extends BaseAdapter implements Filterable,Parcelable {

    List<PlanceItemDao> orgData;
    List<PlanceItemDao> filterData;

    private int parcelData;

    public PlanceListAdapter(List<PlanceItemDao> itemDao) {
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

    public static final Parcelable.Creator<PlanceListAdapter> CREATOR = new Parcelable.Creator<PlanceListAdapter>() {
        public PlanceListAdapter createFromParcel(Parcel in) {
            return new PlanceListAdapter(in);
        }

        public PlanceListAdapter[] newArray(int size) {
            return new PlanceListAdapter[size];
        }
    };

    private PlanceListAdapter(Parcel in) {
        parcelData = in.readInt();
    }
    //End Parcel

    @Override
    public int getCount() {
        return filterData.size();
    }


    @Override
    public Object getItem(int i) {
        return filterData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(filterData.get(i).getLocationId());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PlanceListItem item;
        if(view != null)
            item = (PlanceListItem) view;
        else
            item = new PlanceListItem(viewGroup.getContext());

        PlanceItemDao dao = (PlanceItemDao) getItem(i);
        item.setNameText(dao.getLocationName());
        item.setTelText(dao.getLocationTel());



        return item;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filterData = (List<PlanceItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<PlanceItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (PlanceItemDao searchingContact : orgData) {

                    if (searchingContact.getLocationName().contains(constraint)) {
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
