package com.devdrunk.chiangraicalling.manager;

import android.content.Context;
import android.os.Bundle;

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

    public AmpureListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public AmpureItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(AmpureItemCollectionDao dao) {
        this.dao = dao;
    }

    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    public Bundle onSaveInstanceState(){
        Bundle bundle = new Bundle();
        bundle.putParcelable("dao",dao);
        return null;
    }
    public void OnRestoreInstanceState(Bundle saveInstanceState){
        dao = saveInstanceState.getParcelable("dao");
    }

}
