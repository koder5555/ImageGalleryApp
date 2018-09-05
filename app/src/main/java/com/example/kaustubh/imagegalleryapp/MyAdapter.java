package com.example.kaustubh.imagegalleryapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.example.kaustubh.imagegalleryapp.MainActivity.getInstance;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{


    ViewGroup par;





    public static class ViewHolder0 extends ViewHolder{
        TextView textView;

        ViewHolder0(View view){
            super(view);
            textView=(TextView) view;
        }
    }

    public static class ViewHolder1 extends ViewHolder{
        HorizontalScrollView horizontalScrollView;
        ViewHolder1(View view){
            super(view);
            horizontalScrollView=(HorizontalScrollView) view;
        }
    }

    public List<Category> strings;
    Context context;

    MyAdapter(List<Category> MyData, Context c){
        strings=MyData;
        context= c;
    }

    public int  getItemViewType(int position){
        return position%2;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        par=parent;
        switch (viewType){
            case 0:
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.textview,parent,false);
                return new ViewHolder0(view);

            case 1:
                View view1=LayoutInflater.from(parent.getContext()).inflate(R.layout.scrollview,parent,false);
                return new ViewHolder1(view1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        List<Category> list=getInstance().getALLCategory();
        List<List<ImageInfo> > mlist=new ArrayList<  List<ImageInfo> >();
        for(int i=0;i<list.size();i++){

            List<ImageInfo>temp=getInstance().getImageByCategory(list.get(i).getCategory());
            mlist.add(temp);

        }


        switch (holder.getItemViewType()){
            case 0:
                ViewHolder0 viewHolder0=(ViewHolder0)holder;
                viewHolder0.textView.setText(strings.get(position/2).getCategory());
                break;
            case 1:

                ViewHolder1 viewHolder1=(ViewHolder1)holder;

                LinearLayout linearLayout=viewHolder1.horizontalScrollView.findViewById(R.id.linear);
                linearLayout.removeAllViewsInLayout();



                        for (int i = 0; i < mlist.get(position/2).size(); i++) {
                            ImageView imageView = new ImageView(context);
                            imageView.setId(i);
                            imageView.setPadding(2, 2, 2, 2);
                            imageView.setImageResource(mlist.get(position/2).get(i).img);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
                            final int pos=i;
                            final int image=mlist.get(position/2).get(i).img;
                            imageView.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View v) {
                                    Intent intent=new Intent(context,ShowFullImage.class);
                                    intent.putExtra("image",image);
                                    context.startActivity(intent);
                                }
                            });

                            if(imageView.getParent()!=null)
                                ((ViewGroup)imageView.getParent()).removeView(imageView);
                            linearLayout.addView(imageView);

                        }



                }

        }



    public void refresh(){
        strings=getInstance().getALLCategory();

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 2*strings.size();
    }
}
