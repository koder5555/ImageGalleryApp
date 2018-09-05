package com.example.kaustubh.imagegalleryapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class VpActivity extends FragmentStatePagerAdapter {
    public VpActivity(FragmentManager fm) {
        super(fm);
    }
   List<ImageInfo> list=GetImage.getTagged();
    @Override
    public Fragment getItem(int i) {
        Fragment fragment=new ImageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
