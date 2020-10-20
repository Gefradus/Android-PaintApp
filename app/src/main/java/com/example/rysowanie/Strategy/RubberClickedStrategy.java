package com.example.rysowanie.Strategy;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.SeekBar;

import com.example.rysowanie.CanvasView;

class RubberClickedStrategy {
    RubberClickedStrategy(CanvasView canvasView, SeekBar seekBar){
        canvasView.setDefaultWidthAndCountProgress(16f, seekBar.getProgress());
        canvasView.setColor(Color.WHITE);
        canvasView.setPaintStyle(Paint.Style.STROKE);
        canvasView.setRubber(true);
        canvasView.setSpray(false);
    }
}
