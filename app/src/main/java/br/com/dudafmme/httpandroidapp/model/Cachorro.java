package br.com.dudafmme.httpandroidapp.model;

import java.io.Serializable;

/**
 * Created by eduana on 21/09/2016.
 */

public class Cachorro implements Serializable {
    private String id;
    private String nome;
    private String raca;
    private String genero;
    private String nascimento;
    private String data_cadastro;
    private String foto;
    private String ativo;
    private String castrado;
    private String observacao;
    private String v8;
    private String raiva;
    private String giardia;
    private String gripe;
    private String v8_data;
    private String raiva_data;
    private String giardia_data;
    private String gripe_data;
    private String marca_racao;
    private String std_racao;

    public Cachorro(String id, String nome, String raca, String genero, String nascimento,
                    String data_cadastro, String foto, String ativo, String castrado,
                    String observacao, String v8, String raiva, String giardia,
                    String gripe, String v8_data, String raiva_data,
                    String giardia_data, String gripe_data, String marca_racao, String std_racao) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.genero = genero;
        this.nascimento = nascimento;
        this.data_cadastro = data_cadastro;
        this.foto = foto;
        this.ativo = ativo;
        this.castrado = castrado;
        this.observacao = observacao;
        this.v8 = v8;
        this.raiva = raiva;
        this.giardia = giardia;
        this.gripe = gripe;
        this.v8_data = v8_data;
        this.raiva_data = raiva_data;
        this.giardia_data = giardia_data;
        this.gripe_data = gripe_data;
        this.marca_racao = marca_racao;
        this.std_racao = std_racao;
    }

    public Cachorro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getFoto() {
        return "http://caoclub.thinkmob.com.br/api/uploads/" + this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCastrado() {
        return castrado;
    }

    public void setCastrado(String castrado) {
        this.castrado = castrado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getV8() {
        return v8;
    }

    public void setV8(String v8) {
        this.v8 = v8;
    }

    public String getRaiva() {
        return raiva;
    }

    public void setRaiva(String raiva) {
        this.raiva = raiva;
    }

    public String getGiardia() {
        return giardia;
    }

    public void setGiardia(String giardia) {
        this.giardia = giardia;
    }

    public String getGripe() {
        return gripe;
    }

    public void setGripe(String gripe) {
        this.gripe = gripe;
    }

    public String getV8_data() {
        return v8_data;
    }

    public void setV8_data(String v8_data) {
        this.v8_data = v8_data;
    }

    public String getRaiva_data() {
        return raiva_data;
    }

    public void setRaiva_data(String raiva_data) {
        this.raiva_data = raiva_data;
    }

    public String getGiardia_data() {
        return giardia_data;
    }

    public void setGiardia_data(String giardia_data) {
        this.giardia_data = giardia_data;
    }

    public String getGripe_data() {
        return gripe_data;
    }

    public void setGripe_data(String gripe_data) {
        this.gripe_data = gripe_data;
    }

    public String getMarca_racao() {
        return marca_racao;
    }

    public void setMarca_racao(String marca_racao) {
        this.marca_racao = marca_racao;
    }

    public String getStd_racao() {
        return std_racao;
    }

    public void setStd_racao(String std_racao) {
        this.std_racao = std_racao;
    }

}
