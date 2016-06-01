package com.devdrunk.chiangraicalling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.devdrunk.chiangraicalling.view.PlanceListItem;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class PlanceListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PlanceListItem item;
        if(view != null)
            item = (PlanceListItem) view;
        else
            item = new PlanceListItem(viewGroup.getContext());
        return item;
    }
}
