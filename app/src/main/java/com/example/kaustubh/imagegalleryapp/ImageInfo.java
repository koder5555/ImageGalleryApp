package com.example.kaustubh.imagegalleryapp;

public class ImageInfo {
    int id;
    String category;
    int img;
    public ImageInfo(){};

    public ImageInfo(String category, int img) {
        this.category = category;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
