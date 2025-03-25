package com.example.losowanieobrazkow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> listaZobrazkami = new ArrayList<>();
    private List<Integer> oryginalnaListaObrazków = new ArrayList<>();
    private int pozostaleObrazki;
    private ImageView widokObrazu;
    private Button przyciskLosowania;
    private Button przyciskRestartu;
    private TextView licznikPozostalychObrazkow;
    private TextView numerIndeksuObrazu; // Nowy TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widokObrazu = findViewById(R.id.widokObrazu);
        przyciskLosowania = findViewById(R.id.przyciskLosowania);
        przyciskRestartu = findViewById(R.id.przyciskRestartu);
        licznikPozostalychObrazkow = findViewById(R.id.licznikPozostalychObrazkow);
        numerIndeksuObrazu = findViewById(R.id.numerIndeksuObrazu); // Inicjalizacja TextView

        znajdzWczytajObrazki();

        przyciskRestartu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAplikacji();
            }
        });

        przyciskLosowania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pozostaleObrazki > 0) {
                    int losowyIndeks = listaZobrazkami.get(pozostaleObrazki - 1);
                    widokObrazu.setImageResource(losowyIndeks);
                    widokObrazu.setVisibility(View.VISIBLE);

                    // Wyciąganie nazwy obrazka
                    String nazwaObrazka = getResources().getResourceEntryName(losowyIndeks);

                    // Pokazywanie numeru indeksu i nazwy obrazka
                    numerIndeksuObrazu.setText("Indeks: " + (pozostaleObrazki) + ", Nazwa: " + nazwaObrazka);
                    numerIndeksuObrazu.setVisibility(View.VISIBLE); // Ujawnienie TextView

                    pozostaleObrazki--;
                    licznikPozostalychObrazkow.setText("Pozostało: " + pozostaleObrazki);
                }

                if (pozostaleObrazki == 0) {
                    Toast.makeText(MainActivity.this, "Wszystkie obrazki wylosowane", Toast.LENGTH_SHORT).show();
                }
            }
        });

        startGre();
    }

    private void znajdzWczytajObrazki() {
        String nazwaPakietu = getPackageName();

        for (int i = 1; ; i++) {
            int identyfikatorZasobu = getResources().getIdentifier("image" + i, "drawable", nazwaPakietu);
            if (identyfikatorZasobu == 0) {
                break;
            }
            listaZobrazkami.add(identyfikatorZasobu);
            oryginalnaListaObrazków.add(identyfikatorZasobu);
        }
    }

    private void startGre() {
        Collections.shuffle(listaZobrazkami);
        pozostaleObrazki = listaZobrazkami.size();
        licznikPozostalychObrazkow.setText("Pozostało: " + pozostaleObrazki);
        widokObrazu.setVisibility(View.GONE);
        numerIndeksuObrazu.setVisibility(View.GONE);
    }

    private void resetAplikacji() {
        listaZobrazkami.clear();
        listaZobrazkami.addAll(oryginalnaListaObrazków);
        startGre();
    }
}
