package com.example.restapiretrofit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView userName, userProfession;

    public RecyclerViewHolder(@NonNull  View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.userImage);
        userName = itemView.findViewById(R.id.userName);
        userProfession = itemView.findViewById(R.id.userProfession);
    }
}
