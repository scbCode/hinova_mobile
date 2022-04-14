package com.scb.myapptest.home.ui.main;

import androidx.lifecycle.SavedStateHandle;

import com.scb.myapptest.home.domain.repositories.HomeRepository;
import com.scb.myapptest.home.domain.usecases.HomeUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@Module
@InstallIn(ViewModelComponent.class)
final class ViewModelMovieModule {
    @Provides
    @ViewModelScoped
    static HomeUseCase provideRepo(SavedStateHandle handle, HomeRepository homeRepository) {
        return new HomeUseCase(homeRepository);
    }


}