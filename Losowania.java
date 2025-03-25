import java.util.*;

public class Losowania {

    public static void main(String[] args) {
        System.out.println("Przykład 1: Losowanie liczby całkowitej z określonego zakresu");
        losowanieCalkowitej();
        
        System.out.println("\nPrzykład 2: Losowanie liczby zmiennoprzecinkowej (double)");
        losowanieDouble();
        
        System.out.println("\nPrzykład 3: Losowanie wartości boolean");
        losowanieBoolean();
        
        System.out.println("\nPrzykład 4: Losowanie elementu z listy (z powtórzeniami)");
        losowanieElementuZListy();
        
        System.out.println("\nPrzykład 5: Losowanie elementów z listy (bez powtórzeń – mieszanie listy)");
        losowanieElementowBezPowtorzen();
        
        System.out.println("\nPrzykład 6: Losowa permutacja tablicy (algorytm Fishera-Yatesa)");
        losowaPermutacjaTablicy();
        
        System.out.println("\nPrzykład 7: Generowanie losowego hasła");
        generowanieLosowegoHasla();
        
        System.out.println("\nPrzykład 8: Losowanie liczby według rozkładu Gaussa");
        losowanieGaussa();
        
        System.out.println("\nPrzykład 9: Losowanie elementu z tablicy (z powtórzeniami)");
        losowanieElementuZTablicy();
        
        System.out.println("\nPrzykład 10: Symulacja rzutu kostką");
        symulacjaRzutuKostka();
        
        System.out.println("\nPrzykład 11: Losowanie liczby z przedziału (np. 50-150)");
        losowanieZPrzedzialu();
    }
    
    // Przykład 1: Losowanie liczby całkowitej z określonego zakresu (np. 1-100)
    public static void losowanieCalkowitej() {
        Random rand = new Random();
        int min = 1, max = 100;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println("Losowa liczba z zakresu 1-100: " + randomNum);
    }
    
    // Przykład 2: Losowanie liczby zmiennoprzecinkowej (double) w przedziale [0, 1)
    public static void losowanieDouble() {
        Random rand = new Random();
        double randomDouble = rand.nextDouble();
        System.out.println("Losowa liczba double: " + randomDouble);
    }
    
    // Przykład 3: Losowanie wartości boolean (true lub false)
    public static void losowanieBoolean() {
        Random rand = new Random();
        boolean randomBool = rand.nextBoolean();
        System.out.println("Losowa wartość boolean: " + randomBool);
    }
    
    // Przykład 4: Losowanie elementu z listy (z powtórzeniami)
    public static void losowanieElementuZListy() {
        List<String> names = Arrays.asList("Adam", "Ewa", "Kasia", "Tomek", "Marek");
        Random rand = new Random();
        int randomIndex = rand.nextInt(names.size());
        String randomName = names.get(randomIndex);
        System.out.println("Losowe imię: " + randomName);
    }
    
    // Przykład 5: Losowanie elementów z listy (bez powtórzeń – mieszanie listy)
    public static void losowanieElementowBezPowtorzen() {
        List<String> names = new ArrayList<>(Arrays.asList("Adam", "Ewa", "Kasia", "Tomek", "Marek"));
        Collections.shuffle(names);
        System.out.println("Losowa kolejność imion:");
        for(String name : names) {
            System.out.println(name);
        }
    }
    
    // Przykład 6: Losowa permutacja tablicy za pomocą algorytmu Fishera-Yatesa
    public static void losowaPermutacjaTablicy() {
        int[] numbers = {1, 2, 3, 4, 5};
        Random rand = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Zamiana miejscami elementów
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        System.out.println("Losowa permutacja tablicy:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Przykład 7: Generowanie losowego hasła o zadanej długości
    public static void generowanieLosowegoHasla() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random rand = new Random();
        int passwordLength = 10;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int index = rand.nextInt(chars.length());
            password.append(chars.charAt(index));
        }
        System.out.println("Wygenerowane hasło: " + password.toString());
    }
    
    // Przykład 8: Losowanie liczby według rozkładu Gaussa (średnia 0, odchylenie standardowe 1)
    public static void losowanieGaussa() {
        Random rand = new Random();
        double gaussianValue = rand.nextGaussian();
        System.out.println("Losowa wartość Gaussa: " + gaussianValue);
    }
    
    // Przykład 9: Losowanie elementu z tablicy (z powtórzeniami)
    public static void losowanieElementuZTablicy() {
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};
        Random rand = new Random();
        String randomColor = colors[rand.nextInt(colors.length)];
        System.out.println("Losowy kolor: " + randomColor);
    }
    
    // Przykład 10: Symulacja rzutu kostką (kostka sześcienna: wartości 1-6)
    public static void symulacjaRzutuKostka() {
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        System.out.println("Wynik rzutu kostką: " + dice);
    }
    
    // Przykład 11: Losowanie liczby z przedziału (np. 50-150)
    public static void losowanieZPrzedzialu() {
        Random rand = new Random();
        int min = 50, max = 150;
        // Losujemy liczbę z przedziału [min, max] włącznie
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println("Losowa liczba z przedziału " + min + " do " + max + ": " + randomNum);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent">

    <!-- Miejsce na obrazek -->
    <ImageView
android:id="@+id/imageView"
android:layout_width="200dp"
android:layout_height="200dp"
android:layout_centerInParent="true"
android:src="@drawable/image1" />

    <!-- Przycisk do losowania obrazka -->
    <Button
android:id="@+id/randomizeButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Losuj obrazek"
android:layout_below="@id/imageView"
android:layout_centerHorizontal="true"
android:layout_marginTop="20dp" />

</RelativeLayout>

package com.example.losowanieobrazkow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Tablica z identyfikatorami zasobów obrazków
    private int[] imageIds = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };

    private ImageView imageView;
    private Button randomizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja widoków
        imageView = findViewById(R.id.imageView);
        randomizeButton = findViewById(R.id.randomizeButton);

        // Obsługa kliknięcia przycisku
        randomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Losowanie indeksu z tablicy imageIds
                Random random = new Random();
                int randomIndex = random.nextInt(imageIds.length);

                // Ustawienie losowego obrazka
                imageView.setImageResource(imageIds[randomIndex]);

                // Opcjonalnie: wyświetlenie komunikatu Toast z informacją o wybranym obrazku
                Toast.makeText(MainActivity.this, "Obrazek: " + (randomIndex + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
