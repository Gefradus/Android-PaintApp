package com.example.rysowanie.Listener;
import android.widget.SeekBar;

import com.example.rysowanie.CanvasView;

public class StrokeWidthBarChangeListener implements SeekBar.OnSeekBarChangeListener
{
    private CanvasView canvasView;

    public StrokeWidthBarChangeListener(CanvasView canvasView){
        this.canvasView = canvasView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {}

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        canvasView.setWidth(seekBar.getProgress() * canvasView.getDefaultWidth() / 100);
    }
}
