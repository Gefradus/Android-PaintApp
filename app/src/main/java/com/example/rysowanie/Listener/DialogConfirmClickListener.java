package com.example.rysowanie.Listener;

import android.app.Activity;
import android.content.DialogInterface;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.SaveImageFromCanvasViewToGallery;

public class DialogConfirmClickListener implements DialogInterface.OnClickListener {

    private Activity _activity;
    private CanvasView view;

    public DialogConfirmClickListener(Activity activity, CanvasView canvasView){
        _activity = activity;
        view = canvasView;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        new SaveImageFromCanvasViewToGallery(_activity, view);
    }
}
