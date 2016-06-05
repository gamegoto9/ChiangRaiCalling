package com.devdrunk.chiangraicalling.manager.http;

import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiServiceType {
    @POST("gen_json_type.php")
    Call<TypeItemCollectionDao> loadTypeListData();
}
