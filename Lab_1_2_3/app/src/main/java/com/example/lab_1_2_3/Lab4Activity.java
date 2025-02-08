package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Lab4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        // Xử lý sự kiện khi bấm vào nút quay lại
        Button btnBack = findViewById(R.id.btnBackLab4);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại và quay lại màn hình trước
            }
        });

//        // Xử lý sự kiện khi nhấn vào "Question 1"
//        TextView tvQuestion1 = findViewById(R.id.tvQuestion1Lab4);
//        tvQuestion1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Lab4Activity.this, Question1Lab4Activity.class);
//                startActivity(intent);
//            }
//        });
//
        // Xử lý sự kiện khi nhấn vào "Bài tập làm thêm"
        TextView tvExtraExercise = findViewById(R.id.tvExtraExerciseLab4);
        tvExtraExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4Activity.this, ExtraExerciseLab4Activity.class);
                startActivity(intent);
            }
        });
    }
}
