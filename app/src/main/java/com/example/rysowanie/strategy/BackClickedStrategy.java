package com.example.rysowanie.strategy;

import android.app.Activity;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.Stroke;
import java.util.List;

public class BackClickedStrategy  implements IButtonClickedStrategy{

    @Override
    public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
        List<Stroke> list = canvasView.getAllStrokes();
        if(list.size() > 0) {
            list.remove(list.size() - 1);
            canvasView.invalidate();
        }
    }

}
