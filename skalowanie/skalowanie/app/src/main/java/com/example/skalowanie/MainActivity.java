package com.example.skalowanie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private ImageView imageView;
    private Bitmap originalBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button buttonLoadImage = findViewById(R.id.buttonLoadImage);
        Button buttonScaleImage = findViewById(R.id.buttonScaleImage);

        // Wybierz zdjęcie z galerii
        buttonLoadImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE);
        });

        // Skalowanie zdjęcia
        buttonScaleImage.setOnClickListener(v -> {
            if (originalBitmap != null) {
                Bitmap scaledBitmap = scaleBitmap(originalBitmap, 100, 100); // Skala 100x100 px
                imageView.setImageBitmap(scaledBitmap);
            }
        });
    }

    // Metoda do przeskalowania obrazu
    private Bitmap scaleBitmap(Bitmap bitmap, int width, int height) {
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(imageUri);
                originalBitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(originalBitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}