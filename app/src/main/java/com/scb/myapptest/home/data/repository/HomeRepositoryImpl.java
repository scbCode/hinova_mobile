package com.scb.myapptest.home.data.repository;

import android.util.Log;

import com.google.gson.Gson;
import com.scb.myapptest.home.data.api.Api;
import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.data.models.OficinaResponse;
import com.scb.myapptest.home.domain.repositories.HomeRepository;

import javax.inject.Inject;

import okhttp3.RequestBody;
import retrofit2.Call;

public class HomeRepositoryImpl implements  HomeRepository {

    Api api;

    @Inject
    public HomeRepositoryImpl(Api api){
        this.api = api;
    }

    @Override
        public Call<OficinaResponse>   get(String cod) {
        return api.getAll(cod);
    }

    @Override
    public Call<IndicacaoResponse> postIndicacao(IndicacaoData indicacaoData) {
        Gson gson = new Gson();
        String json = gson.toJson(indicacaoData).replace("IndicacaoEntity","Indicacao");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
        return api.postIndicacao(body);
    }
}
