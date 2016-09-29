package br.com.dudafmme.httpandroidapp.interfaces;

import java.util.HashMap;
import java.util.Map;

import br.com.dudafmme.httpandroidapp.model.Apelido;
import br.com.dudafmme.httpandroidapp.model.Cachorro;
import br.com.dudafmme.httpandroidapp.model.JSONResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by eduana on 21/09/2016.
 */

public interface RequestInterface {

    @GET("api/cachorro/listar")
    Call<JSONResponse> getCachorrosJSON();

    @GET("api/apelido/listar/{id_cachorro}")
    Call<Apelido> getApelidoById(
            @Path("id_cachorro") String id_cachorro);

    @POST("api/cachorro/apelido")
    Call<JSONResponse> createApelido(@Body Apelido apelido);

}
