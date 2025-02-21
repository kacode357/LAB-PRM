package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Lab2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        // Xử lý sự kiện khi bấm vào nút quay lại
        Button btnBack = findViewById(R.id.btnBackLab2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay lại màn hình trước
            }
        });

        // Xử lý sự kiện khi nhấn vào "Question 1"
        TextView tvQuestion1 = findViewById(R.id.tvQuestion1Lab2);
        tvQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2Activity.this, Question1Lab2Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào "Question 2"
        TextView tvQuestion2 = findViewById(R.id.tvQuestion2Lab2);
        tvQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2Activity.this, Question2Lab2Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào "Question 3"
        TextView tvQuestion3 = findViewById(R.id.tvQuestion3Lab2);
        tvQuestion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2Activity.this, SignInActivityLab2.class);
                startActivity(intent);
            }
        });
    }
}
