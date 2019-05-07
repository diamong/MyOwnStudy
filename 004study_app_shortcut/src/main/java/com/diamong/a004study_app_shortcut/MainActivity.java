package com.diamong.a004study_app_shortcut;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ListActivity implements View.OnClickListener {
    static final String TAG = "ShortcutSample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

    }
}
