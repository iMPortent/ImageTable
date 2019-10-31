package com.markedstudios.imagetable.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.markedstudios.imagetable.R;

public class HeroImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_image_activity);

        ImageView herosImage = findViewById(R.id.hero_close_up);

        Glide.with(getBaseContext()).load(getIntent().getStringExtra("url")).into(herosImage);

    }
}
