package com.scb.myapptest.home.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class IndicacaoEntity  {

    @SerializedName("NomeAssociado")
    @Expose
    public String nomeAssociado;

    @SerializedName("TelefoneAmigo")
    @Expose
    public String telefoneAmigo;


    @SerializedName("DataCriacao")
    @Expose
    public String dataCriacao;


    @SerializedName("EmailAssociado")
    @Expose
    public String emailAssociado;


    @SerializedName("TelefoneAssociado")
    @Expose
    public String telefoneAssociado;


    @SerializedName("PlacaVeiculoAssociado")
    @Expose
    public String placaVeiculoAssociado;


    @SerializedName("NomeAmigo")
    @Expose
    public String nomeAmigo;


    @SerializedName("EmailAmigo")
    @Expose
    public String emailAmigo;


    @SerializedName("CodigoAssociacao")
    @Expose
    public String codigoAssociacao;


    @SerializedName("CpfAssociado")
    @Expose
    public String cpfAssociado;


    public String getNomeAssociado() {
        return this.nomeAssociado;
    }


    public void setNomeAssociado(String nomeAssociado) {
        this.nomeAssociado = nomeAssociado;
    }


    public String getTelefoneAmigo() {
        return this.telefoneAmigo;
    }


    public void setTelefoneAmigo(String telefoneAmigo) {
        this.telefoneAmigo = telefoneAmigo;
    }


    public String getDataCriacao() {
        return this.dataCriacao;
    }


    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public String getEmailAssociado() {
        return this.emailAssociado;
    }


    public void setEmailAssociado(String emailAssociado) {
        this.emailAssociado = emailAssociado;
    }


    public String getTelefoneAssociado() {
        return this.telefoneAssociado;
    }


    public void setTelefoneAssociado(String telefoneAssociado) {
        this.telefoneAssociado = telefoneAssociado;
    }


    public String getPlacaVeiculoAssociado() {
        return this.placaVeiculoAssociado;
    }


    public void setPlacaVeiculoAssociado(String placaVeiculoAssociado) {
        this.placaVeiculoAssociado = placaVeiculoAssociado;
    }


    public String getNomeAmigo() {
        return this.nomeAmigo;
    }


    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }


    public String getEmailAmigo() {
        return this.emailAmigo;
    }


    public void setEmailAmigo(String emailAmigo) {
        this.emailAmigo = emailAmigo;
    }


    public String getCodigoAssociacao() {
        return this.codigoAssociacao;
    }


    public void setCodigoAssociacao(String codigoAssociacao) {
        this.codigoAssociacao = codigoAssociacao;
    }


    public String getCpfAssociado() {
        return this.cpfAssociado;
    }


    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
    }
}
