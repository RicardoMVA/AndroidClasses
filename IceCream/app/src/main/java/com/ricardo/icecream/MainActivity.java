package com.ricardo.icecream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut(View view) {
        Toast.makeText(this, "ROSQUINHA", Toast.LENGTH_LONG).show();
    }

    public void iceCream(View view) {
        Toast.makeText(this, "SORVETE", Toast.LENGTH_LONG).show();
    }

    public void yogurt(View view) {
        Toast.makeText(this, "IOGURTE", Toast.LENGTH_LONG).show();
    }
}