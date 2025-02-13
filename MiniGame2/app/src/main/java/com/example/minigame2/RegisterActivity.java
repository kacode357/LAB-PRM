package com.example.minigame2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailInput, playerNameInput, passwordInput, confirmPasswordInput;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailInput = findViewById(R.id.emailInput);
        playerNameInput = findViewById(R.id.playerNameInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        String email = emailInput.getText().toString().trim();
        String playerName = playerNameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        String confirmPassword = confirmPasswordInput.getText().toString().trim();

        if (email.isEmpty() || playerName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        saveToFile(email, password);
    }

    private void saveToFile(String email, String password) {
        try (FileOutputStream fos = openFileOutput("credentials.txt", MODE_APPEND);
             OutputStreamWriter writer = new OutputStreamWriter(fos)) {

            writer.write(email + "," + password + "\n");
            Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();

            // Navigate to login screen
            startActivity(new Intent(this, MainActivity.class));
            finish();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving credentials", Toast.LENGTH_SHORT).show();
        }
    }
}