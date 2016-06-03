package com.devdrunk.chiangraicalling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.dao.AmpureItemDao;

import java.util.ArrayList;

/**
 * Created by CRRU0001 on 03/06/2559.
 */
public class test extends BaseAdapter implements Filterable{

    Context c;
    ArrayList<AmpureItemDao> players;
    CustomFilter filter;
    ArrayList<AmpureItemDao> filterList;

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return players.indexOf(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_ampure,null);

        }
        TextView nameTxt = (TextView) convertView.findViewById(R.id.txtName);
        ImageView img = (ImageView) convertView.findViewById(R.id.imvProfile);

        nameTxt.setText(players.get(position).getProvinceName());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                ArrayList<AmpureItemDao> filters = new ArrayList<AmpureItemDao>();

                for(int i=0;i<filterList.size();i++){
                    if(filterList.get(i).getProvinceName().toUpperCase().contains(constraint)){
                        AmpureItemDao p = new AmpureItemDao(filterList.get(i).getProvinceName());
                        filters.add(p);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else{
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            players = (ArrayList<AmpureItemDao>) results.values;
            notifyDataSetChanged();
        }
    }
}
