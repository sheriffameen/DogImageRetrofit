package com.example.dogimages;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DogImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;


    public DogImageViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.dogImageView);
    }

    public void onBind(String dogImage){

        Picasso.get().load(dogImage).into(imageView);

    }
}
