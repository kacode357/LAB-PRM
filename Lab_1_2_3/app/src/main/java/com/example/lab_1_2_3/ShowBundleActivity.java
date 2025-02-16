package com.example.lab_1_2_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class ShowBundleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bundle);

        // Nhận Bundle từ Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Nhận các dữ liệu trong Bundle
            String message = bundle.getString("message");
            int year = bundle.getInt("year");

            // Hiển thị thông tin thông thường
            TextView textView = findViewById(R.id.tvShowBundle);
            String displayText = "Message: " + message + "\nYear: " + year;

            // Nhận mảng chuỗi
            String[] stringArray = bundle.getStringArray("stringArray");
            if (stringArray != null) {
                displayText += "\nString Array: ";
                for (String item : stringArray) {
                    displayText += "\n" + item;
                }
            }

            // Nhận đối tượng HocSinh
            HocSinh hocSinh = (HocSinh) bundle.getSerializable("hocSinhObject");
            if (hocSinh != null) {
                displayText += "\n\nHocSinh: " + hocSinh.getHoTen() + " - " + hocSinh.getNamSinh();
            }

            // Cập nhật TextView với tất cả thông tin
            textView.setText(displayText);
        }

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBackShowBundle);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước
    }
}
