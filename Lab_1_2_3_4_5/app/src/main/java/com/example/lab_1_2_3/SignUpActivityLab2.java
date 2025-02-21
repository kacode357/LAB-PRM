package com.example.lab_1_2_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivityLab2 extends AppCompatActivity {
    // Views
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvAlreadyAccount;
    private Button btnSignUp;

    // Notify message
    private final String REQUIRE = "Require";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_lab2);

        // Ánh xạ các view
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);
        Button btnBack = findViewById(R.id.btnSignUp);

        // Xử lý sự kiện khi nhấn "Already Account? Sign In"
        tvAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivityLab2.this, SignInActivityLab2.class);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý sự kiện khi nhấn "Sign Up"
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        // Xử lý khi nhấn nút back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Kiểm tra đầu vào
    private boolean checkInput() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }

        if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    // Xử lý đăng ký
    private void signUp() {
        if (!checkInput()) {
            return;
        }

        // Giả lập đăng ký thành công
        Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

        // Chuyển đến màn hình đăng nhập
        Intent intent = new Intent(this, SignInActivityLab2.class);
        startActivity(intent);
        finish(); // Đóng màn hình đăng ký
    }
}
