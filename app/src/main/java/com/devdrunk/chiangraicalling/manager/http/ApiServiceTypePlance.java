package com.devdrunk.chiangraicalling.manager.http;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;
import com.devdrunk.chiangraicalling.dao.TypePlanceItemCollectionDao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public interface ApiServiceTypePlance {
    @FormUrlEncoded
    @POST("gen_json_type_plance.php")
    Call<TypePlanceItemCollectionDao> selectTypePlance(
            @Field("amphurId") int amphurId,
            @Field("typeId") int typeId
    );


}


