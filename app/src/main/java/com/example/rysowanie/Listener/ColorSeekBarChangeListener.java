package com.example.rysowanie.Listener;

import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.MainActivity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ColorSeekBarChangeListener implements ColorSeekBar.OnColorChangeListener {

    private CanvasView _canvasView;
    private SeekBar _strokeWidthBar;

    @Override
    public void onColorChangeListener(int color) {
        _canvasView.setColorAndDefault(color);
        if(_canvasView.isRubber()) {
            _canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), _strokeWidthBar.getProgress());
            _canvasView.setRubber(false);
        }
    }
}
