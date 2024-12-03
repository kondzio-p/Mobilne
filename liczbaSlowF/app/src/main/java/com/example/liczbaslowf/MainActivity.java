package com.example.liczbaslowf;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textViewWynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textViewWynik = findViewById(R.id.textViewWynik);

    }
        public void policzSlowa(View view) {
            String tekst = editText.getText().toString();

            if (tekst.isEmpty()) {
                textViewWynik.setText("Liczba słów to: 0");
                return;
            }

            String[] slowa = tekst.split("\\s+");
            int liczbaSlow = slowa.length;

            textViewWynik.setText("Liczba słów to: " + liczbaSlow);


        }
}