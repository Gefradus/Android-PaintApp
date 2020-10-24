package com.example.rysowanie.strategy;

import android.app.Activity;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;

public interface IButtonClickedStrategy {
    void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity);
}