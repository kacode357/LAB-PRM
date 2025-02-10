package com.example.minigame;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView horse1, horse2;
    private SeekBar speedControl;
    private Button startRace;
    private Handler handler = new Handler();
    private boolean raceRunning = false;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        horse1 = findViewById(R.id.horse1);
        horse2 = findViewById(R.id.horse2);
        speedControl = findViewById(R.id.speedControl);
        startRace = findViewById(R.id.startRace);

        // Sự kiện khi nhấn nút bắt đầu đua
        startRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!raceRunning) {
                    startRace();
                }
            }
        });
    }

    private void startRace() {
        raceRunning = true;
        startRace.setEnabled(false);
        horse1.setTranslationX(0);
        horse2.setTranslationX(0);

        // Bắt đầu animation
        horse1.playAnimation();
        horse2.playAnimation();

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!raceRunning) return;

                int speedFactor1 = random.nextInt(5, 15);
                int speedFactor2 = random.nextInt(5, 15);

                horse1.setTranslationX(horse1.getTranslationX() + speedFactor1);
                horse2.setTranslationX(horse2.getTranslationX() + speedFactor2);

                float finishLineX = findViewById(R.id.finishLine).getX() - horse1.getWidth();

                // Kiểm tra nếu có ngựa nào về đích
                if (horse1.getTranslationX() >= finishLineX || horse2.getTranslationX() >= finishLineX) {
                    checkWinner();
                } else {
                    handler.postDelayed(this, 100);
                }
            }
        });
    }

    private void checkWinner() {
        raceRunning = false;
        startRace.setEnabled(true);

        // Dừng animation khi cuộc đua kết thúc
        horse1.pauseAnimation();
        horse2.pauseAnimation();

        if (horse1.getTranslationX() >= findViewById(R.id.finishLine).getX() - horse1.getWidth()) {
            startRace.setText("🏆 Ngựa 1 thắng!");
        } else if (horse2.getTranslationX() >= findViewById(R.id.finishLine).getX() - horse2.getWidth()) {
            startRace.setText("🏆 Ngựa 2 thắng!");
        }
    }
}
