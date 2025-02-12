package com.example.minigame2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TextView messageText = findViewById(R.id.textViewMessage);
        Button buttonClose = findViewById(R.id.buttonClose);

        messageText.setText("Vui lòng chọn mức tiền cược!");

        buttonClose.setOnClickListener(v -> finish()); // Đóng activity khi nhấn
    }
}
