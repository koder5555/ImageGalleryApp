package com.example.kaustubh.imagegalleryapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import static com.example.kaustubh.imagegalleryapp.MainActivity.getInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnTaggedFragment extends Fragment {


    public UnTaggedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view=(ViewGroup) inflater.inflate(R.layout.fragment_un_tagged, container, false);
        GridView gridView=view.findViewById(R.id.grid_view);
        ImageAdapter3 imageAdapter3=new ImageAdapter3(getContext());
        gridView.setAdapter(imageAdapter3);
        GetAdapter.setImageAdapter3(imageAdapter3);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent i = new Intent(getContext(), FullImageActivity2.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Menu");
                String[] menu = {"Details", "Change Tag","Delete Image"};
                final int pos=position;
                alertDialog.setItems(menu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: {
                                AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(getContext());
                                mAlertDialog.setTitle("Details");
                                mAlertDialog.setMessage("CATEGORY : " + GetImage.getUnTagged().get(pos).category);
                                mAlertDialog.create().show();
                                break;
                            }

                            case 1:{
                                AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(getContext());
                                mAlertDialog.setTitle("Select Tag");
                                List<Category> list=getInstance().getALLCategory();
                                final String select[] =new String[list.size()];
                                for (int i=0;i<list.size();i++)
                                    select[i]=list.get(i).getCategory();
                                mAlertDialog.setItems(select, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int image=GetImage.getUnTagged().get(pos).img;
                                                getInstance().updateImageInfo(new ImageInfo(select[which],image),image);
                                                GetAdapter.getImageAdapter3().refresh();
                                                GetAdapter.getImageAdapter2().refresh();
                                               // GetAdapter.getImageAdapter().refresh();

                                                GetAdapter.myAdapter.refresh();



                                    }
                                });

                                mAlertDialog.create().show();

                            }

                            break;

                            case 2:{
                                 getInstance().deleteImageInfo(GetImage.getUnTagged().get(pos).img);
                                GetAdapter.getImageAdapter3().refresh();
                                GetAdapter.getImageAdapter2().refresh();
                                // GetAdapter.getImageAdapter().refresh();
                                GetAdapter.getMyAdapter().refresh();
                            }

                        }
                    }
                });

                alertDialog.create().show();
                return true;
            }

        });



        return view;
    }

    }


