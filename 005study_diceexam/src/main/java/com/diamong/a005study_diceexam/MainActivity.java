package com.diamong.a005study_diceexam;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewLeft, imageViewRight, imageViewResult;
    private Random random;
    private int soundLoad;
    private TextView textViewLeftCount, textViewRightCount, textViewResult;
    private LeftPlayer leftPlayer;
    private RightPlayer rightPlayer;
    private Button buttonLeftPlayer, buttonRightPlayer, buttonInit;
    private SoundPool soundPool;
    private MediaPlayer mediaPlayer;
    private boolean diceLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        textViewLeftCount = findViewById(R.id.text_left_count);
        textViewRightCount = findViewById(R.id.text_right_count);
        leftPlayer = new LeftPlayer("김예빈", 0);
        rightPlayer = new RightPlayer("김태현", 0);
        buttonLeftPlayer = findViewById(R.id.button_player_left);
        buttonRightPlayer = findViewById(R.id.button_player_right);
        buttonInit = findViewById(R.id.button_init);
        textViewResult = findViewById(R.id.text_result);
        soundPool = new SoundPool(8, AudioManager.STREAM_NOTIFICATION, 0);
        soundLoad = soundPool.load(this, R.raw.clicking, 1);
        mediaPlayer = MediaPlayer.create(this, R.raw.shuffle);

        imageViewLeft = findViewById(R.id.imageview_dice_left);
        imageViewRight = findViewById(R.id.imageview_dice_right);
        imageViewResult = findViewById(R.id.image_result);
    }

    public void shakeDice(View view) {
        switch (view.getId()) {
            case R.id.button_player_left:

                diceLeft = true;
                soundPool.play(soundLoad, 1, 0, 1, 0, 3);
                int lNumber = random.nextInt(6);
                PullDice(lNumber, diceLeft);
                leftPlayer.count += (lNumber + 1);
                textViewLeftCount.setText(String.valueOf(leftPlayer.count));
                if (leftPlayer.isWin()) {

                    CallResult(leftPlayer.name);
                    imageViewResult.setImageResource(R.drawable.image_yebin);
                    imageViewResult.setVisibility(View.VISIBLE);

                }
                break;

            case R.id.button_player_right:
                soundPool.play(soundLoad, 0, 1, 1, 0, 3);

                diceLeft = false;
                int rNumber = random.nextInt(6);
                PullDice(rNumber, diceLeft);
                rightPlayer.count += (rNumber + 1);
                textViewRightCount.setText(String.valueOf(rightPlayer.count));

                if (rightPlayer.isWin()) {

                    imageViewResult.setImageResource(R.drawable.fafa);
                    CallResult(rightPlayer.name);
                    imageViewResult.setVisibility(View.VISIBLE);


                }
                break;
            case R.id.button_init:
                buttonLeftPlayer.setVisibility(View.VISIBLE);
                buttonRightPlayer.setVisibility(View.VISIBLE);
                buttonInit.setVisibility(View.INVISIBLE);
                leftPlayer.count = 0;
                rightPlayer.count = 0;
                textViewRightCount.setText("0");
                textViewLeftCount.setText("0");
                textViewResult.setText("");
                mediaPlayer.pause();
                imageViewResult.setVisibility(View.INVISIBLE);
                imageViewLeft.setImageResource(R.drawable.dice);
                imageViewRight.setImageResource(R.drawable.dice);
                break;

        }

    }

    private void CallResult(String name) {
        buttonRightPlayer.setVisibility(View.INVISIBLE);
        buttonLeftPlayer.setVisibility(View.INVISIBLE);
        textViewResult.setText(name + "   이겼어요");
        buttonInit.setVisibility(View.VISIBLE);
        mediaPlayer.start();
    }

    private void PullDice(int count, boolean Left) {
        if (Left) {
            if (count == 0) {
                imageViewLeft.setImageResource(R.drawable.dice1);

            } else if (count == 1) {
                imageViewLeft.setImageResource(R.drawable.dice2);
            } else if (count == 2) {
                imageViewLeft.setImageResource(R.drawable.dice3);
            } else if (count == 3) {
                imageViewLeft.setImageResource(R.drawable.dice4);
            } else if (count == 4) {
                imageViewLeft.setImageResource(R.drawable.dice5);
            } else {
                imageViewLeft.setImageResource(R.drawable.dice6);
            }

        } else {
            if (count == 0) {
                imageViewRight.setImageResource(R.drawable.dice1);

            } else if (count == 1) {
                imageViewRight.setImageResource(R.drawable.dice2);
            } else if (count == 2) {
                imageViewRight.setImageResource(R.drawable.dice3);
            } else if (count == 3) {
                imageViewRight.setImageResource(R.drawable.dice4);
            } else if (count == 4) {
                imageViewRight.setImageResource(R.drawable.dice5);
            } else {
                imageViewRight.setImageResource(R.drawable.dice6);
            }
        }


    }

    static class LeftPlayer {
        String name;
        int count;

        public LeftPlayer(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public boolean isWin() {
            if (count >= 100) {
                return true;
            } else {
                return false;
            }
        }
    }

    static class RightPlayer {
        String name;
        int count;

        public RightPlayer(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public boolean isWin() {
            if (count >= 100) {
                return true;
            } else {
                return false;
            }
        }
    }
}
