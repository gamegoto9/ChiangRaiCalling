package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class PlanceOfflineItemDao {
    public int lId;
    public String lName;
    public String lTel;
    public int lType;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlTel() {
        return lTel;
    }

    public void setlTel(String lTel) {
        this.lTel = lTel;
    }

    public int getlType() {
        return lType;
    }

    public void setlType(int lType) {
        this.lType = lType;
    }
}
