package com.example.mobilnalike;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView pucharyKlubu, polubienia;
    Button like, dislike;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        pucharyKlubu = findViewById(R.id.pucharyKlubu);
        polubienia = findViewById(R.id.polubienia);
        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);

        loadData();
    }

    private void loadData() {
        InputStream is = getResources().openRawResource(R.raw.kluby);


    }
}