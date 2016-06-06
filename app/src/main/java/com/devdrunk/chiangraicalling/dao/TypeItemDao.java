package com.devdrunk.chiangraicalling.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypeItemDao implements Parcelable{
    @SerializedName("tId")      private int tId;
    @SerializedName("tName")    private String tName;
    @SerializedName("tImg")    private String tImg;

    public TypeItemDao(){}


    protected TypeItemDao(Parcel in) {
        tId = in.readInt();
        tName = in.readString();
        tImg = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tId);
        dest.writeString(tName);
        dest.writeString(tImg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TypeItemDao> CREATOR = new Creator<TypeItemDao>() {
        @Override
        public TypeItemDao createFromParcel(Parcel in) {
            return new TypeItemDao(in);
        }

        @Override
        public TypeItemDao[] newArray(int size) {
            return new TypeItemDao[size];
        }
    };

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
