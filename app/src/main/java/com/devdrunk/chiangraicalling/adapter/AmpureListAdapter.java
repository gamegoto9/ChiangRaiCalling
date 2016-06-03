package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;
import com.devdrunk.chiangraicalling.manager.AmpureListManager;
import com.devdrunk.chiangraicalling.view.AmpureListItem;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class AmpureListAdapter extends BaseAdapter implements Filterable {

    Context context;
    AmpureListManager ampureItemDao;
    AmpureListManager ampureListManager;

    public AmpureListAdapter(Context context, AmpureListManager ampureItemDao) {
        this.context = context;
        this.ampureItemDao = ampureItemDao;
        this.ampureListManager = ampureItemDao;
    }

    @Override
    public int getCount() {
        if (AmpureListManager.getInstance().getDao() == null)
            return 0;
        if (AmpureListManager.getInstance().getDao().getData() == null)
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

        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint != null && constraint.length() > 0) {


                    AmpureListManager filterList = new AmpureListManager();

                    for (int i = 0; i < AmpureListManager.getInstance().getDao().getData().size(); i++) {
                        if ((AmpureListManager.getInstance().getDao().getData().get(i).getProvinceName().toUpperCase())
                                .contains(constraint.toString().toUpperCase())) {

                            AmpureItemCollectionDao dao = new AmpureItemCollectionDao();


                            dao.setData(ampureListManager.getInstance().getDao().getData());

                            filterList.getInstance().setDao(dao);


                        }
                    }
                    results.count = filterList.getInstance().getDao().getData().size();
                    results.values = filterList;
                } else {
                    results.count = AmpureListManager.getInstance().getDao().getData().size();
                    results.values = AmpureListManager.getInstance().getDao().getData();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                ampureItemDao = (AmpureListManager) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
