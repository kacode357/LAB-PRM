package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Gán sự kiện click cho LAB 1
        TextView tvLab1 = findViewById(R.id.tvLab1);
        tvLab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab1Activity.class);
                startActivity(intent);
            }
        });
        TextView tvLab2 = findViewById(R.id.tvLab2);
        tvLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2Activity.class);
                startActivity(intent);
            }
        });
        TextView tvLab3 = findViewById(R.id.tvLab3);
        tvLab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab3Activity.class);
                startActivity(intent);
            }
        });
        TextView tvLab4 = findViewById(R.id.tvLab4);
        tvLab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab4Activity.class);
                startActivity(intent);
            }
        });
        TextView tvLab5 = findViewById(R.id.tvLab5);
        tvLab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab5Activity.class);
                startActivity(intent);
            }
        });

    }
}