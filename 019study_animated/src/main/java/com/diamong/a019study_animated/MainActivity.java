package com.diamong.a019study_animated;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    AnimationDrawable animationDrawable;
    boolean isToggle;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.ll_mylayout);
        button=findViewById(R.id.btn_toggle);

        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
        isToggle=true;
    }

    public void StopAnimation(View view) {
        if (isToggle){

        animationDrawable.stop();
        isToggle=false;
        button.setText("Start animation");
        } else {
            animationDrawable.start();
            isToggle=true;
            button.setText("Stop animation");
        }
    }
}
