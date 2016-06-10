package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.devdrunk.chiangraicalling.dao.PlanceOfflineItemDao;
import com.devdrunk.chiangraicalling.dao.TypeOfflineItemDao;
import com.devdrunk.chiangraicalling.view.OfflinePlanceListItem;
import com.devdrunk.chiangraicalling.view.OfflineTypeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CRRU0001 on 08/06/2559.
 */
public class PlanceOfflineAdapter extends BaseAdapter implements Filterable,Parcelable{

    Context context;

    List<PlanceOfflineItemDao> searchData;
    List<PlanceOfflineItemDao> values;
    private int parcelData;
    String typeId;

    public PlanceOfflineAdapter(Context context, List<PlanceOfflineItemDao> values,String typeId) {
        //super(context, R.layout.rowlayout, values);

        this.context = context;
        this.values = values;
        this.searchData = values;
        this.typeId = typeId;
    }

    //Parcel เป็นการแปลง Object
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(parcelData);
    }

    public static final Creator<PlanceOfflineAdapter> CREATOR = new Creator<PlanceOfflineAdapter>() {
        public PlanceOfflineAdapter createFromParcel(Parcel in) {
            return new PlanceOfflineAdapter(in);
        }

        public PlanceOfflineAdapter[] newArray(int size) {
            return new PlanceOfflineAdapter[size];
        }
    };

    private PlanceOfflineAdapter(Parcel in) {
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
        return values.get(i).getlId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OfflinePlanceListItem item;
        if (view != null)
            item = (OfflinePlanceListItem) view;
        else
            item = new OfflinePlanceListItem(viewGroup.getContext());

        PlanceOfflineItemDao dao = (PlanceOfflineItemDao) getItem(i);
        item.setNameText(dao.getlName());
        item.setTelText(dao.getlTel());

        item.setTextAmpureName(dao.getlName(),typeId);

        return item;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                values = (List<PlanceOfflineItemDao>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<PlanceOfflineItemDao> filteredResults = new ArrayList<>();

                // Filter any field with constraint
                for (PlanceOfflineItemDao searchingContact : searchData) {

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
