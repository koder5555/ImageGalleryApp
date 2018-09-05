package com.example.kaustubh.imagegalleryapp;

public class Category {
   public static int count=5;
    int id;
    String category;

    public Category(){

    }

    public Category(int id, String category) {
        this.category = category;
        this.id=id;
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

    public static int getCount(){
        return count;
    }

    public static void setCount(int i){
        count=count+i;
    }
}
