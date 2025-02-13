package com.example.formularzeosobowe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Aktywność panelu prezydenta zarządzającego aplikacjami i pracownikami
public class PresidentPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_panel);

        // Obsługa przycisku "Zamów kawę"
        Button orderCoffeeButton = findViewById(R.id.order_coffee_button);
        orderCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PresidentPanelActivity.this, "Zamówiono kawę", Toast.LENGTH_SHORT).show();
            }
        });

        // Obsługa przycisku "Zamów herbatę"
        Button orderTeaButton = findViewById(R.id.order_tea_button);
        orderTeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PresidentPanelActivity.this, "Zamówiono herbatę", Toast.LENGTH_SHORT).show();
            }
        });

        // Przejście do widoku aplikacji
        Button viewApplicationsButton = findViewById(R.id.view_applications_button);
        viewApplicationsButton.setOnClickListener(v ->
                startActivity(new Intent(PresidentPanelActivity.this, ApplicationsViewActivity.class))
        );

        // Przejście do listy pracowników
        Button viewEmployeesButton = findViewById(R.id.view_employees_button);
        viewEmployeesButton.setOnClickListener(v ->
                startActivity(new Intent(PresidentPanelActivity.this, EmployeesListActivity.class))
        );

        // Obsługa przycisku "Cofnij"
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Obsługa przycisku "Resetuj dane"
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(v -> showResetConfirmationDialog());

        // Obsługa przycisku "Dodaj przykładowych aplikantów"
        Button addSampleApplicantsButton = findViewById(R.id.add_sample_applicants_button);
        addSampleApplicantsButton.setOnClickListener(v -> {
            addSampleApplicants();
            Toast.makeText(this, "Dodano 10 przykładowych aplikantów!", Toast.LENGTH_SHORT).show();
        });

        // Obsługa animacji obrazów Cristiano Ronaldo
        ImageView ronaldoImage = findViewById(R.id.ronaldoSIP_image);
        orderCoffeeButton.setOnClickListener(v -> {
            Toast.makeText(this, "Zamówiono kawę", Toast.LENGTH_SHORT).show();
            ronaldoImage.setImageResource(R.drawable.cristiano_sip);
            ronaldoImage.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() ->
                    ronaldoImage.setImageResource(R.drawable.cristiano_complete), 3000);

            new Handler().postDelayed(() ->
                    ronaldoImage.setVisibility(View.GONE), 6000);
        });
    }

    // Wyświetla okno dialogowe potwierdzenia resetu danych
    private void showResetConfirmationDialog() {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Reset danych")
                .setMessage("Czy na pewno chcesz usunąć wszystkie aplikacje i pracowników?")
                .setPositiveButton("Tak", (dialog, which) -> {
                    boolean isDeleted = resetApplicationData();
                    if (isDeleted) {
                        Toast.makeText(this, "Wszystkie dane zostały usunięte!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Anuluj", null)
                .show();
    }

    // Usuwa wszystkie zapisane aplikacje
    private boolean resetApplicationData() {
        File file = new File(getFilesDir(), "applications.txt");

        if (file.exists()) {
            if (file.delete()) {
                return true;  // Sukces – dane zostały usunięte
            } else {
                Toast.makeText(this, "Błąd podczas czyszczenia pliku!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(this, "Brak danych do usunięcia.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    // Dodaje 10 przykładowych aplikantów do pliku
    private void addSampleApplicants() {
        File file = new File(getFilesDir(), "applications.txt");

        String[] sampleNames = {"Jan Kowalski", "Anna Nowak", "Piotr Zieliński", "Katarzyna Mazur", "Tomasz Lewandowski",
                "Michał Wiśniewski", "Agnieszka Kaczmarek", "Paweł Wojciechowski", "Magdalena Zawadzka", "Andrzej Kamiński"};

        String[] sampleAges = {"25", "30", "22", "27", "35", "40", "29", "31", "24", "33"};
        String[] sampleEducations = {"Inżynier", "Magister", "Technik", "Licencjat", "Doktor"};
        String[] sampleDrivingLicenses = {"tak", "nie"};
        String[] sampleExperiences = {"1 rok", "3 lata", "5 lat", "brak", "10 lat"};

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            for (int i = 0; i < 10; i++) {
                String data = "Imię i nazwisko: " + sampleNames[i] + "\n" +
                        "Wiek: " + sampleAges[i] + "\n" +
                        "Wykształcenie: " + sampleEducations[i % sampleEducations.length] + "\n" +
                        "Prawo jazdy: " + sampleDrivingLicenses[i % sampleDrivingLicenses.length] + "\n" +
                        "Doświadczenie: " + sampleExperiences[i % sampleExperiences.length] + "\n" +
                        "###\n";
                fos.write(data.getBytes());
            }
        } catch (IOException e) {
            Toast.makeText(this, "Błąd zapisu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
