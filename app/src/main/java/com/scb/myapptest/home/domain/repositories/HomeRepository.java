package com.scb.myapptest.home.domain.repositories;

import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.data.models.OficinaResponse;

import retrofit2.Call;

public interface HomeRepository {
    Call<OficinaResponse> get(String cod);
    Call<IndicacaoResponse> postIndicacao(IndicacaoData indicacaoData);
}
