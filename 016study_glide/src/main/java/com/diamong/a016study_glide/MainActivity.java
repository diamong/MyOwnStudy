package com.diamong.a016study_glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.img);
    }

    public void OnClicked(View view) {
        startLoadingImage();
    }

    private void startLoadingImage() {
        String url="https://firebasestorage.googleapis.com/v0/b/finalchat-3fdca.appspot.com/o/image_yebin.jpg?alt=media&token=c9d7155c-14ad-4abe-abab-38737de78bb8";
        Glide.with(this).load(url).centerCrop().into(imageView);

    }
}
