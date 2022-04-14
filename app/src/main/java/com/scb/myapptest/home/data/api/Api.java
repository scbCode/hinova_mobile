package com.scb.myapptest.home.data.api;


import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.data.models.OficinaResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("api/Oficina?cpfAssociado=")
    Call<OficinaResponse>  getAll(@Query("codigoAssociacao") String codigoAssociacao);

    @POST("api/Indicacao")
    Call<IndicacaoResponse> postIndicacao(@Body RequestBody body);

}
