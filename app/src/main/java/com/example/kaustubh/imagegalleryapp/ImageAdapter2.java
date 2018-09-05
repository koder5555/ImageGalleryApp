package com.example.kaustubh.imagegalleryapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.GetChars;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import static com.example.kaustubh.imagegalleryapp.MainActivity.getInstance;

public class ImageAdapter2 extends BaseAdapter {

    List<ImageInfo>list= GetImage.getTagged();
    Context mContext;
    public ImageAdapter2(Context c){
        mContext=c;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).img;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(list.get(position).img);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(600, 600));
        return imageView;
    }

    public void refresh(){
        list=GetImage.getTagged();
        notifyDataSetChanged();
    }
}
