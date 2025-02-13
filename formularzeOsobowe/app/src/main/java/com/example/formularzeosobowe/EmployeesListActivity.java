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

// Aktywność wyświetlająca listę zatrudnionych pracowników
public class EmployeesListActivity extends AppCompatActivity {

    private ArrayList<String> employees; // Lista pracowników
    private ArrayAdapter<String> adapter; // Adapter dla ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_list);

        ListView employeesListView = findViewById(R.id.employees_list_view);

        // Wczytuje listę zatrudnionych pracowników
        employees = readAcceptedApplications();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        employeesListView.setAdapter(adapter);

        // Obsługa kliknięcia na pracownika – daje opcję zwolnienia
        employeesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedEmployee = employees.get(position);
                showFireDialog(selectedEmployee, position);
            }
        });
    }

    // Odczytuje przyjęte aplikacje z pliku
    private ArrayList<String> readAcceptedApplications() {
        ArrayList<String> employeesList = new ArrayList<>();
        File file = new File(getFilesDir(), "applications.txt");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder application = new StringBuilder();
                boolean isHired = false;
                String line;

                while ((line = br.readLine()) != null) {
                    if (line.equals("###")) { // Koniec jednej aplikacji
                        if (isHired) {
                            employeesList.add(application.toString().trim());
                        }
                        application.setLength(0);
                        isHired = false;
                    } else {
                        application.append(line).append("\n");
                        if (line.contains("Status: Zatrudniony")) {
                            isHired = true; // Oznaczamy aplikację jako przyjętą
                        }
                    }
                }
            } catch (IOException e) {
                Toast.makeText(this, "Błąd odczytu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return employeesList;
    }

    // Wyświetla okno dialogowe z opcją zwolnienia pracownika
    private void showFireDialog(String employee, int position) {
        String[] options = {"Zwolnij", "Anuluj"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Czy chcesz zwolnić pracownika?")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) { // Zwalnianie pracownika
                        fireEmployee(employee);
                        employees.remove(position); // Usuwamy z listy
                        adapter.notifyDataSetChanged(); // Odświeżamy UI
                        Toast.makeText(this, "Pracownik zwolniony", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    // Usuwa pracownika z pliku
    private void fireEmployee(String employee) {
        File file = new File(getFilesDir(), "applications.txt");
        File tempFile = new File(getFilesDir(), "applications_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(employee)) { // Pomijamy zwolnionego pracownika
                    bw.write(line);
                    bw.newLine();
                }
            }

            // Zamiana oryginalnego pliku na nowy
            if (!file.delete() || !tempFile.renameTo(file)) {
                throw new IOException("Nie udało się zaktualizować pliku");
            }

        } catch (IOException e) {
            Toast.makeText(this, "Błąd podczas zwalniania: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
