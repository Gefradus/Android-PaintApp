package com.example.rysowanie.Strategy;


import android.app.Activity;
import android.graphics.Paint;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.MainActivity;

public class PencilClickedStrategy implements IButtonClickedStrategy{

    @Override
    public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
        canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), seekBar.getProgress());
        canvasView.setColor(canvasView.getDefaultColor());
        canvasView.setPaintStyle(Paint.Style.STROKE);
        canvasView.setSpray(false);
    }
}
