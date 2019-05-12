package com.diamong.a013study_dto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diamong.a013study_dto.model.PostItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout =findViewById(R.id.ll_scroll);

        ArrayList<PostItem> listItem = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            PostItem item = new PostItem(true, i, "My Name", "http://image.kmib.co.kr/online_image/2018/0219/611811110012140814_1.jpg", "멋쟁이");
            listItem.add(i, item);
        }

        for (PostItem item : listItem) {
            View v = View.inflate(this, R.layout.post_item, null);
            TextView tvUserId = v.findViewById(R.id.tv_user_id);
            TextView tvContent=v.findViewById(R.id.tv_content);
            TextView tvLikeCount = v.findViewById(R.id.tv_like_count);

            tvUserId.setText(item.getUserName());
            tvContent.setText(item.getPostText());
            tvLikeCount.setText(String.valueOf(item.getPostLikeCount()));

            linearLayout.addView(v);

        }

    }
}
