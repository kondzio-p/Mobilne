package com.example.formularzeosobowe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Aktywność sekcji pomocy
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help); // Ustawia widok dla tej aktywności

        // Przycisk powrotu do poprzedniego ekranu
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Zamknięcie aktywności
            }
        });
    }
}
