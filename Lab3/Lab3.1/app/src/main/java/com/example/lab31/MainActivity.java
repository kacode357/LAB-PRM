package com.example.lab31;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etMonHoc;
    Button btnThem, btnCapNhat;
    ListView lvMonhoc;
    ArrayList<String> arraycourse;
    ArrayAdapter<String> adapter;
    int currentEditPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMonHoc = findViewById(R.id.etMonHoc);
        btnThem = findViewById(R.id.btnThem);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        lvMonhoc = findViewById(R.id.ListViewMonHoc);

        arraycourse = new ArrayList<>();
        arraycourse.add("Android");
        arraycourse.add("PHP");
        arraycourse.add("iOS");
        arraycourse.add("Unity");
        arraycourse.add("ASP.net");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arraycourse
        );

        lvMonhoc.setAdapter(adapter);

        // Logic thêm môn học
        btnThem.setOnClickListener(v -> {
            String newCourse = etMonHoc.getText().toString().trim();
            if (!newCourse.isEmpty()) {
                arraycourse.add(newCourse);
                adapter.notifyDataSetChanged();
                etMonHoc.setText("");
                Toast.makeText(MainActivity.this, "Đã thêm: " + newCourse, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
            }
        });

        // Logic cập nhật môn học
        btnCapNhat.setOnClickListener(v -> {
            if (currentEditPosition != -1) {
                String updatedCourse = etMonHoc.getText().toString().trim();
                if (!updatedCourse.isEmpty()) {
                    arraycourse.set(currentEditPosition, updatedCourse);
                    adapter.notifyDataSetChanged();
                    etMonHoc.setText("");
                    currentEditPosition = -1;
                    Toast.makeText(MainActivity.this, "Đã cập nhật: " + updatedCourse, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên môn học để cập nhật!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Không có môn học nào được chọn để cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });

        // Logic sửa môn học khi nhấn vào ListView
        lvMonhoc.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCourse = arraycourse.get(position);
            etMonHoc.setText(selectedCourse);
            currentEditPosition = position;
        });

        // Logic xóa môn học khi nhấn giữ
        lvMonhoc.setOnItemLongClickListener((parent, view, position, id) -> {
            String removedCourse = arraycourse.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Đã xóa: " + removedCourse, Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}
