package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.graphics.Paint;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;

public class FillClickedStrategy implements IButtonClickedStrategy {
    @Override
    public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
        canvasView.setPaintStyle(Paint.Style.FILL);
        canvasView.setSpray(false);
    }
}
