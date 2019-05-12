package com.diamong.a014study_recyclerview.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.diamong.a014study_recyclerview.MyAdapter;
import com.diamong.a014study_recyclerview.R;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public CheckBox cbLike;
    public ImageView imgContent,  imgRight;
    public TextView tvLikeCount, tvUserId, tvContent;
    public MyAdapter mAdapter;

    public PostViewHolder(@NonNull View itemView, MyAdapter myAdapter) {
        super(itemView);
        mAdapter = myAdapter;
        imgContent = itemView.findViewById(R.id.img_content);
        cbLike = itemView.findViewById(R.id.cb_like);
        imgRight = itemView.findViewById(R.id.img_right);
        tvLikeCount = itemView.findViewById(R.id.tv_like_count);
        tvUserId = itemView.findViewById(R.id.tv_user_id);
        tvContent = itemView.findViewById(R.id.tv_content);

        cbLike.setOnClickListener(this);
        imgRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        switch (v.getId()) {
            case R.id.cb_like:
                mAdapter.onLikeClicked(position);
                break;
            case R.id.img_right:
                break;
        }

    }
}
