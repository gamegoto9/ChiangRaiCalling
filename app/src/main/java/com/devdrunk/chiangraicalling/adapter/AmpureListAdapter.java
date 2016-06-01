package com.devdrunk.chiangraicalling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devdrunk.chiangraicalling.view.AmpureListItem;

/**
 * Created by CRRU0001 on 01/06/2559.
 */
public class AmpureListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 10000;
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
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 0 : 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(getItemViewType(position) == 0){
            AmpureListItem item;
            if(convertView != null)
                item = (AmpureListItem) convertView;
            else
                item = new AmpureListItem(parent.getContext());
            return item;
        }else{
            TextView item;
            if(convertView != null)
                item = (TextView) convertView;
            else
                item = new TextView(parent.getContext());
            item.setText("position:" + position);
            return item;
        }
    }
}
