package com.markedstudios.imagetable.controller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.markedstudios.imagetable.R;
import com.markedstudios.imagetable.model.HeroModel;
import com.markedstudios.imagetable.view.HeroImageActivity;

import java.util.ArrayList;

public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.HeroHolder> {
    private ArrayList<HeroModel> recyclerHerosList;

    public HerosAdapter(ArrayList<HeroModel> recyclerHerosList){
        this.recyclerHerosList = recyclerHerosList;
    }

    @NonNull
    @Override
    public HeroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeroHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroHolder holder, int position) {
        holder.bind(recyclerHerosList.get(position));
    }

    @Override
    public int getItemCount() {
        return recyclerHerosList.size();
    }



    protected class HeroHolder extends RecyclerView.ViewHolder{
        ImageView heroImage;
        TextView heroText;
        Button heroButton;

        public HeroHolder(@NonNull View itemView) {
            super(itemView);



            heroImage = itemView.findViewById(R.id.heros_image);
            heroText = itemView.findViewById(R.id.heros_name);
            heroButton = itemView.findViewById(R.id.heros_button);
            heroButton.setOnClickListener(new HerosClickListener());
        }

        public void bind(final HeroModel heroModel){

            Glide.with(itemView.getContext()).load(heroModel.getImageurlUrl()).into(heroImage);
            heroText.setText(heroModel.getName());

            heroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {

                    Intent herosIntent = new Intent(view.getContext(), HeroImageActivity.class);
                    herosIntent.putExtra("url", heroModel.getImageurlUrl());
                }
            });
        }

    }


}
