package com.example.lab_1_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Question2Lab5Activity extends AppCompatActivity {
    private EditText edtTitle, edtDescription, edtPlatform, edtImageUrl;
    private RecyclerView recyclerView;
    private ModuleAdapter adapter;
    private ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        // Initialize EditTexts
        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDescription);
        edtPlatform = findViewById(R.id.edtPlatform);
        edtImageUrl = findViewById(R.id.edtImageUrl);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.moduleRecyclerView);
        modules = new ArrayList<>();

        // Add initial modules
        modules.add(new Module("ListView trong Android", "ListView là một thành phần dùng để nhóm nhiều mục (item)...", "Android", "https://vncoder.vn/upload/img/lesson/1583223832.PNG"));
        modules.add(new Module("Xử lý sự kiện trong iOS", "Xử lý sự kiện trong iOS. Sau khi các bạn đã biết cách thiết kế giao diện...", "iOS", "https://r2s.edu.vn/wp-content/uploads/2023/10/1.xu-ly-su-kien-trong-ios.png"));

        // Create and set adapter with OnItemClickListener
        adapter = new ModuleAdapter(this, modules, position -> {
            // On item click, populate EditText fields
            Module selectedModule = modules.get(position);
            edtTitle.setText(selectedModule.getTitle());
            edtDescription.setText(selectedModule.getDescription());
            edtPlatform.setText(selectedModule.getPlatform());
            edtImageUrl.setText(selectedModule.getImageURL());
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize buttons
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        // Add new module when "THÊM" button is clicked
        btnAdd.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            String description = edtDescription.getText().toString();
            String platform = edtPlatform.getText().toString();
            String imageUrl = edtImageUrl.getText().toString();

            if (title.isEmpty() || description.isEmpty() || platform.isEmpty() || imageUrl.isEmpty()) {
                Toast.makeText(Question2Lab5Activity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                modules.add(new Module(title, description, platform, imageUrl));
                adapter.notifyDataSetChanged();
                clearInputs();
            }
        });

        // Delete the last module when "DELETE" button is clicked
        btnDelete.setOnClickListener(v -> {
            if (!modules.isEmpty()) {
                modules.remove(modules.size() - 1); // Remove the last item
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(Question2Lab5Activity.this, "Danh sách trống", Toast.LENGTH_SHORT).show();
            }
        });

        // Update the last module when "CẬP NHẬT" button is clicked
        btnUpdate.setOnClickListener(v -> {
            if (!modules.isEmpty()) {
                Module module = modules.get(modules.size() - 1);  // Updating the last item as an example
                module.setTitle(edtTitle.getText().toString());
                module.setDescription(edtDescription.getText().toString());
                module.setPlatform(edtPlatform.getText().toString());
                module.setImageURL(edtImageUrl.getText().toString());
                adapter.notifyDataSetChanged();
                clearInputs();
            } else {
                Toast.makeText(Question2Lab5Activity.this, "Không có module để cập nhật", Toast.LENGTH_SHORT).show();
            }
        });

        // Initialize the Back Button
        Button btnBack = findViewById(R.id.btnBackQuestion2Lab5);
        btnBack.setOnClickListener(v -> {
            // Close the current activity and return to the previous one
            finish();
        });
    }

    // Clear input fields
    private void clearInputs() {
        edtTitle.setText("");
        edtDescription.setText("");
        edtPlatform.setText("");
        edtImageUrl.setText("");
    }
}
