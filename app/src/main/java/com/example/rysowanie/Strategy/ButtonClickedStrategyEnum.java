package com.example.rysowanie.Strategy;

import android.graphics.Color;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.MainActivity;
import com.example.rysowanie.SaveImageFromCanvasViewToGallery;

public enum ButtonClickedStrategyEnum implements IButtonClickedStrategy {
    pencil {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar) {
            canvasView.setDefaultWidthAndCountProgress(MainActivity.getInitialWidth(), seekBar.getProgress());
            canvasView.setColor(canvasView.getDefaultColor());
        }
    },
    rubber {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar) {
            canvasView.setDefaultWidthAndCountProgress(12f, seekBar.getProgress());
            canvasView.setColor(Color.WHITE);
            canvasView.setRubber(true);
        }
    },
    clear {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar) {
            canvasView.clearAll();
        }
    },
    save{
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar) {
            new SaveImageFromCanvasViewToGallery(canvasView);
        }
    }
}
