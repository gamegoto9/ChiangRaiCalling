package com.devdrunk.chiangraicalling.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypeOfflineItemDao implements Parcelable{
    public int tId;
    public String tName;


    public TypeOfflineItemDao(){}


    protected TypeOfflineItemDao(Parcel in) {
        tId = in.readInt();
        tName = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tId);
        dest.writeString(tName);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TypeOfflineItemDao> CREATOR = new Creator<TypeOfflineItemDao>() {
        @Override
        public TypeOfflineItemDao createFromParcel(Parcel in) {
            return new TypeOfflineItemDao(in);
        }

        @Override
        public TypeOfflineItemDao[] newArray(int size) {
            return new TypeOfflineItemDao[size];
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


}
