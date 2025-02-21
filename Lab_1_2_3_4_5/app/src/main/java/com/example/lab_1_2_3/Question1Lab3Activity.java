package com.example.lab_1_2_3;

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

public class Question1Lab3Activity extends AppCompatActivity {
    private EditText etMonHoc;
    private Button btnThem, btnCapNhat, btnBack;
    private ListView lvMonHoc;
    private ArrayList<String> arraycourse;
    private ArrayAdapter<String> adapter;
    private int currentEditPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_lab3);

        // Ánh xạ các View
        etMonHoc = findViewById(R.id.etMonHoc);
        btnThem = findViewById(R.id.btnThem);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        btnBack = findViewById(R.id.btnBackQuestion1Lab3);
        lvMonHoc = findViewById(R.id.ListViewMonHoc);

        // Dữ liệu mẫu ban đầu
        arraycourse = new ArrayList<>();
        arraycourse.add("Android");
        arraycourse.add("PHP");
        arraycourse.add("iOS");
        arraycourse.add("Unity");
        arraycourse.add("ASP.net");

        // Adapter cho ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraycourse);
        lvMonHoc.setAdapter(adapter);

        // Xử lý sự kiện thêm môn học
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newCourse = etMonHoc.getText().toString().trim();
                if (!newCourse.isEmpty()) {
                    arraycourse.add(newCourse);
                    adapter.notifyDataSetChanged();
                    etMonHoc.setText("");
                    Toast.makeText(Question1Lab3Activity.this, "Đã thêm: " + newCourse, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question1Lab3Activity.this, "Vui lòng nhập tên môn học!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện cập nhật môn học
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentEditPosition != -1) {
                    String updatedCourse = etMonHoc.getText().toString().trim();
                    if (!updatedCourse.isEmpty()) {
                        arraycourse.set(currentEditPosition, updatedCourse);
                        adapter.notifyDataSetChanged();
                        etMonHoc.setText("");
                        currentEditPosition = -1;
                        Toast.makeText(Question1Lab3Activity.this, "Đã cập nhật: " + updatedCourse, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Question1Lab3Activity.this, "Vui lòng nhập tên môn học để cập nhật!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Question1Lab3Activity.this, "Không có môn học nào được chọn để cập nhật!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện chọn môn học trong ListView để cập nhật
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = arraycourse.get(position);
                etMonHoc.setText(selectedCourse);
                currentEditPosition = position;
            }
        });

        // Xử lý sự kiện xóa môn học khi nhấn giữ
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String removedCourse = arraycourse.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(Question1Lab3Activity.this, "Đã xóa: " + removedCourse, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // Xử lý khi nhấn nút quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
