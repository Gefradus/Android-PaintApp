package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.SeekBar;

import com.example.rysowanie.CanvasView;

public class RubberClickedStrategy implements IButtonClickedStrategy {
    @Override
    public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
        canvasView.setDefaultWidthAndCountProgress(16f, seekBar.getProgress());
        canvasView.setColor(Color.WHITE);
        canvasView.setPaintStyle(Paint.Style.STROKE);
        canvasView.setRubber(true);
        canvasView.setSpray(false);
    }
}
