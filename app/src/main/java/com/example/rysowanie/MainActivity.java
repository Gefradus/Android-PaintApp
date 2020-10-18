package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.Listener.ColorSeekBarChangeListener;
import com.example.rysowanie.Listener.StrokeWidthBarChangeListener;
import com.example.rysowanie.Strategy.ButtonClickedStrategyEnum;
import com.example.rysowanie.Strategy.IButtonClickedStrategy;
import lombok.Getter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Getter
    private static final float initialWidth = 7f;
    private CanvasView canvasView;
    private SeekBar strokeWidthBar;
    private ImageButton pencilBtn, rubberBtn, clearBtn, sprayBtn, saveBtn;
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
        canvasView.setStrokeWidthAndDefault(initialWidth);
    }

    private void findAllViewsById(){
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearBtn = findViewById(R.id.clearBtn);
        colorSeekBar = findViewById(R.id.color_seek_bar);
        sprayBtn = findViewById(R.id.sprayBtn);
        saveBtn = findViewById(R.id.saveBtn);
    }

    private void setListeners(){
        new OnClickListenerSetter(this, clearBtn, pencilBtn, rubberBtn, sprayBtn, saveBtn);
        strokeWidthBar.setOnSeekBarChangeListener(new StrokeWidthBarChangeListener(canvasView));
        colorSeekBar.setOnColorChangeListener(new ColorSeekBarChangeListener(canvasView, strokeWidthBar));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        IButtonClickedStrategy strategy = null;

        if(id == R.id.pencilBtn) {
            strategy = ButtonClickedStrategyEnum.pencil;
        }
        else if(id == R.id.rubberBtn) {
            strategy = ButtonClickedStrategyEnum.rubber;
        }
        else if(id == R.id.clearBtn) {
            strategy = ButtonClickedStrategyEnum.clear;
        }
        else if(id == R.id.sprayBtn){
            strategy = ButtonClickedStrategyEnum.spray;
        }
        else if(id == R.id.saveBtn){
            strategy = ButtonClickedStrategyEnum.save;
        }

        strategy.onClickAction(canvasView, strokeWidthBar, this);
    }



}
