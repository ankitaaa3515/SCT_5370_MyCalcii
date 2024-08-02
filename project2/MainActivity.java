package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;
    private Button btnStart, btnPause, btnReset;

    private Handler handler = new Handler();
    private long startTime, timeInMillis;
    private boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = System.currentTimeMillis();
                handler.postDelayed(updateTimerRunnable, 0);
                isRunning = true;
                btnStart.setEnabled(false);
                btnPause.setEnabled(true);
                btnReset.setEnabled(false);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeInMillis += System.currentTimeMillis() - startTime;
                handler.removeCallbacks(updateTimerRunnable);
                isRunning = false;
                btnStart.setEnabled(true);
                btnPause.setEnabled(false);
                btnReset.setEnabled(true);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeInMillis = 0;
                updateTimerText(0);
                btnReset.setEnabled(false);
            }
        });
    }

    private Runnable updateTimerRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                long elapsedMillis = System.currentTimeMillis() - startTime + timeInMillis;
                updateTimerText(elapsedMillis);
                handler.postDelayed(this, 10);
            }
        }
    };

    private void updateTimerText(long elapsedMillis) {
        int minutes = (int) (elapsedMillis / 60000);
        int seconds = (int) (elapsedMillis / 1000) % 60;
        int millis = (int) (elapsedMillis % 1000);

        String time = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        tvTime.setText(time);
    }
}
