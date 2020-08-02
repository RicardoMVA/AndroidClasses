package com.ricardo.androidclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public final static String ID_DA_MENSAGEM_NO_INTENT = "com.ricardo.androidclasses.INPUT_MA";
    public final static int RESPONSE_CODE =  200;
    public static final int RESULT_OK = 1;

    private TextView viewTodasMensagens;
    private EditText inputMensagemIda;
    private Button botaoEnviarMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewTodasMensagens = findViewById(R.id.todasAsMensagens);
        inputMensagemIda = findViewById(R.id.mensagemIda);
        botaoEnviarMensagem =  findViewById(R.id.botaoEnviar);

        botaoEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String mensagemEscrita = inputMensagemIda.getText().toString();
                String textoMensagem = viewTodasMensagens.getText().toString() + "\n\n" + "Enviada para SA: " + mensagemEscrita;
                viewTodasMensagens.setText(textoMensagem);
                inputMensagemIda.setText("");
                intent.putExtra(ID_DA_MENSAGEM_NO_INTENT, mensagemEscrita);
                startActivityForResult(intent, RESPONSE_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentResponse ) {
        super.onActivityResult(requestCode, resultCode, intentResponse);

        if (resultCode == RESULT_OK && requestCode == RESPONSE_CODE) {
            String mensagemRecebida = intentResponse.getStringExtra(SecondActivity.ID_DA_MENSAGEM_NO_INTENT);
            String textoMensagem = viewTodasMensagens.getText().toString() + "\n\n" + "Recebida da SA: " + mensagemRecebida;
            viewTodasMensagens.setText(textoMensagem);
        }
    }
}