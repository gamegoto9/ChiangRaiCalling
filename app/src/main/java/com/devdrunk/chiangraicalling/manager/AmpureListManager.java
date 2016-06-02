package com.devdrunk.chiangraicalling.manager;

import android.content.Context;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AmpureListManager {

    private static AmpureListManager instance;

    public static AmpureListManager getInstance() {
        if (instance == null)
            instance = new AmpureListManager();
        return instance;
    }

    private Context mContext;
    private AmpureItemCollectionDao dao;

    private AmpureListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public AmpureItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(AmpureItemCollectionDao dao) {
        this.dao = dao;
    }
}
