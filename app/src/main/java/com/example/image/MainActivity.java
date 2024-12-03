package com.example.image;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // Inicjacja obiektów na aktywnosci
    private ImageView myImageView;
    private Button btnSelectImage;
    private Button resetButton;
    private Button filterButton;
    private Button resetFiltrButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicjacja
        myImageView = findViewById(R.id.myImageView);
        btnSelectImage=findViewById(R.id.btnSelectImage);
        resetButton = findViewById(R.id.resetButton);
        filterButton = findViewById(R.id.filterButton);
        resetFiltrButton = findViewById(R.id.resetFiltrButton);

        ActivityResultLauncher<Intent> pickImageLauncher = registerForActivityResult (
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if(result.getResultCode()==RESULT_OK) {
                        Intent data = result.getData();
                        if (data!=null) {
                            Uri imageUri = data.getData();
                            try {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                                myImageView.setImageBitmap(bitmap);
                            }
                            catch (IOException e) {
                                Toast.makeText(this, "Błąd wczytywania obrazka", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
        btnSelectImage.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImageLauncher.launch(intent);
        });

        resetButton.setOnClickListener(view ->{
            myImageView.setImageBitmap(null);
        });

        filterButton.setOnClickListener(view -> {
            myImageView.setColorFilter(Color.argb(150,0,0,0));
        });

        resetFiltrButton.setOnClickListener(view -> {
            myImageView.setColorFilter(Color.argb(0,0,0,0));
        });

    }
}