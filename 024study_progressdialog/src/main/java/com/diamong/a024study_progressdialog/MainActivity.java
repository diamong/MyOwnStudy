package com.diamong.a024study_progressdialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);

        dialog.setTitle("Progress Dialog");
        dialog.setMessage("Uploading");
        //dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.show();
    }
}
