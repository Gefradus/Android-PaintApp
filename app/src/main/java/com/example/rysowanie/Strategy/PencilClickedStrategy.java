package com.example.rysowanie.Strategy;


import android.graphics.Paint;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.MainActivity;

class PencilClickedStrategy {
    PencilClickedStrategy(CanvasView canvasView, SeekBar seekBar){
        canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), seekBar.getProgress());
        canvasView.setColor(canvasView.getDefaultColor());
        canvasView.setPaintStyle(Paint.Style.STROKE);
        canvasView.setSpray(false);
    }
}
