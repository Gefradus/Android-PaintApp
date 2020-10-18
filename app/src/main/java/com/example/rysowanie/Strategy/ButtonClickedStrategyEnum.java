package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
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
            canvasView.setPaintStyle(Paint.Style.STROKE);
            canvasView.setSpray(false);
        }
    },
    rubber {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            canvasView.setDefaultWidthAndCountProgress(16f, seekBar.getProgress());
            canvasView.setColor(Color.WHITE);
            canvasView.setPaintStyle(Paint.Style.STROKE);
            canvasView.setRubber(true);
            canvasView.setSpray(false);
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
    },
    fill {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity){
            canvasView.setPaintStyle(Paint.Style.FILL);
            canvasView.setSpray(false);
        }
    },
    spray {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity){
            canvasView.setSpray(true);
        }
    }
}
