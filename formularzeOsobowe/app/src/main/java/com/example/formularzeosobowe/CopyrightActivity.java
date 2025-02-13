package com.example.formularzeosobowe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Aktywność wyświetlająca informacje o prawach autorskich
public class CopyrightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copyright); // Ustawia widok dla aktywności

        // Przycisk powrotu do poprzedniej aktywności
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Zamyka obecną aktywność
            }
        });
    }
}
