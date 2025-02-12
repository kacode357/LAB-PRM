package com.example.minigame2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KetQuaActivity extends AppCompatActivity {

    String winner;
    String yourChoice1;
    String yourChoice2;
    Integer currentBet;
    Integer updatedMoney;
    Button btnBackToBet;
    private List<Player> allPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ket_qua);

        btnBackToBet = findViewById(R.id.btnBackToBet);
        Intent intent = getIntent();
        winner = intent.getStringExtra("winner");
        yourChoice1 = intent.getStringExtra("yourChoice1");
        yourChoice2 = intent.getStringExtra("yourChoice2");
        currentBet = intent.getIntExtra("currentBet", 0);
        updatedMoney = intent.getIntExtra("updatedMoney", 0);
        allPlayers = (List<Player>) getIntent().getSerializableExtra("allPlayers");
        btnBackToBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KetQuaActivity.this, CuocActivity.class);
                intent.putExtra("currentMoney", updatedMoney);
                startActivity(intent);
            }
        });

        setDogItem();
        setBetInfo();
    }

    private void setDogItem() {
        LottieAnimationView you1_player_image = findViewById(R.id.you1_player_image);
        TextView you1_player_id = findViewById(R.id.you1_player_id);
        TextView you1_player_name = findViewById(R.id.you1_player_name);
        TextView you1_player_dog = findViewById(R.id.you1_player_dog);
        TextView you1_player_win = findViewById(R.id.you1_player_win);

        LottieAnimationView you2_player_image = findViewById(R.id.you2_player_image);
        TextView you2_player_id = findViewById(R.id.you2_player_id);
        TextView you2_player_name = findViewById(R.id.you2_player_name);
        TextView you2_player_dog = findViewById(R.id.you2_player_dog);
        TextView you2_player_win = findViewById(R.id.you2_player_win);

        LottieAnimationView win_player_image = findViewById(R.id.win_player_image);
        TextView win_player_id = findViewById(R.id.win_player_id);
        TextView win_player_name = findViewById(R.id.win_player_name);
        TextView win_player_dog = findViewById(R.id.win_player_dog);
        TextView win_player_win = findViewById(R.id.win_player_win);

        Player chosenDog1 = allPlayers.stream()
                .filter(item -> item.getName().equals(yourChoice1))
                .findFirst().get();
        you1_player_image.setAnimation(chosenDog1.getLottieResourceId());
        you1_player_id.setText(chosenDog1.getId());
        you1_player_name.setText(chosenDog1.getName());
        you1_player_dog.setText(chosenDog1.getDogBreed());
        you1_player_win.setText(chosenDog1.getWin());

        Player chosenDog2 = allPlayers.stream()
                .filter(item -> item.getName().equals(yourChoice2))
                .findFirst().get();
        you2_player_image.setAnimation(chosenDog2.getLottieResourceId());
        you2_player_id.setText(chosenDog2.getId());
        you2_player_name.setText(chosenDog2.getName());
        you2_player_dog.setText(chosenDog2.getDogBreed());
        you2_player_win.setText(chosenDog2.getWin());

        Player winDog = allPlayers.stream()
                .filter(item -> item.getName().equals(winner))
                .findFirst().get();

        win_player_image.setAnimation(winDog.getLottieResourceId());
        win_player_id.setText(winDog.getId());
        win_player_name.setText(winDog.getName());
        win_player_dog.setText(winDog.getDogBreed());
        win_player_win.setText(winDog.getWin());
    }

    private void setBetInfo() {
        TextView txtBet = findViewById(R.id.txtBet);
        TextView txtWin = findViewById(R.id.txtWin);
        TextView txtMoney = findViewById(R.id.txtMoney);

        txtBet.setText("BET:    " + currentBet + "$");
        if (yourChoice1.equals(winner) || yourChoice2.equals(winner)) {
            txtWin.setText("WIN:    " + currentBet * 2 + "$");
        } else {
            txtWin.setText("WIN:    " + 0 + "$");
        }
        txtMoney.setText("MONEY:    " + updatedMoney + "$");
    }
}