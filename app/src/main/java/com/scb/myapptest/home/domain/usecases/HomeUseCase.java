package com.scb.myapptest.home.domain.usecases;

import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.data.models.OficinaResponse;
import com.scb.myapptest.home.domain.repositories.HomeRepository;

import javax.inject.Inject;

import retrofit2.Call;

public class HomeUseCase implements  HomeRepository {

    HomeRepository homeRepository;

    @Inject
    public HomeUseCase(HomeRepository homeRepository){
        this.homeRepository=homeRepository;
    }

    @Inject
    public Call<OficinaResponse>  get(String cod){
        return  homeRepository.get(cod);
    }

    @Override
    public Call<IndicacaoResponse> postIndicacao(IndicacaoData indicacaoData) {
        return homeRepository.postIndicacao(indicacaoData);
    }
}
