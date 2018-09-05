package com.example.kaustubh.imagegalleryapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.example.kaustubh.imagegalleryapp.MainActivity.getInstance;

public class GetImage {




    public static List<ImageInfo> getTagged() {
        List<Category> listcat=getInstance().getALLCategory();
        /* List<ImageInfo> list=new ArrayList<>(getInstance().getImageByCategory("nature"));
         list.addAll(  getInstance().getImageByCategory("people"));
         list.addAll(getInstance().getImageByCategory("anime"));
         list.addAll(getInstance().getImageByCategory("motor_vehicle"));
         */
        List<ImageInfo> list=new ArrayList<>();
        for(int i=0;i<listcat.size();i++) {
            if (listcat.get(i).getCategory().equals("other"))
                continue;
            list.addAll(getInstance().getImageByCategory(listcat.get(i).getCategory()));
        }

         return list;
    }

    public static List<ImageInfo> getUnTagged(){
        return getInstance().getImageByCategory("other");
    }

    public static List<ImageInfo> getALL(){
        return getInstance().getAllImages();
    }

    public static List<ImageInfo> getPeople(){
        return getInstance().getImageByCategory("people");
    }

    public  static  List<ImageInfo> getNature(){
        return getInstance().getImageByCategory("nature");
    }

    public static List<ImageInfo> getAnime(){
        return getInstance().getImageByCategory("anime");
    }

    public static List<ImageInfo>getMv(){
        return getInstance().getImageByCategory("motor_vehicle");
    }
}
