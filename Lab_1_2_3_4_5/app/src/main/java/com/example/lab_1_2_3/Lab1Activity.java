package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Lab1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        // Xử lý sự kiện khi bấm vào nút quay lại
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay lại màn hình trước
            }
        });

        // Xử lý sự kiện khi nhấn vào "Questions 1.a"
        TextView tvQuestion1a = findViewById(R.id.tvQuestion1a);
        tvQuestion1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình Question 1.a
                Intent intent = new Intent(Lab1Activity.this, Question1aActivity.class);
                startActivity(intent);
            }
        });
        // Xử lý sự kiện khi nhấn vào "Questions 1.b"
        TextView tvQuestion1b = findViewById(R.id.tvQuestion1b);
        tvQuestion1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this, Question1bActivity.class);
                startActivity(intent);
            }
        });
        // Xử lý sự kiện khi nhấn vào "Questions 2"
        TextView tvQuestion2 = findViewById(R.id.tvQuestion2);
        tvQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this, Question2Activity.class);
                startActivity(intent);
            }
        });
        // Xử lý sự kiện khi nhấn vào "Questions 3"
        TextView tvQuestion3 = findViewById(R.id.tvQuestion3);
        tvQuestion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this, Question3Activity.class);
                startActivity(intent);
            }
        });

    }
}
