package com.example.lab32;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thiết lập giao diện Edge-to-Edge nếu cần
        setupEdgeToEdge();

        // Ánh xạ và thiết lập dữ liệu cho ListView
        AnhXa();

        // Khởi tạo adapter và gán vào ListView
        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }

    // Phương thức setup giao diện Edge-to-Edge
    private void setupEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Phương thức ánh xạ view và tạo danh sách dữ liệu
    private void AnhXa() {
        lvTraiCay = findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();

        // Thêm dữ liệu mẫu
        arrayTraiCay.add(new TraiCay("Chuối tiêu", "Chuối tiêu Long An", R.drawable.chuoitieu));
        arrayTraiCay.add(new TraiCay("Thanh long", "Thanh long ruột đỏ", R.drawable.thanhlong));
        arrayTraiCay.add(new TraiCay("Dâu tây", "Dâu tây Đà Lạt", R.drawable.dautay));
        arrayTraiCay.add(new TraiCay("Dưa hấu", "Dưa hấu Tiền Giang", R.drawable.duahau));
        arrayTraiCay.add(new TraiCay("Cam vàng", "Cam vàng nhập khẩu", R.drawable.camvang));

    }
}