package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowArrayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_array);

        // Lấy mảng chuỗi từ Intent
        Intent intent = getIntent();
        String[] receivedArray = intent.getStringArrayExtra("stringArray");

        // Hiển thị mảng chuỗi
        StringBuilder arrayString = new StringBuilder("Mảng nhận được: \n");
        for (String item : receivedArray) {
            arrayString.append(item).append("\n");
        }

        TextView textView = findViewById(R.id.tvShowArray);
        textView.setText(arrayString.toString());

        Button btnBack = findViewById(R.id.btnBackShowArray);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước
    }
}
