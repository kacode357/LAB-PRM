package com.example.lab32;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;
    EditText edtTen, edtMota, edtUrlHinh;
    Button btnThem, btnCapNhat;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);

        // Nhấn vào item để đổ dữ liệu lên EditText
        lvTraiCay.setOnItemClickListener((parent, view, position, id) -> {
            TraiCay selectedItem = arrayTraiCay.get(position);
            edtTen.setText(selectedItem.getTen());
            edtMota.setText(selectedItem.getMota());
            edtUrlHinh.setText(selectedItem.getHinh());
            selectedPosition = position;
        });

        // Nhấn giữ để xóa ngay lập tức
        lvTraiCay.setOnItemLongClickListener((parent, view, position, id) -> {
            arrayTraiCay.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        // Thêm trái cây vào danh sách
        btnThem.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            String mota = edtMota.getText().toString();
            String urlHinh = edtUrlHinh.getText().toString();

            if (ten.isEmpty() || mota.isEmpty() || urlHinh.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }

            arrayTraiCay.add(new TraiCay(ten, mota, urlHinh));
            adapter.notifyDataSetChanged();
            edtTen.setText("");
            edtMota.setText("");
            edtUrlHinh.setText("");
        });

        // Cập nhật trái cây đã chọn
        btnCapNhat.setOnClickListener(v -> {
            if (selectedPosition == -1) {
                Toast.makeText(MainActivity.this, "Hãy chọn một mục để cập nhật!", Toast.LENGTH_SHORT).show();
                return;
            }

            arrayTraiCay.get(selectedPosition).setTen(edtTen.getText().toString());
            arrayTraiCay.get(selectedPosition).setMota(edtMota.getText().toString());
            arrayTraiCay.get(selectedPosition).setHinh(edtUrlHinh.getText().toString());

            adapter.notifyDataSetChanged();
            edtTen.setText("");
            edtMota.setText("");
            edtUrlHinh.setText("");
            selectedPosition = -1;
        });
    }

    private void AnhXa() {
        lvTraiCay = findViewById(R.id.listviewTraiCay);
        edtTen = findViewById(R.id.edtTen);
        edtMota = findViewById(R.id.edtMota);
        edtUrlHinh = findViewById(R.id.edtUrlHinh);
        btnThem = findViewById(R.id.btnThem);
        btnCapNhat = findViewById(R.id.btnCapNhat);

        arrayTraiCay = new ArrayList<>();
        arrayTraiCay.add(new TraiCay("Chuối tiêu", "Chuối tiêu Long An", "https://upload.wikimedia.org/wikipedia/commons/9/9b/Cavendish_Banana_DS.jpg"));
        arrayTraiCay.add(new TraiCay("Thanh long", "Thanh long ruột đỏ", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Hylocereus_polyrhizus.jpg/440px-Hylocereus_polyrhizus.jpg"));
        arrayTraiCay.add(new TraiCay("Dâu tây", "Dâu tây Đà Lạt", "https://blog.onelife.vn/wp-content/uploads/2024/01/bc3a163d-dau-tay-da-lat-1024x576.png"));
        arrayTraiCay.add(new TraiCay("Dưa hấu", "Dưa hấu Tiền Giang", "https://dyh48pub5c8mm.cloudfront.net/home/store/goods/936/20230919/alioss_936_2023091909235844782.jpg?x-oss-process=image/resize,m_pad,w_240,h_240"));
        arrayTraiCay.add(new TraiCay("Cam vàng", "Cam vàng nhập khẩu", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Ambersweet_oranges.jpg/440px-Ambersweet_oranges.jpg"));
    }
}
