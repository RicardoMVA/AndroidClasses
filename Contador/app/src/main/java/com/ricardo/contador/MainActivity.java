package com.ricardo.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int contador;
    private TextView contadorView;
    private Button botaoContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador", 0);
        }

        contadorView =  findViewById(R.id.contadorView);
        contadorView.setText(String.valueOf(contador));
        botaoContador =  findViewById(R.id.botaoContador);

        botaoContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador += 1;
                contadorView.setText(String.valueOf(contador));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt("contador", contador);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estado) {
        super.onRestoreInstanceState(estado);
        contador = estado.getInt("contador", 0);
    }
}
