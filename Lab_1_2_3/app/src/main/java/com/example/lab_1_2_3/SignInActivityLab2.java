package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivityLab2 extends AppCompatActivity {
    // Views
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNotAccountYet;
    private Button btnSignIn;

    // Notify message
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_lab2);

        // Ánh xạ các view
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvNotAccountYet = findViewById(R.id.tvNotAccountYet);
        btnSignIn = findViewById(R.id.btnSignIn);
        Button btnBack = findViewById(R.id.btnBackSignIn);

        // Xử lý sự kiện khi nhấn "Create Account"
        tvNotAccountYet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivityLab2.this, SignUpActivityLab2.class);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý sự kiện khi nhấn "Sign In"
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
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

        return true;
    }

    // Xử lý đăng nhập
    private void signIn() {
        if (!checkInput()) {
            return;
        }

        // Giả lập đăng nhập thành công
        Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show();

        // Chuyển đến màn hình chính (hoặc màn hình khác tùy mục đích)
        Intent intent = new Intent(this, Lab2Activity.class);
        startActivity(intent);
        finish(); // Đóng màn hình đăng nhập
    }
}
