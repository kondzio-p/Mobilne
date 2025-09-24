    package com.example.cwiczenie1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


    public class MainActivity extends AppCompatActivity {

    private TextView populationText, areaText, densityText;

    private ImageView flagImage;

    private Country polska;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        populationText = findViewById(R.id.populationText);
        areaText = findViewById(R.id.areaText);
        densityText = findViewById(R.id.densityText);
        flagImage = findViewById(R.id.flagImage);
        Button increaseBtn = findViewById(R.id.increaseBtn);
        Button decreaseBtn = findViewById(R.id.decreaseBtn);

        polska = loadData();
        int idx = getResources().getIdentifier(polska.flaga.replace(".png", ""), "drawable", getPackageName());
        flagImage.setImageResource(idx);

        updateUI(polska);

        increaseBtn.setOnClickListener(v->{
            polska.liczba_mieszkancow +=100000;
            updateUI(polska);
        });

        decreaseBtn.setOnClickListener(v-> {
            polska.liczba_mieszkancow = Math.max(0, polska.liczba_mieszkancow - 100000);
            updateUI(polska);
        });
    }

    // ładowanie danych i zwrócenie do: polska
    private Country loadData() {
        try (
            InputStream is = getResources().openRawResource(R.raw.panstwa);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){

            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject obj = new JSONObject(sb.toString());
            JSONArray arr = obj.getJSONArray("panstwa");

            for (int i = 0; i<arr.length(); i++) {
                JSONObject country = arr.getJSONObject(i);
                if("Polska".equals(country.getString("kraj"))) {
                    Country c = new Country();
                    c.kraj = country.getString("kraj");
                    c.liczba_mieszkancow = country.getInt("liczba_mieszkancow");
                    c.powierzchnia = country.getInt("powierzchnia");
                    c.flaga = country. getString("flaga");



                    return c;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null; // gdyby nie bylo Polski
        }

    private void updateUI(Country country) {
        populationText.setText("Liczba mieszkańców: " + country.liczba_mieszkancow/1000 + "tys.");
        areaText.setText("Powierzchnia: " + country.powierzchnia/1000 + " km²");
        double gestosc = (double) country.liczba_mieszkancow/country.powierzchnia;
        densityText.setText("Gęstość zaludnienia: " + String.format("%.2f", gestosc) + "os./km²");



    }
}