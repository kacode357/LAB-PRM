package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);

        // Lấy ArrayList các đối tượng HọcSinh từ Intent
        Intent intent = getIntent();
        ArrayList<HocSinh> danhSachHocSinh = (ArrayList<HocSinh>) intent.getSerializableExtra("danhSachHocSinh");

        // Hiển thị thông tin của các HọcSinh
        TextView textView = findViewById(R.id.tvShowStudent);
        StringBuilder studentInfo = new StringBuilder();
        for (HocSinh hocSinh : danhSachHocSinh) {
            studentInfo.append("Họ tên: ").append(hocSinh.getHoTen())
                    .append("Năm sinh: ").append(hocSinh.getNamSinh())
                    .append("\n\n");
        }
        textView.setText(studentInfo.toString());

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBackShowStudent);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước
    }
}
