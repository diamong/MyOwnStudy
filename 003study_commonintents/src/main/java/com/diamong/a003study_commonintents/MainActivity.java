package com.diamong.a003study_commonintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button buttonSetAlarm, buttonSetTimer, buttonMinus, buttonPlus, button_capture_photo,button_Intent;
    private TimePicker mTimePicker;
    private Calendar mCalender;
    private int mHour, mMinute, mSetTime;
    private TextView textViewTime, textViewRemainTime;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri photoUri, albumUri = null;


    private void init() {
        mTimePicker = findViewById(R.id.time_picker);
        buttonSetAlarm = findViewById(R.id.button_set_alarm);
        buttonSetTimer = findViewById(R.id.button_set_timer);
        textViewTime = findViewById(R.id.text_time);

        buttonMinus = findViewById(R.id.button_minus);
        buttonPlus = findViewById(R.id.button_plus);
        button_capture_photo = findViewById(R.id.button_capture_photo);
        button_Intent=findViewById(R.id.button_common_intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mCalender=Calendar.getInstance();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mHour = mTimePicker.getHour();
                    mMinute = mTimePicker.getMinute();
                } else {
                    mHour = mTimePicker.getCurrentHour();
                    mMinute = mTimePicker.getCurrentMinute();
                }
                createAlarm("Message", mHour, mMinute);
            }
        });


        buttonSetTimer.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                int setTime = (Integer.parseInt(textViewTime.getText().toString())) * 60;
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                        .putExtra(AlarmClock.EXTRA_LENGTH, setTime)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(textViewTime.getText().toString());
                time = time - 1;
                textViewTime.setText(String.valueOf(time));
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(textViewTime.getText().toString());
                time++;
                textViewTime.setText(String.valueOf(time));
            }
        });

        /*button_capture_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                photoUri=


                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.withAppendedPath();
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });*/

        button_Intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                startActivity(intent);
            }
        });
    }




    public void createAlarm(String message, int hour, int minutes) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
