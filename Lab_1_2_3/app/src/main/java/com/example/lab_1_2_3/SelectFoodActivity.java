package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectFoodActivity extends AppCompatActivity {

    private List<Food> foodList;
    private List<Food> selectedFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        // Khởi tạo danh sách món ăn
        foodList = new ArrayList<>();
        foodList.add(new Food("Bún Bò Huế", "Món bún truyền thống của Huế", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Bun-Bo-Hue-from-Huong-Giang-2011.jpg/400px-Bun-Bo-Hue-from-Huong-Giang-2011.jpg", 20));
        foodList.add(new Food("Cơm Gà", "Món cơm gà ngon miệng", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Arroz-con-Pollo.jpg/500px-Arroz-con-Pollo.jpg", 15));
        foodList.add(new Food("Phở Bò", "Món phở nổi tiếng Hà Nội", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Ph%E1%BB%9F_b%C3%B2%2C_C%E1%BA%A7u_Gi%E1%BA%A5y%2C_H%C3%A0_N%E1%BB%99i.jpg/500px-Ph%E1%BB%9F_b%C3%B2%2C_C%E1%BA%A7u_Gi%E1%BA%A5y%2C_H%C3%A0_N%E1%BB%99i.jpg", 25));
        foodList.add(new Food("Mì Quảng", "Món mì đặc sản miền Trung", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Spicy_noodle_soup_with_beef%2C_Festival_des_P%C3%A2tes%2C_Paris_001.jpg/600px-Spicy_noodle_soup_with_beef%2C_Festival_des_P%C3%A2tes%2C_Paris_001.jpg", 30));

        // Khởi tạo danh sách món đã chọn
        selectedFoodList = new ArrayList<>();

        // Gán adapter
        ListView listView = findViewById(R.id.listViewFood);
        FoodAdapter foodAdapter = new FoodAdapter(this, R.layout.item_food, foodList);
        listView.setAdapter(foodAdapter);

        // Xử lý khi nhấn nút xác nhận
        findViewById(R.id.btnConfirmSelection).setOnClickListener(v -> {
            // Lọc ra các món đã chọn
            selectedFoodList.clear();
            for (Food food : foodList) {
                if (food.getQuantity() > 0) { // Nếu số lượng > 0 thì coi là đã chọn
                    selectedFoodList.add(food);
                }
            }

            // Kiểm tra xem có món nào đã chọn chưa
            if (!selectedFoodList.isEmpty()) {
                // Trả dữ liệu về Activity trước đó
                Intent resultIntent = new Intent();
                ArrayList<String> selectedFoodNames = new ArrayList<>();
                ArrayList<Integer> selectedFoodPrices = new ArrayList<>();
                ArrayList<Integer> selectedFoodQuantities = new ArrayList<>();

                // Thêm thông tin tên món, giá và số lượng
                for (Food food : selectedFoodList) {
                    selectedFoodNames.add(food.getTen());
                    selectedFoodPrices.add(food.getGia());
                    selectedFoodQuantities.add(food.getQuantity());
                }

                resultIntent.putStringArrayListExtra("SELECTED_FOOD_LIST", selectedFoodNames);
                resultIntent.putIntegerArrayListExtra("SELECTED_FOOD_PRICES", selectedFoodPrices);
                resultIntent.putIntegerArrayListExtra("SELECTED_FOOD_QUANTITIES", selectedFoodQuantities);

                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(SelectFoodActivity.this, "Vui lòng chọn ít nhất một món ăn!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
