package com.example.checkboxy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkKsiazki, chkPilka, chkMuzyka;
    private RadioGroup rdPlec;
    private TextView txtWynik;
    private Button btnWyslij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chkKsiazki = findViewById(R.id.chkKsiazki);
        chkMuzyka = findViewById(R.id.chkMuzyka);
        chkPilka = findViewById(R.id.chkPilka);
        rdPlec = findViewById(R.id.rdPlec);
        btnWyslij = findViewById(R.id.btnWyslij);
        txtWynik = findViewById(R.id.txtWynik);

        btnWyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){handlerUserSelection();
            }
        });
    }

    private void handlerUserSelection() {
        StringBuilder rezultat = new StringBuilder("Wybrałes: \n");
        if(chkPilka.isChecked()) rezultat.append("lubię piłkę \n");
        if(chkKsiazki.isChecked()) rezultat.append("lubię książki \n");
        if(chkMuzyka.isChecked()) rezultat.append("lubię muyzkę \n");

        int zaznaczonyId = rdPlec.getCheckedRadioButtonId();
        if(zaznaczonyId!= -1) {
            RadioButton zaznaczony = findViewById(zaznaczonyId);
            rezultat.append("Płeć: ").append(zaznaczony.getText().toString());
        } else {
            rezultat.append("Nie wybrałes plci...");
        }

        txtWynik.setText(rezultat);



    }
}