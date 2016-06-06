package com.devdrunk.chiangraicalling.manager;

import android.content.Context;

import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypePlanceItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class TypePlanceListManager {

    private static TypePlanceListManager instance;

    public static TypePlanceListManager getInstance() {
        if (instance == null)
            instance = new TypePlanceListManager();
        return instance;
    }

    private Context mContext;
    private TypePlanceItemCollectionDao dao;

    private TypePlanceListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public TypePlanceItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(TypePlanceItemCollectionDao dao) {
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
