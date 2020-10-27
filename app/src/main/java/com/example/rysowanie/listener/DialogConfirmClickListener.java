package com.example.rysowanie.listener;

import android.app.Activity;
import android.content.DialogInterface;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.SaveImage;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DialogConfirmClickListener implements DialogInterface.OnClickListener {
    private Activity _activity;
    private CanvasView view;

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        new SaveImage(_activity, view);
    }
}
