package com.example.minigame2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonVaoCuoc = findViewById(R.id.buttonVaoCuoc);
        buttonVaoCuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển đến màn hình CuocActivity khi nhấn nút "Vào cược"
                Intent intent = new Intent(MainActivity.this, CuocActivity.class);
                startActivity(intent);
            }
        });
    }
}
