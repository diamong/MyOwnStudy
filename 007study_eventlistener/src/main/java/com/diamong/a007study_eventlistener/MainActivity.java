package com.diamong.a007study_eventlistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.img_left).setOnClickListener(this);
        findViewById(R.id.img_right).setOnClickListener(this);
        findViewById(R.id.img_center).setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
                Toast.makeText(this, "I Love you", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_right:
                Toast.makeText(this, "I Hate you", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.img_center:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(this, "I Love you..................", Toast.LENGTH_SHORT).show();
                        break;
                    /*case MotionEvent.ACTION_MOVE:
                        Toast.makeText(this, "MOve.....", Toast.LENGTH_SHORT).show();
                        break;*/
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(this, "Up...", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }

        return true;
    }
}
