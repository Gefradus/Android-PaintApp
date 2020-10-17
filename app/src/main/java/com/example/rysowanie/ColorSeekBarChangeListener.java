package com.example.rysowanie;

import com.divyanshu.colorseekbar.ColorSeekBar;

public class ColorSeekBarChangeListener implements ColorSeekBar.OnColorChangeListener {

    private CanvasView _canvasView;
    private int _progress;

    ColorSeekBarChangeListener(CanvasView canvasView, int progress){
        _canvasView = canvasView;
        _progress = progress;
    }

    @Override
    public void onColorChangeListener(int color) {
        _canvasView.setDefaultWidthAndCountProgress(MainActivity.initialWidth, _progress);
        _canvasView.setColorAndDefault(color);
    }
}
