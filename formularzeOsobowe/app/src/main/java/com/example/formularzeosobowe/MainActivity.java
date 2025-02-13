package com.example.formularzeosobowe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// Główna aktywność aplikacji
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Przycisk menu hamburgerowego
        ImageButton hamburgerMenu = findViewById(R.id.hamburger_menu);

        // Obsługa kliknięcia przycisku hamburgera
        hamburgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tworzenie i wyświetlanie menu rozwijanego
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.hamburger_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.menu_about) {
                            // Przejście do ekranu "O aplikacji"
                            startActivity(new Intent(MainActivity.this, AboutActivity.class));
                            return true;
                        } else if (id == R.id.menu_help) {
                            // Przejście do ekranu "Pomoc"
                            startActivity(new Intent(MainActivity.this, HelpActivity.class));
                            return true;
                        } else if (id == R.id.menu_copyright) {
                            // Przejście do ekranu "Prawa autorskie"
                            startActivity(new Intent(MainActivity.this, CopyrightActivity.class));
                            return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        // Przycisk dla pracownika
        Button workerButton = findViewById(R.id.worker_button);
        workerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmployeePanelActivity.class));
            }
        });

        // Przycisk dla prezesa
        Button presidentButton = findViewById(R.id.president_button);
        presidentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PresidentPanelActivity.class));
            }
        });
    }
}
