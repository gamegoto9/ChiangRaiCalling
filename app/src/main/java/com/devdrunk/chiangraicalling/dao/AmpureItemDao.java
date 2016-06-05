package com.devdrunk.chiangraicalling.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class AmpureItemDao implements Parcelable{
    @SerializedName("province_id")      private String provinceId;
    @SerializedName("province_name")    private String provinceName;


    public AmpureItemDao(){

    }

    protected AmpureItemDao(Parcel in) {
        provinceId = in.readString();
        provinceName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(provinceId);
        dest.writeString(provinceName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AmpureItemDao> CREATOR = new Creator<AmpureItemDao>() {
        @Override
        public AmpureItemDao createFromParcel(Parcel in) {
            return new AmpureItemDao(in);
        }

        @Override
        public AmpureItemDao[] newArray(int size) {
            return new AmpureItemDao[size];
        }
    };

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


}
