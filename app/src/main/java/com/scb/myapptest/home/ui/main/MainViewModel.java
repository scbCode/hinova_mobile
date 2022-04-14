package com.scb.myapptest.home.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.scb.myapptest.home.data.models.ErroData;
import com.scb.myapptest.home.data.models.IndicacaoData;
import com.scb.myapptest.home.data.models.IndicacaoResponse;
import com.scb.myapptest.home.data.models.OficinaResponse;
import com.scb.myapptest.home.domain.models.OficinaEntity;
import com.scb.myapptest.home.domain.usecases.HomeUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class MainViewModel extends ViewModel {

    SavedStateHandle savedStateHandle;
    HomeUseCase homeUseCase;
    @Inject
    public MainViewModel(SavedStateHandle savedStateHandle,HomeUseCase homeUseCase)
    {
        this.savedStateHandle = savedStateHandle;
        this.homeUseCase = homeUseCase;
    }

    public MutableLiveData<List<OficinaEntity>> listaOficinas = new MutableLiveData<List<OficinaEntity>>();

    public LiveData<List<OficinaEntity>> getListOficinas(){
        return listaOficinas;
    }

    public MutableLiveData<IndicacaoResponse> indicacaoEntity = new MutableLiveData<IndicacaoResponse>();

    public LiveData<IndicacaoResponse> getIndicacaoEntity(){
        return indicacaoEntity;
    }
    
    public void get(){

      homeUseCase.get("601").enqueue(new Callback<OficinaResponse>() {
            @Override
            public void onResponse(Call<OficinaResponse> call, Response<OficinaResponse> response) {
                if (!response.isSuccessful())
                    listaOficinas.setValue(null);
                if (response.isSuccessful())
                if (response.code()==200)
                    listaOficinas.setValue(response.body().listaOficinaEntity);
                else
                if (response.code()!=200)
                    listaOficinas.setValue(null);
                else
                if (response==null || response.body()== null)
                    listaOficinas.setValue(null);
                else
                if (response.errorBody()!=null)
                    listaOficinas.setValue(null);
            }

            @Override
            public void onFailure(Call<OficinaResponse> call, Throwable t) {
                Log.i("get","GET onFailure "+t.getMessage());
                listaOficinas.setValue(null);
            }
        });

    }

    public void postIndicacao(IndicacaoData indicacaoData){

        homeUseCase.postIndicacao(indicacaoData).enqueue(new Callback<IndicacaoResponse>() {
            @Override
            public void onResponse(Call<IndicacaoResponse> call, Response<IndicacaoResponse> response) {
                if (response.code()==200){
                    if (response.body() != null)
                      indicacaoEntity.setValue(response.body());
                    else
                      indicacaoEntity.setValue(null);
                }
                else {
                    IndicacaoResponse indicacaoResponse = new IndicacaoResponse();
                    ErroData erroData = new ErroData();
                    erroData.setRetornoErro("Erro ao enviar indicação");
                    indicacaoResponse.setRetornoErro(erroData);
                    indicacaoEntity.setValue(indicacaoResponse);
                }

            }

            @Override
            public void onFailure(Call<IndicacaoResponse> call, Throwable t) {
                indicacaoEntity.setValue(null);
            }
        });

    }

}