package com.devdrunk.chiangraicalling.manager;

import android.content.Context;

import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class TypeListManager {

    private static TypeListManager instance;

    public static TypeListManager getInstance() {
        if (instance == null)
            instance = new TypeListManager();
        return instance;
    }

    private Context mContext;
    private TypeItemCollectionDao dao;

    private TypeListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public TypeItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(TypeItemCollectionDao dao) {
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
