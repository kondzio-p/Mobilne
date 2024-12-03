package com.example.kopiujwklej;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private ClipboardManager clipboardManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicjacja elementów
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        Button btnKopiuj = findViewById(R.id.btnKopiuj);
        Button btnWklej = findViewById(R.id.btnWklej);

        // Inicjacja Clipboard menedżera
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // Nasłuch do kopiuj
        btnKopiuj.setOnClickListener(view -> {
            String textKopiowany = editText1.getText().toString();
            if (!textKopiowany.isEmpty()) {
                ClipData clipData = ClipData.newPlainText("text", textKopiowany);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this,"Skopiowano do schowka", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(MainActivity.this, "Nie wpisałes nic do kopiarki", Toast.LENGTH_SHORT).show();
            }
        });

        // Nasłuch do wklejania
        btnWklej.setOnClickListener(view ->{
            if(clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
                String textWklejany = item.getText().toString();
                editText2.setText(textWklejany);
            } else {
                Toast.makeText(MainActivity.this, "Brak tekstu do wklejenia", Toast.LENGTH_SHORT).show();
            }
        });

    }
}