package com.example.spinnerlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtWynik;
    private Spinner spinner;
    private ListView listView;

    private List spinnerItems;
    private List listViewItems;
    private ArrayAdapter listAdapter;
    private Boolean isSpinnerItemSelected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        txtWynik = findViewById(R.id.txtWynik);

// obsluga spinnera
// itemy
        spinnerItems = new ArrayList<>();
        spinnerItems.add("Masło za zeta");
        spinnerItems.add("Piffo za 2,5");
        spinnerItems.add("Mleko na deko");
//adapter spinnera
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);
// obsługa zdarzenia na spinnerze
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = spinnerItems.get(position);
                isSpinnerItemSelected = true;
                spinnerAdapter.notifyDataSetChanged();
                listViewItems.add(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                isSpinnerItemSelected = false;
            }
        });

// obsluga listView



    }
}