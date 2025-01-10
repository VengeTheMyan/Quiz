package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;  // Import Picasso

public class StartQuizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        Button startQuizButton = findViewById(R.id.startQuizButton);
        ImageView imageView = findViewById(R.id.imageView);

        // Image URL to load
        String imageUrl = "https://static.wikitide.net/greatcharacterswiki/f/f9/Xfgfjbvdhbvjhsdb.png";  // Replace with your actual image URL

        // Use Picasso to load the image into the ImageView
        Picasso.get()
                .load(imageUrl)  // The image URL
                .into(imageView);  // The ImageView where the image will be loaded

        // Handle the Start Quiz button click event
        startQuizButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartQuizActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
