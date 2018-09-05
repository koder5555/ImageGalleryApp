package com.example.kaustubh.imagegalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class FullImageActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        //ImageAdapter imageAdapter = new ImageAdapter(this);

        //ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        //imageView.setImageResource(imageAdapter.mThumbIds[position]);

        ViewPager viewPager=(ViewPager)findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter=new VpActivity(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);

    }

}

