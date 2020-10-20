package com.example.rysowanie.Strategy;

import android.graphics.Paint;

import com.example.rysowanie.CanvasView;

class FillClickedStrategy {
    FillClickedStrategy(CanvasView canvasView){
        canvasView.setPaintStyle(Paint.Style.FILL);
        canvasView.setSpray(false);
    }
}
