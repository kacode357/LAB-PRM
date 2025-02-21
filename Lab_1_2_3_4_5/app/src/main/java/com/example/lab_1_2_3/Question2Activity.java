package com.example.lab_1_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question2Activity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private Button btnSignIn, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // Ánh xạ view
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.btn_signin);
        btnBack = findViewById(R.id.btnBackQuestion2);

        // Xử lý khi nhấn nút quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước
            }
        });

        // Xử lý sự kiện đăng nhập
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Question2Activity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question2Activity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
