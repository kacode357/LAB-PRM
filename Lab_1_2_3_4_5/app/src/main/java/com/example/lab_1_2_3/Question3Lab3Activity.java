package com.example.lab_1_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Question3Lab3Activity extends AppCompatActivity {
    private EditText edtTen, edtMota, edtUrlHinh;
    private Button btnThem, btnCapNhat, btnBack, btnXoa;
    private ListView lvCauThuBongDa;
    private ArrayList<CauThuBongDa> arrayCauThuBongDa;
    private CauThuBongDaAdapter adapter;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3_lab3);

        AnhXa();

        adapter = new CauThuBongDaAdapter(this, R.layout.dong_cau_thu_bong_da, arrayCauThuBongDa);
        lvCauThuBongDa.setAdapter(adapter);

        // Nhấn vào item để đổ dữ liệu lên EditText
        lvCauThuBongDa.setOnItemClickListener((parent, view, position, id) -> {
            CauThuBongDa selectedItem = arrayCauThuBongDa.get(position);
            edtTen.setText(selectedItem.getTen());
            edtMota.setText(selectedItem.getMota());
            edtUrlHinh.setText(selectedItem.getHinh());
            selectedPosition = position;
        });

        // Nhấn giữ để xóa ngay lập tức
        lvCauThuBongDa.setOnItemLongClickListener((parent, view, position, id) -> {
            arrayCauThuBongDa.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        // Thêm cầu thủ bóng đá vào danh sách
        btnThem.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            String mota = edtMota.getText().toString();
            String urlHinh = edtUrlHinh.getText().toString();

            if (ten.isEmpty() || mota.isEmpty() || urlHinh.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }

            arrayCauThuBongDa.add(new CauThuBongDa(ten, mota, urlHinh));
            adapter.notifyDataSetChanged();
            edtTen.setText("");
            edtMota.setText("");
            edtUrlHinh.setText("");
        });

        // Cập nhật cầu thủ bóng đá đã chọn
        btnCapNhat.setOnClickListener(v -> {
            if (selectedPosition == -1) {
                Toast.makeText(this, "Hãy chọn một mục để cập nhật!", Toast.LENGTH_SHORT).show();
                return;
            }

            arrayCauThuBongDa.get(selectedPosition).setTen(edtTen.getText().toString());
            arrayCauThuBongDa.get(selectedPosition).setMota(edtMota.getText().toString());
            arrayCauThuBongDa.get(selectedPosition).setHinh(edtUrlHinh.getText().toString());

            adapter.notifyDataSetChanged();
            edtTen.setText("");
            edtMota.setText("");
            edtUrlHinh.setText("");
            selectedPosition = -1;
        });

        // Xử lý khi nhấn nút quay lại
        btnBack.setOnClickListener(v -> finish());

        // Xử lý nút xóa cầu thủ
        btnXoa.setOnClickListener(v -> {
            if (selectedPosition == -1) {
                Toast.makeText(this, "Hãy chọn một cầu thủ để xóa!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Remove the selected player from the list
            arrayCauThuBongDa.remove(selectedPosition);
            adapter.notifyDataSetChanged();  // Notify the adapter to update the ListView

            // Clear the EditTexts and reset selected position
            edtTen.setText("");
            edtMota.setText("");
            edtUrlHinh.setText("");
            selectedPosition = -1;
        });
    }

    private void AnhXa() {
        lvCauThuBongDa = findViewById(R.id.listviewCauThuBongDa);
        edtTen = findViewById(R.id.edtTen);
        edtMota = findViewById(R.id.edtMota);
        edtUrlHinh = findViewById(R.id.edtUrlHinh);
        btnThem = findViewById(R.id.btnThem);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        btnBack = findViewById(R.id.btnBackQuestion3Lab3);
        btnXoa = findViewById(R.id.btnXoa);  // Initialize Delete Button
        arrayCauThuBongDa = new ArrayList<>();

        arrayCauThuBongDa.add(new CauThuBongDa("Cristiano Ronaldo", "Cầu thủ người Bồ Đào Nha", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Cristiano_Ronaldo_2018.jpg/440px-Cristiano_Ronaldo_2018.jpg"));
        arrayCauThuBongDa.add(new CauThuBongDa("Lionel Messi", "Cầu thủ người Argentina", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Messi_2021.jpg/440px-Messi_2021.jpg"));
    }
}
