package com.example.rysowanie.Strategy;

import com.example.rysowanie.CanvasView;

class ClearClickedStrategy {
    ClearClickedStrategy(CanvasView canvasView){
        canvasView.clearAll();
    }
}
