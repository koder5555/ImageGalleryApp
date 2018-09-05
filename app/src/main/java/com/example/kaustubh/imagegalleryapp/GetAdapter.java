package com.example.kaustubh.imagegalleryapp;

public class GetAdapter {
 public  static    ImageAdapter imageAdapter;
 public  static    ImageAdapter2 imageAdapter2;
 public  static    ImageAdapter3 imageAdapter3;
 public  static    MyAdapter myAdapter;

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }

    public static void setImageAdapter(ImageAdapter imageAdapter) {
        GetAdapter.imageAdapter = imageAdapter;
    }

    public static ImageAdapter2 getImageAdapter2() {
        return imageAdapter2;
    }

    public static void setImageAdapter2(ImageAdapter2 imageAdapter2) {
        GetAdapter.imageAdapter2 = imageAdapter2;
    }

    public static ImageAdapter3 getImageAdapter3() {
        return imageAdapter3;
    }

    public static void setImageAdapter3(ImageAdapter3 imageAdapter3) {
        GetAdapter.imageAdapter3 = imageAdapter3;
    }

    public static MyAdapter getMyAdapter() {
        return myAdapter;
    }

    public static void setMyAdapter(MyAdapter myAdapter) {
        GetAdapter.myAdapter = myAdapter;
    }
}
