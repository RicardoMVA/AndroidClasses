package com.ricardo.cepwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ricardo.cepwebservice.model.CEP;
import com.ricardo.cepwebservice.util.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cep = findViewById(R.id.cepInput);
        final TextView resposta = findViewById(R.id.resultadoView);
        Button btnBuscarCep = findViewById(R.id.botaoBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aqui usamos o método do retrofit e a interface que fizemos para criar uma call
                Call<CEP> call = new RetrofitConfig().getCEPService().buscarCEP(cep.getText().toString());

                // com o call criado podemos realizar a requisição
                call.enqueue(new Callback<CEP>() {
                    @Override
                    public void onResponse(Call<CEP> call, Response<CEP> response) {
                        // aqui pegamos o body da resposta já convertido pelo jackson
                        CEP cep = response.body();
                        resposta.setText(cep.toString());
                    }

                    @Override
                    public void onFailure(Call<CEP> call, Throwable t) {
                        // caso ocorra erro na requisição, manda mensagem de erro para o view
                        Log.e("CEPService ", "Erro ao buscar o CEP: " + t.getMessage());
                    }
                });
            }
        });
    }

}