package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.graphics.Color;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.ConfirmSaveDialog;
import com.example.rysowanie.MainActivity;

public enum ButtonClickedStrategyEnum implements IButtonClickedStrategy {
    pencil {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), seekBar.getProgress());
            canvasView.setColor(canvasView.getDefaultColor());
        }
    },
    rubber {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            canvasView.setDefaultWidthAndCountProgress(16f, seekBar.getProgress());
            canvasView.setColor(Color.WHITE);
            canvasView.setRubber(true);
        }
    },
    clear {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            canvasView.clearAll();
        }
    },
    save{
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            new ConfirmSaveDialog(activity, canvasView);
        }
    }
}
