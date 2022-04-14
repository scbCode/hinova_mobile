package com.scb.myapptest.home.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErroData {

    @SerializedName("retornoErro")
    @Expose
    public String retornoErro;

    public String getRetornoErro() {
        return retornoErro;
    }

    public void setRetornoErro(String retornoErro) {
        this.retornoErro = retornoErro;
    }
}
