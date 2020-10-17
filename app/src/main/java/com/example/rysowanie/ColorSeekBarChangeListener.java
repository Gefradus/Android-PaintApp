package com.example.rysowanie;

import com.divyanshu.colorseekbar.ColorSeekBar;

public class ColorSeekBarChangeListener implements ColorSeekBar.OnColorChangeListener {

    private CanvasView canvasView;

    ColorSeekBarChangeListener(CanvasView canvasView){
        this.canvasView = canvasView;
    }

    @Override
    public void onColorChangeListener(int color) {
        canvasView.setColorAndDefault(color);
    }
}
