package com.example.dogimages;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DogImageAdapter extends RecyclerView.Adapter<DogImageViewHolder> {
    private List<String> dogImageList;

    public DogImageAdapter(List<String> dogImageList) {
        this.dogImageList = dogImageList;
    }

    @NonNull
    @Override
    public DogImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dogimage_itemview,viewGroup,false);
        return new DogImageViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull DogImageViewHolder dogImageViewHolder, int i) {
        dogImageViewHolder.onBind(dogImageList.get(i));
    }

    @Override
    public int getItemCount() {
        return dogImageList.size();
    }
}
