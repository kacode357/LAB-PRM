package com.example.minigame2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class RaceActivity extends AppCompatActivity {

    private TextView textViewRaceInfo, textViewBetInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        textViewRaceInfo = findViewById(R.id.textViewRaceInfo);
        textViewBetInfo = findViewById(R.id.textViewBetInfo);

        // Nhận danh sách tất cả con chó và những con được chọn
        List<Player> allPlayers = (List<Player>) getIntent().getSerializableExtra("allPlayers");
        List<Player> selectedPlayers = (List<Player>) getIntent().getSerializableExtra("selectedPlayers");
        int currentBet = getIntent().getIntExtra("currentBet", 0);

        // Hiển thị danh sách chó đã chọn
        StringBuilder selectedPlayersText = new StringBuilder("Chó đã chọn:\n");
        for (Player player : selectedPlayers) {
            selectedPlayersText.append(player.getName()).append("\n");
        }

        // Hiển thị toàn bộ danh sách chó
        StringBuilder allPlayersText = new StringBuilder("Danh sách chó trong cuộc đua:\n");
        for (Player player : allPlayers) {
            allPlayersText.append(player.getName()).append("\n");
        }

        // Hiển thị số tiền cược
        String betInfo = "Số tiền cược: " + currentBet + "$";

        // Cập nhật giao diện
        textViewRaceInfo.setText(selectedPlayersText.toString() + "\n" + allPlayersText.toString());
        textViewBetInfo.setText(betInfo);
    }

}
