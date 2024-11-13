package com.example.powtorzenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Druga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_druga);


        Intent intent = getIntent();

        String odbR = intent.getStringExtra("r");
            double promien = Double.parseDouble(odbR);
            TextView output = findViewById(R.id.rOut);
            double wynik = promien * 2 * 3.14;
            output.setText("Obw. kola: " + wynik);
    }
}