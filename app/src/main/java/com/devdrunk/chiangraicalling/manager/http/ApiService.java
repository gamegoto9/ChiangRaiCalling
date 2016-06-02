package com.devdrunk.chiangraicalling.manager.http;

import com.devdrunk.chiangraicalling.dao.AmpureItemCollectionDao;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by CRRU0001 on 02/06/2559.
 */
public interface ApiService {
    @POST("gen_json.php")
    Call<AmpureItemCollectionDao>loadAmpureList();
}
