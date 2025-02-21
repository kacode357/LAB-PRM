package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Question1Lab4Activity extends AppCompatActivity {

    private TextView tvTotalPrice;
    private String selectedFood = "";
    private String selectedDrink = "";
    private TableLayout llSelectedItems; // Để chứa các món ăn và đồ uống đã chọn
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1_lab4);

        llSelectedItems = findViewById(R.id.llSelectedItems); // Khởi tạo TableLayout
        tvTotalPrice = findViewById(R.id.tvTotalPrice); // Khởi tạo TextView hiển thị tổng giá
        Button btnChooseFood = findViewById(R.id.btnChooseFood);
        Button btnChooseDrink = findViewById(R.id.btnChooseDrink);

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



        // Quay lại màn hình trước đó
        btnBack.setOnClickListener(v -> finish());
    }

    // Nhận dữ liệu gửi về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 1) { // Chọn thức ăn
                ArrayList<String> selectedFoodList = data.getStringArrayListExtra("SELECTED_FOOD_LIST");
                ArrayList<Integer> selectedFoodPrices = data.getIntegerArrayListExtra("SELECTED_FOOD_PRICES");
                ArrayList<Integer> selectedFoodQuantities = data.getIntegerArrayListExtra("SELECTED_FOOD_QUANTITIES");

                selectedFood = "";
                totalPrice = 0; // Reset tổng giá
                if (selectedFoodList != null) {
                    for (int i = 0; i < selectedFoodList.size(); i++) {
                        String foodName = selectedFoodList.get(i);
                        int foodPrice = selectedFoodPrices.get(i);
                        int foodQuantity = selectedFoodQuantities.get(i);
                        selectedFood += foodName + " (Số lượng: " + foodQuantity + ", Giá: " + foodPrice + " VND)\n";

                        // Tính tổng giá
                        totalPrice += foodPrice * foodQuantity;

                        // Tạo TableRow để hiển thị món ăn
                        TableRow tableRow = new TableRow(this);

                        // Tạo TextView cho tên món ăn
                        TextView foodNameView = new TextView(this);
                        foodNameView.setText(foodName);
                        foodNameView.setTextSize(16);
                        foodNameView.setPadding(8, 8, 8, 8);
                        foodNameView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Tạo TextView cho số lượng món ăn
                        TextView quantityView = new TextView(this);
                        quantityView.setText(String.valueOf(foodQuantity));
                        quantityView.setTextSize(16);
                        quantityView.setPadding(8, 8, 8, 8);
                        quantityView.setGravity(Gravity.END);  // Canh phải cho số lượng
                        quantityView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Tạo TextView cho giá món ăn
                        TextView priceView = new TextView(this);
                        priceView.setText(foodPrice + " VND");
                        priceView.setTextSize(16);
                        priceView.setPadding(8, 8, 8, 8);
                        priceView.setGravity(Gravity.END);  // Canh phải cho giá
                        priceView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Thêm các TextView vào TableRow
                        tableRow.addView(foodNameView);
                        tableRow.addView(quantityView);
                        tableRow.addView(priceView);

                        // Thêm TableRow vào TableLayout
                        llSelectedItems.addView(tableRow);
                    }
                }
            } else if (requestCode == 2) { // Chọn đồ uống
                ArrayList<String> selectedDrinkList = data.getStringArrayListExtra("SELECTED_DRINK_LIST");
                ArrayList<Integer> selectedDrinkPrices = data.getIntegerArrayListExtra("SELECTED_DRINK_PRICES");
                ArrayList<Integer> selectedDrinkQuantities = data.getIntegerArrayListExtra("SELECTED_DRINK_QUANTITIES");

                selectedDrink = "";
                if (selectedDrinkList != null) {
                    for (int i = 0; i < selectedDrinkList.size(); i++) {
                        String drinkName = selectedDrinkList.get(i);
                        int drinkPrice = selectedDrinkPrices.get(i);
                        int drinkQuantity = selectedDrinkQuantities.get(i);
                        selectedDrink += drinkName + " (Số lượng: " + drinkQuantity + ", Giá: " + drinkPrice + " VND)\n";

                        // Tính tổng giá
                        totalPrice += drinkPrice * drinkQuantity;

                        // Tạo TableRow để hiển thị đồ uống
                        TableRow tableRow = new TableRow(this);

                        // Tạo TextView cho tên đồ uống
                        TextView drinkNameView = new TextView(this);
                        drinkNameView.setText(drinkName);
                        drinkNameView.setTextSize(16);
                        drinkNameView.setPadding(8, 8, 8, 8);
                        drinkNameView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Tạo TextView cho số lượng đồ uống
                        TextView drinkQuantityView = new TextView(this);
                        drinkQuantityView.setText(String.valueOf(drinkQuantity));
                        drinkQuantityView.setTextSize(16);
                        drinkQuantityView.setPadding(8, 8, 8, 8);
                        drinkQuantityView.setGravity(Gravity.END);  // Canh phải cho số lượng
                        drinkQuantityView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Tạo TextView cho giá đồ uống
                        TextView drinkPriceView = new TextView(this);
                        drinkPriceView.setText(drinkPrice + " VND");
                        drinkPriceView.setTextSize(16);
                        drinkPriceView.setPadding(8, 8, 8, 8);
                        drinkPriceView.setGravity(Gravity.END);  // Canh phải cho giá
                        drinkPriceView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));

                        // Thêm các TextView vào TableRow
                        tableRow.addView(drinkNameView);
                        tableRow.addView(drinkQuantityView);
                        tableRow.addView(drinkPriceView);

                        // Thêm TableRow vào TableLayout
                        llSelectedItems.addView(tableRow);
                    }
                }
            }
            updateTotalPrice();
        }

    }

    // Cập nhật tổng giá
    private void updateTotalPrice() {
        tvTotalPrice.setText("Tổng giá: " + totalPrice + " VND");
    }
}
