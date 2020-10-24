package com.example.rysowanie.strategy;

import android.app.Activity;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;

public class SprayClickedStrategy implements IButtonClickedStrategy {

    @Override
    public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
        canvasView.setSpray(true);
    }
}
