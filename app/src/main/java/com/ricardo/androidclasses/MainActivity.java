package com.ricardo.androidclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = findViewById(R.id.botao);
        botao.setOnClickListener(this);
    }

//    public void mensagem(View view) {
//        Toast.makeText(this, "Corra do Java!", Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Que fome!", Toast.LENGTH_LONG).show();
    }
}