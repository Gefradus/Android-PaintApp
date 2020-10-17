package com.example.rysowanie;

import android.widget.SeekBar;

public class StrokeWidthBarChangeListener implements SeekBar.OnSeekBarChangeListener
{
    private CanvasView canvasView;

    StrokeWidthBarChangeListener(CanvasView canvasView){
        this.canvasView = canvasView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        canvasView.setStrokeWidth(seekBar.getProgress() * canvasView.getDefaultWidth() / 50);
    }
}
