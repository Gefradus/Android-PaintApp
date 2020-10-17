package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.Strategy.ButtonClickedStrategyEnum;
import com.example.rysowanie.Strategy.IButtonClickedStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CanvasView canvasView;
    private SeekBar strokeWidthBar;
    private ImageButton pencilBtn, rubberBtn, clearBtn, btn3;
    private ColorSeekBar colorSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findAllViewsById();
        setListeners();
    }

    private void init() {
        canvasView = findViewById(R.id.canvas);
        canvasView.setColorAndDefault(Color.BLACK);
        canvasView.setStrokeWidthAndDefault(5f);
    }

    private void findAllViewsById(){
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearBtn = findViewById(R.id.clearBtn);
        colorSeekBar = findViewById(R.id.color_seek_bar);
        btn3 = findViewById(R.id.btn3);
    }

    private void setListeners(){
        clearBtn.setOnClickListener(this);
        pencilBtn.setOnClickListener(this);
        rubberBtn.setOnClickListener(this);
        btn3.setOnClickListener(this);
        strokeWidthBar.setOnSeekBarChangeListener(new StrokeWidthBarChangeListener(canvasView));
        colorSeekBar.setOnColorChangeListener(new ColorSeekBarChangeListener(canvasView));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        IButtonClickedStrategy strategy;

        if(id == R.id.pencilBtn) {
            strategy = ButtonClickedStrategyEnum.pencil;
        }
        else if(id == R.id.rubberBtn) {
            strategy = ButtonClickedStrategyEnum.rubber;
        }
        else if(id == R.id.clearBtn) {
            strategy = ButtonClickedStrategyEnum.clear;
        }
        else {
            strategy = null;
        }

        strategy.onClickAction(canvasView, strokeWidthBar);
    }


}
