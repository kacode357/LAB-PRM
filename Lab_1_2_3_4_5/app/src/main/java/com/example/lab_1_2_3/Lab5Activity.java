package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Lab5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        // Xử lý sự kiện khi bấm vào nút quay lại
        Button btnBackLab5 = findViewById(R.id.btnBackLab5);
        btnBackLab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay lại màn hình trước
            }
        });

        // Xử lý sự kiện khi nhấn vào "Questions 1"
        TextView tvQuestion1Lab5 = findViewById(R.id.tvQuestion1Lab5);
        tvQuestion1Lab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình Question 1
                Intent intent = new Intent(Lab5Activity.this, Question1Lab5Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào "Questions 2"
        TextView tvQuestion2Lab5 = findViewById(R.id.tvQuestion2Lab5);
        tvQuestion2Lab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình Question 2
                Intent intent = new Intent(Lab5Activity.this, Question2Lab5Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào "Questions 3"
//        TextView tvQuestion3Lab5 = findViewById(R.id.tvQuestion3Lab5);
//        tvQuestion3Lab5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Chuyển sang màn hình Question 3
//                Intent intent = new Intent(Lab5Activity.this, Question3Lab5Activity.class);
//                startActivity(intent);
//            }
//        });
    }
}
