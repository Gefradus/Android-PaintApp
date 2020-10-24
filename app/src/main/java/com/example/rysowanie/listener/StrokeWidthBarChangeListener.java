package com.example.rysowanie.listener;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StrokeWidthBarChangeListener implements SeekBar.OnSeekBarChangeListener
{
    private CanvasView canvasView;

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {}

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        canvasView.setWidth(seekBar.getProgress() * canvasView.getDefaultWidth() / 100);
    }
}
