package com.scb.myapptest.home.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OficinaEntity {

    @SerializedName("Nome")
    @Expose
    public String nome;

    @SerializedName("Descricao")
    @Expose
    public String descricao;

    @SerializedName("Endereco")
    @Expose
    public String endereco;

    @SerializedName("Telefone1")
    @Expose
    public String telefone;
}
