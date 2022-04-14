package com.scb.myapptest.home.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.scb.myapptest.home.domain.models.OficinaEntity;

import java.util.List;

public class OficinaResponse {

    @SerializedName("ListaOficinas")
    @Expose
    public  List<OficinaEntity> listaOficinaEntity;

    public List<OficinaEntity> getListaOficinaEntity() {
        return listaOficinaEntity;
    }

    public void setListaOficinaEntity(List<OficinaEntity> listaOficinaEntity) {
        this.listaOficinaEntity = listaOficinaEntity;
    }
}


