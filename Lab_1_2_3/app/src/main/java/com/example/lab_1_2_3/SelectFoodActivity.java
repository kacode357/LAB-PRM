package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectFoodActivity extends AppCompatActivity {

    private String[] foodItems = {"Bún Bò Huế", "Cơm Gà", "Phở Bò", "Mì Quảng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        ListView listView = findViewById(R.id.listViewFood);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedFood = foodItems[position];

            // Trả dữ liệu về `Question1Lab4Activity`
            Intent resultIntent = new Intent();
            resultIntent.putExtra("SELECTED_FOOD", selectedFood);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
