package com.scb.myapptest.home.domain.repositories;

import com.scb.myapptest.home.data.api.Api;
import com.scb.myapptest.home.data.repository.HomeRepositoryImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class HomeRepositoryModule {

    @Provides
    public HomeRepository createRepo(Api api){
        return new HomeRepositoryImpl(api);
    }
}
