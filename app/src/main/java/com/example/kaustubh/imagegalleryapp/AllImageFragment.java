package com.example.kaustubh.imagegalleryapp;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllImageFragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view= (ViewGroup) inflater.inflate(R.layout.fragment_all_image, container, false);

        GridView gridView=view.findViewById(R.id.grid_view);
        ImageAdapter imageAdapter=new ImageAdapter(getContext());
        GetAdapter.setImageAdapter(imageAdapter);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent i = new Intent(getContext(), FullImageActivity3.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog alertDialog= new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Details:");
                alertDialog.setMessage("CATEGORY: "+GetImage.getALL().get(position).category);
                alertDialog.show();
                return true;
            }
        });

        return view;
    }

    }


