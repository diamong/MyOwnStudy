package com.diamong.a012study_sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //default = -1 ===>first user
    //user ==1
    public static final String SPREF_FIRST_USER = "1000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        TextView textView = findViewById(R.id.txt_hello);
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        int firstuser = sharedPreferences.getInt(SPREF_FIRST_USER, 0);

        if (firstuser >= 1) {
            textView.setText("또 왔구나, 호갱아:   " + firstuser);
            saveUserIsNotFirst(firstuser);
        } else if (firstuser == 0) {
            textView.setText("처음오셨구나..");
            saveUserIsNotFirst(firstuser);
        }
    }

    private void saveUserIsNotFirst(int firstuser) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(SPREF_FIRST_USER, firstuser + 1);
        editor.commit();
    }

    public void OnClicked(View view) {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
}
