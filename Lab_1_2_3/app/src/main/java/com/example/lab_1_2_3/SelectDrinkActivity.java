package com.example.lab_1_2_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectDrinkActivity extends AppCompatActivity {

    private String[] drinkItems = {"Coca", "Pepsi", "Trà sữa", "Nước cam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_drink);

        ListView listView = findViewById(R.id.listViewDrink);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drinkItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedDrink = drinkItems[position];

            // Trả dữ liệu về `Question1Lab4Activity`
            Intent resultIntent = new Intent();
            resultIntent.putExtra("SELECTED_DRINK", selectedDrink);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
