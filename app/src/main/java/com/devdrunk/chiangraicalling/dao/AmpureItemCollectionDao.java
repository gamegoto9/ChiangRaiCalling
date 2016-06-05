package com.devdrunk.chiangraicalling.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class AmpureItemCollectionDao implements Parcelable{
    @SerializedName("success")  private boolean success;
    @SerializedName("data")     private List<AmpureItemDao> data;

    public AmpureItemCollectionDao(){

    }
    protected AmpureItemCollectionDao(Parcel in) {
        success = in.readByte() != 0;
        data = in.createTypedArrayList(AmpureItemDao.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AmpureItemCollectionDao> CREATOR = new Creator<AmpureItemCollectionDao>() {
        @Override
        public AmpureItemCollectionDao createFromParcel(Parcel in) {
            return new AmpureItemCollectionDao(in);
        }

        @Override
        public AmpureItemCollectionDao[] newArray(int size) {
            return new AmpureItemCollectionDao[size];
        }
    };

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<AmpureItemDao> getData() {
        return data;
    }

    public void setData(List<AmpureItemDao> data) {
        this.data = data;
    }
}
