package com.markedstudios.imagetable.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;

import com.markedstudios.imagetable.view.HeroImageActivity;
import com.markedstudios.imagetable.view.MainActivity;

public class HerosClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Intent herosIntent = new Intent(view.getContext(),HeroImageActivity.class);

    }
}
