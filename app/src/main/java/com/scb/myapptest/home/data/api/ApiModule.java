package com.scb.myapptest.home.data.api;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scb.myapptest.R;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {

    @Provides
    public Retrofit retrofit(OkHttpClient client){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl("http://app.hinovamobile.com.br/ProvaConhecimentoWebApi/")
                .addConverterFactory( ScalarsConverterFactory.create())
                .client(client).addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    public OkHttpClient providesOkHttpClient(  ) {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    public Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }

}
