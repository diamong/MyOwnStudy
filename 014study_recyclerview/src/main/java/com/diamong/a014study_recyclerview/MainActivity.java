package com.diamong.a014study_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diamong.a014study_recyclerview.model.PostItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<PostItem> listItem = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            PostItem item = new PostItem(true, i, "My Name", "http://image.kmib.co.kr/online_image/2018/0219/611811110012140814_1.jpg", "멋쟁이");
            listItem.add(i, item);
        }

        MyAdapter adapter =new MyAdapter(this,listItem);
        recyclerView.setAdapter(adapter);


    }
}
