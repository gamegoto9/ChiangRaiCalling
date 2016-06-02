package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.manager.AmpureListManager;
import com.devdrunk.chiangraicalling.view.AmpureListItem;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class AmpureListAdapter extends BaseAdapter implements Filterable{

    Context context;
    ArrayList<AmpureItemDao> ampure;
    ValueFilter  valueFilter;
    ArrayList<AmpureItemDao> mStringFilterList;

    public AmpureListAdapter(Context context, ArrayList<AmpureItemDao> countrylist) {
        this.context = context;
        this.ampure = countrylist;
        mStringFilterList = countrylist;
    }
    @Override
    public int getCount() {
        if(AmpureListManager.getInstance().getDao() == null)
            return 0;
        if(AmpureListManager.getInstance().getDao().getData() == null)
            return 0;
        return AmpureListManager.getInstance().getDao().getData().size();
    }

    @Override
    public Object getItem(int i) {
        return AmpureListManager.getInstance().getDao().getData().get(i);
    }

    @Override
    public long getItemId(int i) {
        return AmpureListManager.getInstance().getDao().getData().indexOf(getItem(i));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            AmpureListItem item;
            if(convertView != null)
                item = (AmpureListItem) convertView;
            else
                item = new AmpureListItem(parent.getContext());

        AmpureItemDao dao = (AmpureItemDao) getItem(position);
        item.setNameText(dao.getProvinceName());

        return item;

    }

    @Override
    public Filter getFilter() {


        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }
    class ValueFilter  extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<AmpureItemDao> filterList = new ArrayList<AmpureItemDao>();

                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ( (mStringFilterList.get(i).getProvinceName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())) {

                        AmpureItemDao country = new AmpureItemDao(mStringFilterList.get(i)
                                .getProvinceName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ampure = (ArrayList<AmpureItemDao>) results.values;
            notifyDataSetChanged();
        }
    }
}
