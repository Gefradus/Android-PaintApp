package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.Listener.ColorSeekBarChangeListener;
import com.example.rysowanie.Listener.StrokeWidthBarChangeListener;
import com.example.rysowanie.Strategy.ClearClickedStrategy;
import com.example.rysowanie.Strategy.FillClickedStrategy;
import com.example.rysowanie.Strategy.IButtonClickedStrategy;
import com.example.rysowanie.Strategy.PencilClickedStrategy;
import com.example.rysowanie.Strategy.RubberClickedStrategy;
import com.example.rysowanie.Strategy.SaveClickedStrategy;
import com.example.rysowanie.Strategy.SprayClickedStrategy;

import lombok.Getter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Getter
    private static final float initialWidth = 7f;
    private CanvasView canvasView;
    private SeekBar strokeWidthBar;
    private ImageButton pencilBtn, rubberBtn, clearBtn, fillBtn, saveBtn, sprayBtn;
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
        canvasView.setColor(Color.BLACK);
        canvasView.setDefaultColor(Color.BLACK);
        canvasView.setWidth(initialWidth);
        canvasView.setDefaultWidth(initialWidth);
        canvasView.setPaintStyle(Paint.Style.STROKE);

    }

    private void findAllViewsById(){
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearBtn = findViewById(R.id.clearBtn);
        colorSeekBar = findViewById(R.id.color_seek_bar);
        fillBtn = findViewById(R.id.fillBtn);
        saveBtn = findViewById(R.id.saveBtn);
        sprayBtn = findViewById(R.id.sprayBtn);
    }

    private void setListeners(){
        new OnClickListenerSetter(this, clearBtn, pencilBtn, rubberBtn, fillBtn, saveBtn, sprayBtn);
        strokeWidthBar.setOnSeekBarChangeListener(new StrokeWidthBarChangeListener(canvasView));
        colorSeekBar.setOnColorChangeListener(new ColorSeekBarChangeListener(canvasView, strokeWidthBar));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        IButtonClickedStrategy strategy;

        if(id == R.id.pencilBtn) {
            strategy = new PencilClickedStrategy();
        }
        else if(id == R.id.rubberBtn) {
            strategy = new RubberClickedStrategy();
        }
        else if(id == R.id.clearBtn) {
            strategy = new ClearClickedStrategy();
        }
        else if(id == R.id.fillBtn) {
            strategy = new FillClickedStrategy();
        }
        else if(id == R.id.sprayBtn) {
            strategy = new SprayClickedStrategy();
        }
        else {
            strategy = new SaveClickedStrategy();
        }

        strategy.onClickAction(canvasView, strokeWidthBar, this);
    }


}
