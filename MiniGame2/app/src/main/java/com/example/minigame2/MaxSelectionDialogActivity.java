package com.example.minigame2;

import static androidx.activity.EdgeToEdge.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MaxSelectionDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_max_selection_dialog);

        // Tìm TextView và Button trong layout
        Button buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(v -> finish());
    }
}
