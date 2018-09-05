package com.example.kaustubh.imagegalleryapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment3 extends Fragment {


    public ImageFragment3 () {
        // Required empty public constructor
    }

    List<ImageInfo> list=GetImage.getALL();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.full_image, container, false);
        int i=this.getArguments().getInt("id");
        ImageView imageView=viewGroup.findViewById(R.id.full_image);
        imageView.setImageResource(list.get(i).img);
        return viewGroup;
    }

}

