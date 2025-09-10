package com.example.photoinfo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnImage;
    ImageView imageView;
    TextView textInfo;

    //Obsługa obrazków w oknie wczytywania
    private final ActivityResultLauncher<Intent> imagePicker =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    if (imageUri != null) {
                        imageView.setImageURI(imageUri);
                        showInfo(imageUri);
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnImage = findViewById(R.id.btnImage);
        imageView = findViewById(R.id.imageView);
        textInfo = findViewById(R.id.textInfo);

        btnImage.setOnClickListener(view -> openImagePicker());
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        imagePicker.launch(intent);
    }

    private void showInfo(Uri uri) {
        String name = "brak";
        long size = 0;
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor != null) {
            int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
            if (cursor.moveToFirst()) {
                name = cursor.getString(nameIndex);
                size = cursor.getLong(sizeIndex);
            }
            cursor.close();
        }
        int width = 0;
        int height = 0;

        try {
            InputStream inputStream = resolver.openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            width = options.outWidth;
            height = options.outHeight;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Formatowanie rozmiaru
        String sizeText;
        if (size<1024*1024){
            sizeText = (size/1024) + " KB";
        } else {
            sizeText = String.format("%.2f MB", size /(1024.0 * 1024.0));
        }

        // Tworzenie opisu
        String info = "Nazwa: " + name
                + "\nRozmiar: " + sizeText
                + "\nRozdzielczość: " + width + " x " + height;

        textInfo.setText(info);
    }
};