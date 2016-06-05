package com.devdrunk.chiangraicalling.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public class PlanceItemDao {
    @SerializedName("location_id")      private String locationId;
    @SerializedName("location_name")    private String locationName;
    @SerializedName("location_tel")    private String locationTel;
    @SerializedName("location_address")    private String locationAddress;
    @SerializedName("location_icon")    private String locationIcon;
    @SerializedName("location_code_map")    private String locationCodeMap;
    @SerializedName("location_district")    private String locationdistrice;
    @SerializedName("location_type")    private String locationType;


    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationTel() {
        return locationTel;
    }

    public void setLocationTel(String locationTel) {
        this.locationTel = locationTel;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationIcon() {
        return locationIcon;
    }

    public void setLocationIcon(String locationIcon) {
        this.locationIcon = locationIcon;
    }

    public String getLocationCodeMap() {
        return locationCodeMap;
    }

    public void setLocationCodeMap(String locationCodeMap) {
        this.locationCodeMap = locationCodeMap;
    }

    public String getLocationdistrice() {
        return locationdistrice;
    }

    public void setLocationdistrice(String locationdistrice) {
        this.locationdistrice = locationdistrice;
    }
}
