package com.example.minigame2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CuocActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPlayers;
    private PlayerAdapter playerAdapter;
    private TextView betTextView, moneyTextView;
    private Button buttonClearBet, buttonStartRace;
    private int currentBet = 0;
    private int currentMoney = 1000; // Tổng số tiền người chơi có
    private final int MAX_BET = 100; // Giới hạn tối đa 100 xu
    private List<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuoc);

        currentMoney = getIntent().getIntExtra("currentMoney",1000);


        // Khởi tạo UI
        initViews();
        setupRecyclerView();
        setupButtons();
        setupCoinClickListeners();
        MediaPlayer sound = MediaPlayer.create(this, R.raw.casino_sound);
        sound.start();
        sound.setLooping(true);
    }

    /**
     * Khởi tạo các thành phần giao diện
     */
    private void initViews() {
        recyclerViewPlayers = findViewById(R.id.recyclerViewPlayers);
        betTextView = findViewById(R.id.textViewBetAmount);
        moneyTextView = findViewById(R.id.textViewMoney);
        buttonClearBet = findViewById(R.id.buttonClearBet);
        buttonStartRace = findViewById(R.id.buttonStartRace);

        // Cập nhật giao diện tiền cược
        updateBetDisplay();
        updateMoneyDisplay();
    }

    /**
     * Thiết lập RecyclerView
     */
    private void setupRecyclerView() {
        recyclerViewPlayers.setLayoutManager(new GridLayoutManager(this, 3));

        // Khởi tạo danh sách người chơi
        players = new ArrayList<>();
        players.add(new Player("1", "Chó 1", "Chó Phú Quốc", "8.2", R.raw.conchoso1));
        players.add(new Player("2", "Chó 2", "Chó Becgie", "5.1", R.raw.conchoso2));
        players.add(new Player("3", "Chó 3", "Chó Cocker", "10.0", R.raw.conchoso3));
        players.add(new Player("4", "Chó 4", "Chó Poodle", "7.5", R.raw.conchoso4));
        players.add(new Player("5", "Chó 5", "Chó Rottweiler", "6.8", R.raw.conchoso5));
        players.add(new Player("6", "Chó 6", "Chó Pitbull", "9.2", R.raw.conchoso6));

        // Cấu hình adapter
        playerAdapter = new PlayerAdapter(this, players);
        recyclerViewPlayers.setAdapter(playerAdapter);
    }

    /**
     * Thiết lập các button và sự kiện
     */
    private void setupButtons() {
        buttonClearBet.setOnClickListener(v -> clearBet());

        buttonStartRace.setOnClickListener(v -> {
            List<Integer> selectedPlayers = playerAdapter.getSelectedPositions();
            if (currentBet < 1) {

                Intent intent = new Intent(CuocActivity.this, DialogActivity.class);
                startActivity(intent);
                return;
            }
            if (selectedPlayers.size() < 2) {
                Toast.makeText(CuocActivity.this, "Vui lòng chọn 2 con chó!", Toast.LENGTH_SHORT).show();
            } else {
                if (currentBet > currentMoney) {
                    Toast.makeText(CuocActivity.this, "Không đủ tiền cược!", Toast.LENGTH_SHORT).show();
                } else {
                    currentMoney -= currentBet; // Trừ tiền khi đặt cược
                    updateMoneyDisplay();

                    // Chuyển dữ liệu sang màn hình RaceActivity
                    Intent intent = new Intent(CuocActivity.this, RaceActivity.class);
                    List<Player> selectedPlayersList = new ArrayList<>();
                    List<Integer> lottieResourceIds = new ArrayList<>(); // Lưu trữ tài nguyên Lottie

                    for (int pos : selectedPlayers) {
                        Player player = players.get(pos);
                        selectedPlayersList.add(player);
                        lottieResourceIds.add(player.getLottieResourceId()); // Thêm tài nguyên Lottie vào danh sách
                    }

                    // Truyền các thông tin cần thiết vào intent, bao gồm currentMoney
                    intent.putExtra("allPlayers", (java.io.Serializable) players);
                    intent.putExtra("selectedPlayers", (java.io.Serializable) selectedPlayersList);
                    intent.putExtra("currentBet", currentBet);
                    intent.putExtra("lottieResourceIds", (java.io.Serializable) lottieResourceIds); // Truyền tài nguyên Lottie
                    intent.putExtra("currentMoney", currentMoney); // Truyền currentMoney sang RaceActivity

                    // Gọi RaceActivity và nhận kết quả
                    startActivityForResult(intent, 1); // 1 là mã yêu cầu (requestCode)
                }
            }
        });

    }


    /**
     * Thiết lập sự kiện click cho các đồng xu
     */
    private void setupCoinClickListeners() {
        findViewById(R.id.coin_1).setOnClickListener(v -> addBet(1));
        findViewById(R.id.coin_5).setOnClickListener(v -> addBet(5));
        findViewById(R.id.coin_10).setOnClickListener(v -> addBet(10));
        findViewById(R.id.coin_25).setOnClickListener(v -> addBet(25));
        findViewById(R.id.coin_50).setOnClickListener(v -> addBet(50));
        findViewById(R.id.coin_100).setOnClickListener(v -> addBet(100));
    }

    /**
     * Thêm tiền cược
     */
    private void addBet(int amount) {
        if (currentBet + amount <= MAX_BET) {
            if (currentBet + amount > currentMoney) {
                Toast.makeText(this, "Không đủ tiền để cược!", Toast.LENGTH_SHORT).show();
            } else {
                currentBet += amount;
                updateBetDisplay();
            }
        } else {
            Toast.makeText(this, "Không thể đặt hơn " + MAX_BET + " xu!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Xóa tiền cược và cập nhật giao diện
     */
    private void clearBet() {
        currentBet = 0;
        updateBetDisplay();
    }

    /**
     * Cập nhật hiển thị số tiền cược
     */
    private void updateBetDisplay() {
        betTextView.setText("BET: " + currentBet + "$");
    }

    /**
     * Cập nhật hiển thị số tiền hiện có
     */
    private void updateMoneyDisplay() {
        moneyTextView.setText("MONEY: " + currentMoney + "$");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            // Nhận số tiền đã được cập nhật từ RaceActivity
            int updatedMoney = data.getIntExtra("updatedMoney", currentMoney);  // Default value if not found
            currentMoney = updatedMoney;  // Cập nhật lại số tiền trong CuocActivity
            updateMoneyDisplay();  // Cập nhật giao diện hiển thị số tiền
        }
    }

}
