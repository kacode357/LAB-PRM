package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowStringActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_string);

        // Lấy chuỗi từ Intent
        Intent intent = getIntent();
        String receivedString = intent.getStringExtra("string");

        // Hiển thị chuỗi
        TextView textView = findViewById(R.id.tvShowString);
        textView.setText(receivedString);

        Button btnBack = findViewById(R.id.btnBackShowString);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước
    }
}
