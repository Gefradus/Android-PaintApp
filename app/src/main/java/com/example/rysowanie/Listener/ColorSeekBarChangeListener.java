package com.example.rysowanie.Listener;

import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.MainActivity;

public class ColorSeekBarChangeListener implements ColorSeekBar.OnColorChangeListener {

    private SeekBar _strokeWidthBar;
    private CanvasView _canvasView;

    public ColorSeekBarChangeListener(CanvasView canvasView, SeekBar strokeWidthBar) {
        _canvasView = canvasView;
        _strokeWidthBar = strokeWidthBar;
    }

    @Override
    public void onColorChangeListener(int color) {
        _canvasView.setColorAndDefault(color);
        if(_canvasView.isRubber()) {
            _canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), _strokeWidthBar.getProgress());
            _canvasView.setRubber(false);
        }
    }
}
