package br.com.dudafmme.httpandroidapp.activities;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.dudafmme.httpandroidapp.R;
import br.com.dudafmme.httpandroidapp.adapter.CachorroAdapter;
import br.com.dudafmme.httpandroidapp.interfaces.RequestInterface;
import br.com.dudafmme.httpandroidapp.model.Apelido;
import br.com.dudafmme.httpandroidapp.model.Cachorro;
import br.com.dudafmme.httpandroidapp.model.JSONResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalheCachorro extends AppCompatActivity {

    private TextView id, nome, raca, genero;
    private ImageView foto;
    private Button alterarApelidoButton;
    private Apelido mApelido;
    private TextInputEditText apelidoEditText;
    private LinearLayout detalheLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cachorro);

        Cachorro dog = (Cachorro) getIntent().getSerializableExtra("dog");

        foto = (ImageView) findViewById(R.id.foto_detailed_imv);
        id = (TextView) findViewById(R.id.id_detailed_tv);
        nome = (TextView) findViewById(R.id.nome_detailed_tv);
        raca = (TextView) findViewById(R.id.raca_detailed_tv);
        genero = (TextView) findViewById(R.id.genero_detailed_tv);
        apelidoEditText = (TextInputEditText) findViewById(R.id.apelido_et);
        detalheLinearLayout = (LinearLayout) findViewById(R.id.detalhe_ll);

        id.setText(dog.getId());
        nome.setText(dog.getNome());
        raca.setText(dog.getRaca());
        genero.setText(dog.getGenero());

        Glide.with(getApplicationContext()).load(dog.getFoto()).into(foto);

        //Toast.makeText(getApplicationContext(), "Foto: " + dog.getFoto(), Toast.LENGTH_LONG).show();

        alterarApelidoButton = (Button) findViewById(R.id.alterar_bt);
        alterarApelidoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApelido = new Apelido(id.getText().toString(), apelidoEditText.getText().toString());
                loadJSON();
            }
        });
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caoclub.thinkmob.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = requestInterface.createApelido(mApelido);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                Snackbar.make(detalheLinearLayout, "Apelido: " + mApelido.getApelido().toString()
                                + "\nAlterado com Sucesso!",
                        Snackbar.LENGTH_LONG).show();
                apelidoEditText.setText("");
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Snackbar.make(detalheLinearLayout, "Erro!", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void loadApelido() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caoclub.thinkmob.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        try {
//            RequestInterface requestInterface = retrofit.create(RequestInterface.class);
//            Call<JSONResponse> call = requestInterface.getApelidoById(id.getText().toString());
//            if (call != null) {
//                call.enqueue(new Callback<JSONResponse>() {
//                    @Override
//                    public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
//                        JSONResponse jsonResponse = response.body();
//                        mApelido = new Apelido(jsonResponse.setApelido().getId_cachorro(),
//                                jsonResponse.setApelido().getApelido());
//                        apelidoEditText.setText(mApelido.getApelido());
//                        Toast.makeText(getApplicationContext(), mApelido.toString(),
//                                Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<JSONResponse> call, Throwable t) {
//                        Snackbar.make(detalheLinearLayout, "Erro!", Snackbar.LENGTH_LONG).show();
//                    }
//                });
//            } else {
//                apelidoEditText.setText("Cachorro sem apelido!");
//            }
//        } catch (NullPointerException n) {
//            //
//        }

    }
}
