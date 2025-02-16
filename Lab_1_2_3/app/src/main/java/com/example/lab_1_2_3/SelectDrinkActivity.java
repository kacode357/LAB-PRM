package com.example.lab_1_2_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectDrinkActivity extends AppCompatActivity {

    private List<Drink> drinkList;
    private List<Drink> selectedDrinkList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_drink);

        // Khởi tạo danh sách đồ uống
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Coca", "Nước ngọt có gas", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/15-09-26-RalfR-WLC-0098_-_Coca-Cola_glass_bottle_%28Germany%29.jpg/484px-15-09-26-RalfR-WLC-0098_-_Coca-Cola_glass_bottle_%28Germany%29.jpg", 10));
        drinkList.add(new Drink("Pepsi", "Nước ngọt có gas", "https://minhcaumart.vn/media/com_eshop/products/8934588012228%201.jpg", 15));
        drinkList.add(new Drink("Trà sữa", "Trà sữa thơm ngon", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Milk_tea_white_cup.jpg/600px-Milk_tea_white_cup.jpg", 20));
        drinkList.add(new Drink("Nước cam", "Nước ép từ cam tươi", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Orangeade.jpg/440px-Orangeade.jpg", 25));

        // Khởi tạo danh sách đồ uống đã chọn
        selectedDrinkList = new ArrayList<>();

        // Gán adapter
        ListView listView = findViewById(R.id.listViewDrink);
        DrinkAdapter drinkAdapter = new DrinkAdapter(this, R.layout.item_drink, drinkList);
        listView.setAdapter(drinkAdapter);

        // Xử lý khi nhấn nút xác nhận
        findViewById(R.id.btnConfirmSelection).setOnClickListener(v -> {
            // Lọc ra các đồ uống đã chọn
            selectedDrinkList.clear();
            for (Drink drink : drinkList) {
                if (drink.getQuantity() > 0) { // Nếu số lượng > 0 thì coi là đã chọn
                    selectedDrinkList.add(drink);
                }
            }

            // Kiểm tra xem có đồ uống nào đã chọn chưa
            if (!selectedDrinkList.isEmpty()) {
                // Trả dữ liệu về Activity trước đó
                Intent resultIntent = new Intent();
                ArrayList<String> selectedDrinkNames = new ArrayList<>();
                ArrayList<Integer> selectedDrinkPrices = new ArrayList<>();
                ArrayList<Integer> selectedDrinkQuantities = new ArrayList<>();

                // Thêm thông tin tên đồ uống, giá và số lượng
                for (Drink drink : selectedDrinkList) {
                    selectedDrinkNames.add(drink.getTen());
                    selectedDrinkPrices.add(drink.getGia());
                    selectedDrinkQuantities.add(drink.getQuantity());
                }

                resultIntent.putStringArrayListExtra("SELECTED_DRINK_LIST", selectedDrinkNames);
                resultIntent.putIntegerArrayListExtra("SELECTED_DRINK_PRICES", selectedDrinkPrices);
                resultIntent.putIntegerArrayListExtra("SELECTED_DRINK_QUANTITIES", selectedDrinkQuantities);

                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(SelectDrinkActivity.this, "Vui lòng chọn ít nhất một đồ uống!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
