package com.example.restapiretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<ModelDataFetch> fetchData;

    public MyAdapter(List<ModelDataFetch> fetchData) {
        this.fetchData = fetchData;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.userName.setText(fetchData.get(position).getName());
        holder.userProfession.setText(fetchData.get(position).getProfession());
        Glide.with(holder.userProfession.getContext())
                .load("http://192.168.93.146/api/images/"+fetchData.get(position).getImage())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return fetchData.size();
    }
}
