package com.devdrunk.chiangraicalling.manager.http;

import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypeItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceType {
    @FormUrlEncoded
    @POST("gen_json_type.php")
    Call<TypeItemCollectionDao> loadTypeListData(
            @Field("amphurId") int amphurId
    );
}
