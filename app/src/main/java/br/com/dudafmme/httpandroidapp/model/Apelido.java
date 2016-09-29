package br.com.dudafmme.httpandroidapp.model;

import java.io.Serializable;

/**
 * Created by eduana on 26/09/2016.
 */

public class Apelido implements Serializable{
    private String id_cachorro;
    private String apelido;

    public Apelido(String id_cachorro, String apelido) {
        this.id_cachorro = id_cachorro;
        this.apelido = apelido;
    }

    public Apelido() {
    }

    public String getId_cachorro() {
        return id_cachorro;
    }

    public void setId_cachorro(String id_cachorro) {
        this.id_cachorro = id_cachorro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
