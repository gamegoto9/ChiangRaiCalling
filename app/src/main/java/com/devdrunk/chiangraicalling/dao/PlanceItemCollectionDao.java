package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class PlanceItemCollectionDao {
    @SerializedName("success")  private boolean success;
    @SerializedName("data")     private List<PlanceItemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PlanceItemDao> getData() {
        return data;
    }

    public void setData(List<PlanceItemDao> data) {
        this.data = data;
    }
}
