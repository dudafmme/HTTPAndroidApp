package br.com.dudafmme.httpandroidapp.model;

/**
 * Created by eduana on 21/09/2016.
 */

public class JSONResponse {
    private Cachorro[] cachorros;
    private Apelido apelido;
    private String apelidoCachorro;

    public Cachorro[] getCachorro() {
        return cachorros;
    }

    public Apelido setApelido() {
        return apelido;
    }

    public String getApelidoCachorro(){
        return apelidoCachorro;
    }
}
