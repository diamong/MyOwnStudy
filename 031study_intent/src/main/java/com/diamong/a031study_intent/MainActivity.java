package com.diamong.a031study_intent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText message, hour, minute,second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message_edit);
        hour = findViewById(R.id.hour_edit);
        minute = findViewById(R.id.minute_edit);
        second=findViewById(R.id.second_edit);
    }

    public void createAlarm(View view) {
        String title = message.getText().toString();
        int mHour = Integer.parseInt(hour.getText().toString());
        int mMinute = Integer.parseInt(minute.getText().toString());
        makeAlarm(title, mHour, mMinute);
    }

    private void makeAlarm(String title, int mHour, int mMinute) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, title)
                .putExtra(AlarmClock.EXTRA_HOUR, mHour)
                .putExtra(AlarmClock.EXTRA_MINUTES, mMinute);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void setAlarm(View view) {
        String title = message.getText().toString();
        int seconds = Integer.parseInt(second.getText().toString());
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, title)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
