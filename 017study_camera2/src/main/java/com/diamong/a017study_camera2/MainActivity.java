package com.diamong.a017study_camera2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckPermission();
    }

    private void CheckPermission() {
        //필요한 권한 모집
        String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ArrayList<String> listPermissionNeeded = new ArrayList<>();

        //권한 체크 부분
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                listPermissionNeeded.add(permission);
            }
        }

        //권한 요청
        if (!listPermissionNeeded.isEmpty()){
            ActivityCompat.requestPermissions
                    (this,listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),1);
        }
    }


    public void CameraCapture(View view) {
        boolean camera = ContextCompat.checkSelfPermission
                (this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        boolean write = ContextCompat.checkSelfPermission
                (this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED;

        if (camera && write){
            //사진찍는 인텐트 추가
             Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(intent,0);

        }else {
            Toast.makeText(this, "사진찍고 저장하는 권한이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
