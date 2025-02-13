package com.example.formularzeosobowe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adapter dla RecyclerView obsługującego listę aplikacji
public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.ViewHolder> {

    private final ArrayList<Application> applications;

    // Konstruktor przyjmujący listę aplikacji
    public ApplicationsAdapter(ArrayList<Application> applications) {
        this.applications = applications;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tworzy nowy widok dla pojedynczego elementu listy
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Pobiera dane aplikacji dla danej pozycji i ustawia je w widokach
        Application application = applications.get(position);
        holder.nameTextView.setText(application.getFirstName() + " " + application.getLastName());
        holder.detailsTextView.setText(
                "Wiek: " + application.getAge() + "\n" +
                        "Adres: " + application.getAddress() + "\n" +
                        "Wykształcenie: " + application.getEducation() + "\n" +
                        "PESEL: " + application.getPesel() + "\n" +
                        "Prawo jazdy: " + application.getDrivingLicense() + "\n" +
                        "Transport: " + application.getTransport() + "\n" +
                        "Staż: " + application.getExperience() + "\n" +
                        "O sobie: " + application.getAboutMe()
        );
    }

    @Override
    public int getItemCount() {
        return applications.size(); // Zwraca liczbę elementów w liście
    }

    // Klasa ViewHolder przechowująca referencje do widoków elementu listy
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, detailsTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);
        }
    }
}
