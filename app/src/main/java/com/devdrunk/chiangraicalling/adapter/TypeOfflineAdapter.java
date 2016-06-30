package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.TypeOfflineItemDao;
import com.devdrunk.chiangraicalling.view.OfflineTypeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRRU0001 on 08/06/2559.
 */
public class TypeOfflineAdapter extends BaseAdapter implements Filterable,Parcelable{

    Context context;

    List<TypeOfflineItemDao> searchData;
    List<TypeOfflineItemDao> values;
    private int parcelData;

    public TypeOfflineAdapter(Context context, List<TypeOfflineItemDao> values) {
        //super(context, R.layout.rowlayout, values);

        this.context = context;
        this.values = values;
        this.searchData = values;
    }

    //Parcel เป็นการแปลง Object
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(parcelData);
    }

    public static final Creator<TypeOfflineAdapter> CREATOR = new Creator<TypeOfflineAdapter>() {
        public TypeOfflineAdapter createFromParcel(Parcel in) {
            return new TypeOfflineAdapter(in);
        }

        public TypeOfflineAdapter[] newArray(int size) {
            return new TypeOfflineAdapter[size];
        }
    };

    private TypeOfflineAdapter(Parcel in) {
        parcelData = in.readInt();
    }
    //End Parcel

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return values.get(i).tId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OfflineTypeListItem item;
        if (view != null)
            item = (OfflineTypeListItem) view;
        else
            item = new OfflineTypeListItem(viewGroup.getContext());

        TypeOfflineItemDao dao = (TypeOfflineItemDao) getItem(i);
        item.setName(dao.gettName());
        item.setId(dao.gettId());
        item.setImgProfile(dao.gettId());

        return item;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                values = (List<TypeOfflineItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<TypeOfflineItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (TypeOfflineItemDao searchingContact : searchData) {

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
