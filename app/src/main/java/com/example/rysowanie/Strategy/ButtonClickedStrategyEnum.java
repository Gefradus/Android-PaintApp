package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;

public enum ButtonClickedStrategyEnum implements IButtonClickedStrategy {
    pencil {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            new PencilClickedStrategy(canvasView, seekBar);
        }
    },
    rubber {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            new RubberClickedStrategy(canvasView, seekBar);
        }
    },
    clear {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            new ClearClickedStrategy(canvasView);
        }
    },
    save{
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity) {
            new SaveClickedStrategy(activity, canvasView);
        }
    },
    fill {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity){
            new FillClickedStrategy(canvasView);
        }
    },
    spray {
        @Override
        public void onClickAction(CanvasView canvasView, SeekBar seekBar, Activity activity){
            new SprayClickedStrategy(canvasView);
        }
    }
}
