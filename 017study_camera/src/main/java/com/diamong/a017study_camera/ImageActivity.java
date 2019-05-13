package com.diamong.a017study_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.img_received);

        Intent intent = getIntent();
        Bitmap mBitmap=intent.getParcelableExtra("image");
        imageView.setImageBitmap(mBitmap);
    }


}
