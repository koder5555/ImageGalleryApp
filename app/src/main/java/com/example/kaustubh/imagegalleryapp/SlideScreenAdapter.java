package com.example.kaustubh.imagegalleryapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SlideScreenAdapter extends FragmentPagerAdapter {
    public SlideScreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        AllImageFragment allImageFragment=new AllImageFragment();
        TaggedFragment taggedFragment=new TaggedFragment();
        UnTaggedFragment unTaggedFragment=new UnTaggedFragment();
        CategoryFragment categoryFragment=new CategoryFragment();

        switch (i){
            case 0:
                    return categoryFragment;
            case 1:
                return taggedFragment;
            case 2:
                return unTaggedFragment;
            case 3:
                return categoryFragment;
        }
      return new AllImageFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "ALL";
            case 1:return "TAGGED";
            case 2: return "UNTAGGED";
           // case 3: return "CATEGORIES";

        }
        return "CHU";
    }
}
