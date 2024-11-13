package com.example.powtorzenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


    }
    public void obliczanie(View view) {
        EditText promien = findViewById(R.id.editTextNumber);
        String prstr = promien.getText().toString();
        if(prstr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Wprowadz cos", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Druga.class);
            intent.putExtra("r", prstr);
            startActivity(intent);
        }
    }
}