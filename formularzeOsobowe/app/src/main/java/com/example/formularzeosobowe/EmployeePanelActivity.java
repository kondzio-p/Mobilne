package com.example.formularzeosobowe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Aktywność panelu pracownika, umożliwiająca wypełnienie formularza
public class EmployeePanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_panel);

        // Pobranie referencji do pól formularza
        EditText firstName = findViewById(R.id.first_name);
        EditText lastName = findViewById(R.id.last_name);
        EditText age = findViewById(R.id.age);
        EditText address = findViewById(R.id.address);
        EditText education = findViewById(R.id.education);
        EditText pesel = findViewById(R.id.pesel);
        EditText drivingLicense = findViewById(R.id.driving_license);
        EditText transportPreference = findViewById(R.id.transport_preference);
        EditText experience = findViewById(R.id.experience);
        EditText aboutMe = findViewById(R.id.about_me);

        // Obsługa kliknięcia przycisku "Aplikuj"
        Button applyButton = findViewById(R.id.apply_button);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tworzenie stringa zawierającego dane formularza
                String data = "Imię: " + firstName.getText().toString() + "\n" +
                        "Nazwisko: " + lastName.getText().toString() + "\n" +
                        "Wiek: " + age.getText().toString() + "\n" +
                        "Adres: " + address.getText().toString() + "\n" +
                        "Wykształcenie: " + education.getText().toString() + "\n" +
                        "PESEL: " + pesel.getText().toString() + "\n" +
                        "Prawo jazdy: " + drivingLicense.getText().toString() + "\n" +
                        "Transport: " + transportPreference.getText().toString() + "\n" +
                        "Staż: " + experience.getText().toString() + "\n" +
                        "O sobie: " + aboutMe.getText().toString() + "\n\n";

                saveToFile(data); // Zapisuje dane do pliku
                navigateToMainPanel(); // Przenosi użytkownika do ekranu głównego
            }
        });
    }

    // Zapisuje dane formularza do pliku applications.txt
    private void saveToFile(String data) {
        File file = new File(getFilesDir(), "applications.txt");

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write((data + "\n###\n").getBytes()); // Dodaje separator ### do każdej aplikacji
            Toast.makeText(this, "Formularz zapisany!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Błąd zapisu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Przenosi użytkownika do ekranu głównego
    private void navigateToMainPanel() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
