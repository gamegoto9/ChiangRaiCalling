package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypePlanceItemCollectionDao {
    @SerializedName("success")  private boolean success;
    @SerializedName("data")     private List<TypePlanceItemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<TypePlanceItemDao> getData() {
        return data;
    }

    public void setData(List<TypePlanceItemDao> data) {
        this.data = data;
    }


}
