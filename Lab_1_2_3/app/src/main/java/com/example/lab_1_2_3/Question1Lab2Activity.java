package com.example.lab_1_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Question1Lab2Activity extends AppCompatActivity {
    private EditText minInput, maxInput;
    private TextView resultText;
    private Button generateButton, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_lab2);

        // Ánh xạ các View
        minInput = findViewById(R.id.minInput);
        maxInput = findViewById(R.id.maxInput);
        resultText = findViewById(R.id.resultText);
        generateButton = findViewById(R.id.generateButton);
        btnBack = findViewById(R.id.btnBackQuestion1Lab2);

        // Thiết lập sự kiện nhấn nút Generate
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomNumber();
            }
        });

        // Xử lý khi bấm nút quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước
            }
        });
    }

    private void generateRandomNumber() {
        String minStr = minInput.getText().toString();
        String maxStr = maxInput.getText().toString();

        // Kiểm tra nếu các trường input không bị trống
        if (!minStr.isEmpty() && !maxStr.isEmpty()) {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            // Đảm bảo min nhỏ hơn max
            if (min < max) {
                Random random = new Random();
                int randomNumber = random.nextInt((max - min) + 1) + min; // Random số từ min đến max
                resultText.setText("Result: " + randomNumber);
            } else {
                resultText.setText("Error: Min must be less than Max!");
            }
        } else {
            resultText.setText("Error: Please enter both Min and Max!");
        }
    }
}
