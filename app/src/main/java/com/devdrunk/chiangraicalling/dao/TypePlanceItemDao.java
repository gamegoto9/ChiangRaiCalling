package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypePlanceItemDao {
    @SerializedName("lId")          private int lId;
    @SerializedName("lName")        private String lName;
    @SerializedName("lTel")         private String lTel;
    @SerializedName("lAddress")     private String lAddress;
    @SerializedName("lCodeMap")     private String lCodeMap;
    @SerializedName("lDistrict")    private int lDistrict;
    @SerializedName("lType")        private int lType;

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

    public String getlAddress() {
        return lAddress;
    }

    public void setlAddress(String lAddress) {
        this.lAddress = lAddress;
    }

    public String getlCodeMap() {
        return lCodeMap;
    }

    public void setlCodeMap(String lCodeMap) {
        this.lCodeMap = lCodeMap;
    }

    public int getlDistrict() {
        return lDistrict;
    }

    public void setlDistrict(int lDistrict) {
        this.lDistrict = lDistrict;
    }

    public int getlType() {
        return lType;
    }

    public void setlType(int lType) {
        this.lType = lType;
    }
}
