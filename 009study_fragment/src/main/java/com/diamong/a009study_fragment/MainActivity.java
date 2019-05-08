package com.diamong.a009study_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnColorButtonListener {

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        RedFragment redFragment = new RedFragment();
        fragmentTransaction.add(R.id.container, redFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onColorClick(int color) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment;
        switch (color) {
            case 0:
                fragment = new RedFragment();
                fragmentTransaction.replace(R.id.container, fragment);

                Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();


                break;
            case 1:
                fragment = new GreenFragment();
                fragmentTransaction.replace(R.id.container, fragment);

                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                fragment = new BlueFragment();
                fragmentTransaction.replace(R.id.container, fragment);

                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();


    }
}
