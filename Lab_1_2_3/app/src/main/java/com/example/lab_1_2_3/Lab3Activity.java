package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Lab3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        // Xử lý sự kiện khi bấm vào nút quay lại
        Button btnBack = findViewById(R.id.btnBackLab3);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay lại màn hình trước
            }
        });

        // Xử lý sự kiện khi nhấn vào "Question 1"
        TextView tvQuestion1 = findViewById(R.id.tvQuestion1Lab3);
        tvQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3Activity.this, Question1Lab3Activity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn vào "Question 2"
        TextView tvQuestion2 = findViewById(R.id.tvQuestion2Lab3);
        tvQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3Activity.this, Question2Lab3Activity.class);
                startActivity(intent);
            }
        });
    }
}
