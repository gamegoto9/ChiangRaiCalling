package com.devdrunk.chiangraicalling.manager;

import android.content.Context;

import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PlanceListManager {

    private static PlanceListManager instance;

    public static PlanceListManager getInstance() {
        if (instance == null)
            instance = new PlanceListManager();
        return instance;
    }

    private Context mContext;
    private PlanceItemCollectionDao dao;

    private PlanceListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public PlanceItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(PlanceItemCollectionDao dao) {
        this.dao = dao;
    }

    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }
}
