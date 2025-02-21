package com.example.lab_1_2_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowNumberActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);

        // Nhận số từ Intent
        int receivedNumber = getIntent().getIntExtra("number", -1); // Lấy số từ Intent

        // Hiển thị số trong TextView
        TextView tvShowNumber = findViewById(R.id.tvShowNumber);
        tvShowNumber.setText("Số nhận được: " + receivedNumber);

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBackShowNumber);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước
    }
}
