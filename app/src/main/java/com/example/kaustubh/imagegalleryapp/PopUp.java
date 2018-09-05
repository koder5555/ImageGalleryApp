package com.example.kaustubh.imagegalleryapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class PopUp extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        String category=getArguments().getString("category");
        alertDialog.setTitle("Details:").setMessage("CATEGORY: "+category);

        return alertDialog.create();
    }
}
