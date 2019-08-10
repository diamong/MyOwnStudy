package com.diamong.a028study_alarmmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlarm(View view) {
        TimePIckerFragment timePIckerFragment = new TimePIckerFragment();
        timePIckerFragment.show(getSupportFragmentManager(),"timepicker");
    }
}
