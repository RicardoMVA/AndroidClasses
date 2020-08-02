package com.ricardo.androidclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String ID_DA_MENSAGEM_NO_INTENT = "com.ricardo.androidclasses.INPUT_SA";

    private TextView viewTodasMensagens;
    private EditText inputMensagemVolta;
    private Button botaoEnviarMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        viewTodasMensagens = findViewById(R.id.todasAsMensagens);
        inputMensagemVolta = findViewById(R.id.mensagemVolta);
        botaoEnviarMensagem = findViewById(R.id.botaoEnviar);

        Intent intent = getIntent();
        String mensagemRecebida = intent.getStringExtra(MainActivity.ID_DA_MENSAGEM_NO_INTENT);
        String textoMensagem = viewTodasMensagens.getText().toString() + "\n\n" + "Recebida da MA: " + mensagemRecebida;
        viewTodasMensagens.setText(textoMensagem);

        botaoEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String mensagemEscrita = inputMensagemVolta.getText().toString();
                inputMensagemVolta.setText("");
                intent.putExtra(ID_DA_MENSAGEM_NO_INTENT, mensagemEscrita);
                setResult(MainActivity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
