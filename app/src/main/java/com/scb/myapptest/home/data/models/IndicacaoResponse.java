package com.scb.myapptest.home.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndicacaoResponse {

    @SerializedName("RetornoErro")
    @Expose public ErroData retornoErro;
    @SerializedName("Sucesso")
    @Expose public String sucesso;

    public ErroData getRetornoErro() {
        return retornoErro;
    }

    public void setRetornoErro(ErroData retornoErro) {
        this.retornoErro = retornoErro;
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }
}
