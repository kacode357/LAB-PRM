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
    private TextView resultText, resultTextDetails;
    private Button generateButton, btnBack;

    // Define a constant for the maximum allowed value
    private static final int MAX_ALLOWED_VALUE = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_lab2);

        // Ánh xạ các View
        minInput = findViewById(R.id.minInput);
        maxInput = findViewById(R.id.maxInput);
        resultText = findViewById(R.id.resultText);
        resultTextDetails = findViewById(R.id.resultTextDetail);
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

            // Kiểm tra nếu Max không vượt quá giá trị tối đa cho phép
            if (max > MAX_ALLOWED_VALUE) {
                Toast.makeText(this, "Error: Max cannot be greater than " + MAX_ALLOWED_VALUE, Toast.LENGTH_SHORT).show();
                return; // Dừng hàm nếu Max vượt quá giới hạn
            }

            // Đảm bảo min nhỏ hơn max
            if (min < max) {
                Random random = new Random();
                int randomNumber = random.nextInt((max - min) + 1) + min; // Random số từ min đến max
                resultText.setText(String.valueOf(randomNumber));

                resultTextDetails.setText("Min: " + min + ", Max: " + max);
            } else {
                resultText.setText("Error: Min must be less than Max!");
            }
        } else {
            resultText.setText("Error: Please enter both Min and Max!");
        }
    }
}
