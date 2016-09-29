package br.com.dudafmme.httpandroidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.dudafmme.httpandroidapp.R;
import br.com.dudafmme.httpandroidapp.adapter.CachorroAdapter;
import br.com.dudafmme.httpandroidapp.model.Cachorro;
import br.com.dudafmme.httpandroidapp.model.JSONResponse;
import br.com.dudafmme.httpandroidapp.interfaces.RequestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CachorroAdapter.AoClicarNoCachorroListener {

    private RecyclerView mRecycler;
    private ArrayList<Cachorro> mCachorros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mRecycler.setTag("dogs");
        mRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());

        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caoclub.thinkmob.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> jsonResponseCall = requestInterface.getCachorrosJSON();
        jsonResponseCall.enqueue(new Callback<JSONResponse>() {

            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                mCachorros = new ArrayList<>(Arrays.asList(jsonResponse.getCachorro()));
                CachorroAdapter adapter = new CachorroAdapter(getApplicationContext(), mCachorros);
                adapter.setAoClicarNoCachorroListener(MainActivity.this);
                mRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                //Log
            }
        });

    }

    @Override
    public void aoClicarNoCachorro(View v, int position, Cachorro c) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,
                        Pair.create(v.findViewById(R.id.id_tv), "id"),
                        Pair.create(v.findViewById(R.id.nome_tv), "nome"),
                        Pair.create(v.findViewById(R.id.raca_tv), "raca")
                );
        Intent it = new Intent(getApplicationContext(), DetalheCachorro.class);
        it.putExtra("dog", c);
        ActivityCompat.startActivity(this, it, options.toBundle());
    }
}
