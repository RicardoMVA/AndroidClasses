package com.ricardo.searchdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ricardo.searchdev.model.Dev;
import com.ricardo.searchdev.model.DevMessage;
import com.ricardo.searchdev.util.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mNome;
    private EditText idInput;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNome = findViewById(R.id.nome);
        idInput = findViewById(R.id.idInput);
        botao = findViewById(R.id.enviar);

        sendRequest();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMessage();
            }
        });
    }

    public void sendRequest() {
        Call<List<Dev>> call = new RetrofitConfig().getDevService().getAllDevs();

        call.enqueue(new Callback<List<Dev>>() {
            @Override
            public void onResponse(Call<List<Dev>> call, Response<List<Dev>> response) {
                List<Dev> dev = response.body();
                int code = response.code();

                if(code == 503) {
                    Toast.makeText(MainActivity.this, "Erro 503: sem resposta", Toast.LENGTH_LONG).show();
                } else {
                    mNome.setText(dev.get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<List<Dev>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();
            }
        });

    };

    public void getMessage() {
        Call<DevMessage> call = new RetrofitConfig().getDevService().getMessage(idInput.getText().toString());

        call.enqueue(new Callback<DevMessage>() {
            @Override
            public void onResponse(Call<DevMessage> call, Response<DevMessage> response) {
                DevMessage devMessage = response.body();

                int code = response.code();

                if(code == 503) {
                    Toast.makeText(MainActivity.this, "Erro 503: sem resposta", Toast.LENGTH_LONG).show();
                } else {
                    mNome.setText(devMessage.getMenssagem());
                }
            }

            @Override
            public void onFailure(Call<DevMessage> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha buscando nome", Toast.LENGTH_LONG).show();
            }
        });
    }
}