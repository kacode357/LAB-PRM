package com.example.minigame2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class MaxSelectionDialogActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_selection_dialog);

        // Tìm TextView và Button trong layout
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        Button buttonClose = findViewById(R.id.buttonClose);

        // Thiết lập nội dung thông báo
        textViewMessage.setText("Bạn chỉ có thể chọn tối đa 2 con!");

        // Đóng dialog khi nhấn nút
        buttonClose.setOnClickListener(v -> finish());
    }
}
