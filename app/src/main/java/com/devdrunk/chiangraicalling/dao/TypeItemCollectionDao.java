package com.devdrunk.chiangraicalling.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class TypeItemCollectionDao implements Parcelable{
    @SerializedName("success")  private boolean success;
    @SerializedName("data")     private List<TypeItemDao> data;

    public TypeItemCollectionDao (){}
    protected TypeItemCollectionDao(Parcel in) {
        success = in.readByte() != 0;
        data = in.createTypedArrayList(TypeItemDao.CREATOR);
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

    public static final Creator<TypeItemCollectionDao> CREATOR = new Creator<TypeItemCollectionDao>() {
        @Override
        public TypeItemCollectionDao createFromParcel(Parcel in) {
            return new TypeItemCollectionDao(in);
        }

        @Override
        public TypeItemCollectionDao[] newArray(int size) {
            return new TypeItemCollectionDao[size];
        }
    };

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<TypeItemDao> getData() {
        return data;
    }

    public void setData(List<TypeItemDao> data) {
        this.data = data;
    }
}
