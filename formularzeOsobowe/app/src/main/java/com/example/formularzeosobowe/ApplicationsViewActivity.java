package com.example.formularzeosobowe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Aktywność wyświetlająca listę aplikacji
public class ApplicationsViewActivity extends AppCompatActivity {

    private ArrayList<String> applications; // Lista aplikacji
    private ArrayAdapter<String> adapter; // Adapter dla ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications_view);

        ListView applicationsListView = findViewById(R.id.applications_list_view);

        // Wczytaj aplikacje z pliku
        applications = readApplicationsFromFile();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, applications);
        applicationsListView.setAdapter(adapter);

        // Obsługa kliknięcia elementu listy
        applicationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedApplication = applications.get(position);
                showActionDialog(selectedApplication, position);
            }
        });
    }

    // Wczytuje aplikacje z pliku do listy
    private ArrayList<String> readApplicationsFromFile() {
        ArrayList<String> applicationsList = new ArrayList<>();
        File file = new File(getFilesDir(), "applications.txt");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder application = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals("###")) { // Separator końca aplikacji
                        applicationsList.add(application.toString().trim());
                        application.setLength(0);
                    } else {
                        application.append(line).append("\n");
                    }
                }
            } catch (IOException e) {
                Toast.makeText(this, "Błąd odczytu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return applicationsList;
    }

    // Wyświetla dialog z opcjami dla wybranej aplikacji
    private void showActionDialog(String application, int position) {
        String[] options = {"Przyjmij", "Odrzuć"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Wybierz opcję dla aplikacji")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) { // Przyjęcie aplikacji
                        updateApplicationStatus(application, "Zatrudniony");
                        Toast.makeText(this, "Aplikacja przyjęta", Toast.LENGTH_SHORT).show();
                    } else { // Odrzucenie aplikacji
                        removeApplicationFromFile(application);
                        Toast.makeText(this, "Aplikacja odrzucona", Toast.LENGTH_SHORT).show();
                    }

                    // Usunięcie aplikacji z listy i odświeżenie widoku
                    applications.remove(position);
                    adapter.notifyDataSetChanged();
                })
                .show();
    }

    // Usuwa aplikację z pliku
    private void removeApplicationFromFile(String application) {
        File file = new File(getFilesDir(), "applications.txt");
        File tempFile = new File(getFilesDir(), "applications_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            StringBuilder currentApplication = new StringBuilder();
            boolean shouldRemove = false;
            String line;

            while ((line = br.readLine()) != null) {
                if (line.equals("###")) { // Koniec aplikacji
                    if (!shouldRemove) {
                        bw.write(currentApplication.toString().trim());
                        bw.newLine();
                        bw.write("###");
                        bw.newLine();
                    }
                    shouldRemove = false;
                    currentApplication.setLength(0);
                } else {
                    if (currentApplication.length() > 0) currentApplication.append("\n");
                    currentApplication.append(line);

                    if (currentApplication.toString().equals(application.trim())) {
                        shouldRemove = true; // Oznacz aplikację do usunięcia
                    }
                }
            }

            if (!file.delete() || !tempFile.renameTo(file)) {
                throw new IOException("Nie udało się zaktualizować pliku");
            }

        } catch (IOException e) {
            Toast.makeText(this, "Błąd podczas usuwania aplikacji: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Aktualizuje status aplikacji w pliku
    private void updateApplicationStatus(String application, String status) {
        File file = new File(getFilesDir(), "applications.txt");
        File tempFile = new File(getFilesDir(), "applications_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            StringBuilder currentApplication = new StringBuilder();
            String line;
            boolean isMatching = false;

            while ((line = br.readLine()) != null) {
                if (line.equals("###")) { // Koniec aplikacji
                    if (isMatching) {
                        currentApplication.append("\nStatus: ").append(status);
                        bw.write(currentApplication.toString().trim());
                        bw.newLine();
                        bw.write("###");
                        bw.newLine();
                    } else {
                        bw.write(currentApplication.toString().trim());
                        bw.newLine();
                        bw.write("###");
                        bw.newLine();
                    }
                    isMatching = false;
                    currentApplication.setLength(0);
                } else {
                    if (currentApplication.length() > 0) currentApplication.append("\n");
                    currentApplication.append(line);
                    if (currentApplication.toString().equals(application.trim())) {
                        isMatching = true;
                    }
                }
            }

            if (!file.delete() || !tempFile.renameTo(file)) {
                throw new IOException("Nie udało się zaktualizować pliku");
            }

        } catch (IOException e) {
            Toast.makeText(this, "Błąd aktualizacji: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
