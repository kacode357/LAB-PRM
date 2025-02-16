package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExtraExercise2Lab4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_exercise_2_lab4);

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBackExtraExercise2Lab4);
        btnBack.setOnClickListener(v -> finish()); // Quay lại màn hình trước

        // Nút gửi số
        Button btnSendNumber = findViewById(R.id.btnSendNumber);
        btnSendNumber.setOnClickListener(v -> {
            int predefinedNumber = 123;  // Số đã set sẵn
            Intent intent = new Intent(ExtraExercise2Lab4Activity.this, ShowNumberActivity.class);
            intent.putExtra("number", predefinedNumber);  // Truyền số qua Intent
            startActivity(intent);
        });

        // Nút gửi chuỗi
        Button btnSendString = findViewById(R.id.btnSendString);
        btnSendString.setOnClickListener(v -> {
            String predefinedString = "Hello, this is a string!";  // Chuỗi đã set sẵn
            Intent intent = new Intent(ExtraExercise2Lab4Activity.this, ShowStringActivity.class);
            intent.putExtra("string", predefinedString);  // Truyền chuỗi qua Intent
            startActivity(intent);
        });

        // Nút gửi mảng chuỗi
        Button btnSendArray = findViewById(R.id.btnSendArray);
        btnSendArray.setOnClickListener(v -> {
            String[] predefinedArray = {"Item 1", "Item 2", "Item 3", "Item 4"};  // Mảng chuỗi đã set sẵn
            Intent intent = new Intent(ExtraExercise2Lab4Activity.this, ShowArrayActivity.class);
            intent.putExtra("stringArray", predefinedArray);  // Truyền mảng qua Intent
            startActivity(intent);
        });

        // Nút gửi đối tượng HọcSinh
        Button btnSendStudent = findViewById(R.id.btnSendStudent);
        btnSendStudent.setOnClickListener(v -> {
            // Tạo các đối tượng HọcSinh
            HocSinh hocSinh1 = new HocSinh("Nguyễn Văn A", 2005);
            HocSinh hocSinh2 = new HocSinh("Trần Thị B", 2004);

            // Thêm các đối tượng HọcSinh vào ArrayList
            ArrayList<HocSinh> danhSachHocSinh = new ArrayList<>();
            danhSachHocSinh.add(hocSinh1);
            danhSachHocSinh.add(hocSinh2);

            // Truyền ArrayList qua Intent
            Intent intent = new Intent(ExtraExercise2Lab4Activity.this, ShowStudentActivity.class);
            intent.putExtra("danhSachHocSinh", danhSachHocSinh);  // Truyền ArrayList
            startActivity(intent);
        });

        // Nút gửi Bundle
        Button btnSendBundle = findViewById(R.id.btnSendBundle);
        btnSendBundle.setOnClickListener(v -> {
            // Tạo một Bundle mới và thêm dữ liệu vào đó
            Bundle bundle = new Bundle();

            // Thêm dữ liệu kiểu String và Int
            bundle.putString("message", "Hello from Bundle!");
            bundle.putInt("year", 2023);

            // Thêm mảng chuỗi vào Bundle
            String[] predefinedArray = {"Item 1", "Item 2", "Item 3", "Item 4"};
            bundle.putStringArray("stringArray", predefinedArray);

            // Thêm đối tượng vào Bundle (Đối tượng cần implement Serializable)
            HocSinh hocSinh = new HocSinh("Nguyễn Văn A", 2005); // Giả sử bạn đã có lớp HocSinh implement Serializable
            bundle.putSerializable("hocSinhObject", hocSinh);

            // Truyền Bundle qua Intent
            Intent intent = new Intent(ExtraExercise2Lab4Activity.this, ShowBundleActivity.class);
            intent.putExtras(bundle);  // Thêm Bundle vào Intent
            startActivity(intent);
        });

    }
}
