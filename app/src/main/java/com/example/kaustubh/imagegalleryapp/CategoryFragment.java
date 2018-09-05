package com.example.kaustubh.imagegalleryapp;


import android.os.Bundle;
import android.app.Fragment;
//import android.support.v7.app.AlertController;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static com.example.kaustubh.imagegalleryapp.MainActivity.getInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends android.support.v4.app.Fragment {
 public static RecyclerView recyclerView;
     List<Category> myDataset=getInstance().getALLCategory();
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.recycler_view, container, false);
         recyclerView=(RecyclerView)viewGroup.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
       LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
       recyclerView.setLayoutManager(mLayoutManager);
        MyAdapter mAdapter = new MyAdapter(myDataset,getActivity());

        recyclerView.setAdapter(mAdapter);
        GetAdapter.setMyAdapter(mAdapter);




        return viewGroup;

    }

  public static void refresh(){

  }

}
