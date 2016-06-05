package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypeItemDao {
    @SerializedName("tId")      private int tId;
    @SerializedName("tName")    private String tName;
    @SerializedName("tImg")    private String tImg;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettImg() {
        return tImg;
    }

    public void settImg(String tImg) {
        this.tImg = tImg;
    }
}
