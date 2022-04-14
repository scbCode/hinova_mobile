package com.scb.myapptest.home.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.scb.myapptest.home.domain.models.IndicacaoEntity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class IndicacaoData {

    @SerializedName("Remetente")
    @Expose private String remetente;
    @SerializedName("Copias")
    @Expose private List<String> copias;
    @SerializedName("IndicacaoEntity")
    @Expose private IndicacaoEntity indicacaoEntity;


    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public List<String> getCopias() {
        return copias;
    }

    public void setCopias(List<String> copias) {
        this.copias = copias;
    }

    public IndicacaoEntity getIndicacaoEntity() {
        return indicacaoEntity;
    }

    public void setIndicacaoEntity(IndicacaoEntity indicacaoEntity) {
        this.indicacaoEntity = indicacaoEntity;
    }
}
