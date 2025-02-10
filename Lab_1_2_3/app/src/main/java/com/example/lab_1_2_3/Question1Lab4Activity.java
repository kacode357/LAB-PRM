package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Question1Lab4Activity extends AppCompatActivity {

    private TextView tvSelectedFoodDrink;
    private String selectedFood = "";
    private String selectedDrink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_lab4);

        tvSelectedFoodDrink = findViewById(R.id.tvSelectedFoodDrink);
        Button btnChooseFood = findViewById(R.id.btnChooseFood);
        Button btnChooseDrink = findViewById(R.id.btnChooseDrink);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnBack = findViewById(R.id.btnBackQuestion1Lab4);

        // Mở Activity chọn thức ăn
        btnChooseFood.setOnClickListener(v -> {
            Intent intent = new Intent(Question1Lab4Activity.this, SelectFoodActivity.class);
            startActivityForResult(intent, 1);
        });

        // Mở Activity chọn đồ uống
        btnChooseDrink.setOnClickListener(v -> {
            Intent intent = new Intent(Question1Lab4Activity.this, SelectDrinkActivity.class);
            startActivityForResult(intent, 2);
        });

        // Thoát Activity
        btnExit.setOnClickListener(v -> finish());

        // Quay lại màn hình trước đó
        btnBack.setOnClickListener(v -> finish());
    }

    // Nhận dữ liệu gửi về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 1) { // Chọn thức ăn
                selectedFood = data.getStringExtra("SELECTED_FOOD");
            } else if (requestCode == 2) { // Chọn đồ uống
                selectedDrink = data.getStringExtra("SELECTED_DRINK");
            }
            updateSelectedFoodDrink();
        }
    }

    // Cập nhật hiển thị món ăn & đồ uống đã chọn
    private void updateSelectedFoodDrink() {
        String result = !selectedFood.isEmpty() && !selectedDrink.isEmpty()
                ? selectedFood + " - " + selectedDrink
                : selectedFood.isEmpty() ? selectedDrink : selectedFood;
        tvSelectedFoodDrink.setText(result);
    }
}
