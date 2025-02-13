package com.example.minigame2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RaceActivity extends AppCompatActivity {

    private TextView textViewRaceInfo, textViewBetInfo;
    private Button btnViewKetQua;
    private LottieAnimationView lottieAnimationView1, lottieAnimationView2, lottieAnimationView3, lottieAnimationView4, lottieAnimationView5, lottieAnimationView6;
    private Handler handler = new Handler();
    private double progress1 = 0, progress2 = 0, progress3 = 0, progress4 = 0, progress5 = 0, progress6 = 0;
    private double speed1, speed2, speed3, speed4, speed5, speed6;
    private boolean raceFinished = false;  // Biến kiểm tra đã kết thúc cuộc đua
    private int currentMoney;
    private List<Player> allPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        EdgeToEdge.enable(this);
        ImageView imageViewRaceBg = findViewById(R.id.imageViewRaceBg);
        Glide.with(this)
                .asGif()
                .load(R.drawable.looprace)
                .into(imageViewRaceBg);
        MediaPlayer sound = MediaPlayer.create(this, R.raw.race_sound);
        sound.start();

        textViewRaceInfo = findViewById(R.id.textViewRaceInfo);
        textViewBetInfo = findViewById(R.id.textViewBetInfo);
        btnViewKetQua = findViewById(R.id.btnViewKetQua);

        // LottieAnimationViews cho các con chó
        lottieAnimationView1 = findViewById(R.id.lottieAnimationView1);
        lottieAnimationView2 = findViewById(R.id.lottieAnimationView2);
        lottieAnimationView3 = findViewById(R.id.lottieAnimationView3);
        lottieAnimationView4 = findViewById(R.id.lottieAnimationView4);
        lottieAnimationView5 = findViewById(R.id.lottieAnimationView5);
        lottieAnimationView6 = findViewById(R.id.lottieAnimationView6);

        // Nhận danh sách các con chó đã chọn và tiền cược
        List<Player> selectedPlayers = (List<Player>) getIntent().getSerializableExtra("selectedPlayers");
        allPlayers = (List<Player>) getIntent().getSerializableExtra("allPlayers");
        int currentBet = getIntent().getIntExtra("currentBet", 0);
        currentMoney = getIntent().getIntExtra("currentMoney", 1000);

        // Hiển thị thông tin về các con chó đã chọn và tiền cược
        StringBuilder selectedPlayersText = new StringBuilder("Chó đã chọn:");
        for (Player player : selectedPlayers) {
            selectedPlayersText.append(player.getName()).append(", ");
        }

        // Cập nhật thông tin hiển thị
        textViewRaceInfo.setText(selectedPlayersText.toString());
        textViewBetInfo.setText("Số tiền cược: " + currentBet + "$");

        // Gán tốc độ cho mỗi con chó (giảm tốc độ xuống)
        double pathLength = 3;
//        speed1 = (int) (Math.random() * pathLength) + 1;
//        speed2 = (int) (Math.random() * pathLength) + 1;
//        speed3 = (int) (Math.random() * pathLength) + 1;
//        speed4 = (int) (Math.random() * pathLength) + 1;
//        speed5 = (int) (Math.random() * pathLength) + 1;
//        speed6 = (int) (Math.random() * pathLength) + 1;

        speed1 = (Math.random() * pathLength) + 1;
        speed2 = (Math.random() * pathLength) + 1;
        speed3 = (Math.random() * pathLength) + 1;
        speed4 = (Math.random() * pathLength) + 1;
        speed5 = (Math.random() * pathLength) + 1;
        speed6 = (Math.random() * pathLength) + 1;

        // Bắt đầu tự động di chuyển các con chó
        startRace(selectedPlayers, currentBet);
    }

    // Hàm để bắt đầu đua
    private void startRace(final List<Player> selectedPlayers, final int currentBet) {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (raceFinished) return;  // Nếu đã có chó về đích, không tiếp tục chạy

                // Di chuyển các con chó từ trái sang phải với tốc độ khác nhau
                moveDog(lottieAnimationView1, progress1, speed1);
                moveDog(lottieAnimationView2, progress2, speed2);
                moveDog(lottieAnimationView3, progress3, speed3);
                moveDog(lottieAnimationView4, progress4, speed4);
                moveDog(lottieAnimationView5, progress5, speed5);
                moveDog(lottieAnimationView6, progress6, speed6);

                // Cập nhật tiến trình cho các con chó
                double slow = 8;
                progress1 += speed1 / slow;
                progress2 += speed2 / slow;
                progress3 += speed3 / slow;
                progress4 += speed4 / slow;
                progress5 += speed5 / slow;
                progress6 += speed6 / slow;

                // Nếu tiến trình của bất kỳ con chó nào đạt 200, kết thúc cuộc đua
                if (progress1 >= 200 || progress2 >= 200 || progress3 >= 200 || progress4 >= 200 || progress5 >= 200 || progress6 >= 200) {
                    raceFinished = true;  // Đánh dấu cuộc đua đã kết thúc
                    announceWinner(selectedPlayers, currentBet);
                } else {
                    handler.postDelayed(this, 10);  // Tiếp tục di chuyển các con chó
                }
            }
        };

        handler.post(runnable); // Bắt đầu chạy
    }

    // Hàm thông báo con chó về đích nhất và so sánh với chó đã đặt cược
    private void announceWinner(List<Player> selectedPlayers, int currentBet) {
        String winner = "";
        if (progress1 >= 200) winner = "Chó 1";
        else if (progress2 >= 200) winner = "Chó 2";
        else if (progress3 >= 200) winner = "Chó 3";
        else if (progress4 >= 200) winner = "Chó 4";
        else if (progress5 >= 200) winner = "Chó 5";
        else if (progress6 >= 200) winner = "Chó 6";

        // Kiểm tra xem con chó chiến thắng có trong danh sách chó đã chọn đặt cược không
        boolean isWinnerSelected = false;
        for (Player player : selectedPlayers) {
            if (player.getName().equals(winner)) {
                isWinnerSelected = true;
                break;
            }
        }

        // Cập nhật số tiền
        if (isWinnerSelected) {
            Toast.makeText(RaceActivity.this, "Chúc mừng! Bạn thắng với " + winner + " và số tiền cược là " + currentBet + "$", Toast.LENGTH_SHORT).show();
            currentMoney += currentBet * 2; // Người chơi thắng, cộng tiền cược
        } else {
            Toast.makeText(RaceActivity.this, "Tiếc quá, bạn thua. " + winner + " đã về đích!", Toast.LENGTH_SHORT).show();
            // Người chơi thua, không thay đổi số tiền
        }

        // Trả lại kết quả về CuocActivity
//        Intent resultIntent = new Intent();
        Intent resultIntent = new Intent(RaceActivity.this, KetQuaActivity.class);
        resultIntent.putExtra("allPlayers", (java.io.Serializable) allPlayers);
        resultIntent.putExtra("updatedMoney", currentMoney);  // Truyền lại số tiền cập nhật
        resultIntent.putExtra("currentBet", currentBet);  // Truyền lại số tiền đã cược

// Kiểm tra số lượng con chó đã chọn
        if (selectedPlayers.size() > 0) {
            resultIntent.putExtra("yourChoice1", selectedPlayers.get(0).getName()); // Truyền con chó đầu tiên đã chọn
        }
        if (selectedPlayers.size() > 1) {
            resultIntent.putExtra("yourChoice2", selectedPlayers.get(1).getName()); // Truyền con chó thứ hai đã chọn (nếu có)
        }

        resultIntent.putExtra("winner", winner); // Truyền con chó đã win
         ImageView imageViewRaceBg = findViewById(R.id.imageViewRaceBg);
        Glide.with(this)
         .clear(imageViewRaceBg);
        btnViewKetQua.setVisibility(View.VISIBLE);

        btnViewKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(resultIntent);
            }
        });

        setResult(RESULT_OK, resultIntent);
    }

    // Hàm di chuyển chó từ trái sang phải với tốc độ
    private void moveDog(LottieAnimationView dogAnimationView, double progress, double speed) {
        if (progress <= 200) {  // Đặt mục tiêu 200 để làm đường đua ngắn hơn
            dogAnimationView.setTranslationX((float) (progress * 10.0)); // Di chuyển con chó, với giá trị * 10 để kéo dài đường đua
        }
    }
}
