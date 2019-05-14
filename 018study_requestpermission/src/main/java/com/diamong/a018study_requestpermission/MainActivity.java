package com.diamong.a018study_requestpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //camera 2 참조
        CheckPermission();
    }

    private void CheckPermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ArrayList<String> listPermissionNeeded = new ArrayList<>();

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                listPermissionNeeded.add(permission);
            }
        }

        if (!listPermissionNeeded.isEmpty()){
            ActivityCompat.requestPermissions
                    (this,listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case 1000:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                }else{
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "READ_CONTACTS 가 거부되었습니다.", Toast.LENGTH_SHORT).show();
                }
                return;
            case 1001:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                }else{
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "CAMERA가 거부되었습니다.", Toast.LENGTH_SHORT).show();
                }
                return;

        }
    }
}
