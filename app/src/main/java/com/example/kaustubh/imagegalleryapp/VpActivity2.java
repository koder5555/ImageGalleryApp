package com.example.kaustubh.imagegalleryapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class VpActivity2 extends FragmentStatePagerAdapter {
    public VpActivity2 (FragmentManager fm) {
        super(fm);
    }
    List<ImageInfo> list=GetImage.getUnTagged();
    @Override
    public Fragment getItem(int i) {
        Fragment fragment=new ImageFragment2();
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
