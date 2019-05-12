package com.diamong.a014study_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.diamong.a014study_recyclerview.model.PostItem;
import com.diamong.a014study_recyclerview.recyclerview.PostViewHolder;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<PostViewHolder> {

    public Context mContext;

    private ArrayList<PostItem> postItems;

    public MyAdapter(Context context, ArrayList<PostItem> listItem) {
        mContext = context;
        postItems = listItem;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.post_item, null);
        PostViewHolder postViewHolder = new PostViewHolder(view, this);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        PostItem item = postItems.get(i);
        //postViewHolder.imgContent
        postViewHolder.tvUserId.setText(item.getUserName());
        postViewHolder.tvContent.setText(item.getPostText());
        postViewHolder.tvLikeCount.setText(String.valueOf(item.getPostLikeCount()));

    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    public void onLikeClicked(int position) {
        PostItem item = postItems.get(position);
        Toast.makeText(mContext, position + "       :" + item.getUserName(), Toast.LENGTH_SHORT).show();
    }
}
