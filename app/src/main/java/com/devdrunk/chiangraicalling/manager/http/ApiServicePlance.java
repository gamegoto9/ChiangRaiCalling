package com.devdrunk.chiangraicalling.manager.http;

import com.devdrunk.chiangraicalling.dao.PlanceItemCollectionDao;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiServicePlance{
    @POST("gen_json_plance.php")
    Call<PlanceItemCollectionDao> loadPlanceList();
}
