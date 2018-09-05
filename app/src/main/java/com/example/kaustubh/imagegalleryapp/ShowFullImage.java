package com.example.kaustubh.imagegalleryapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShowFullImage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full);

        int i=getIntent().getExtras().getInt("image");
        ImageView imageView=findViewById(R.id.full);

        imageView.setImageResource(i);

    }
}
