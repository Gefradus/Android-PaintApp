package com.example.rysowanie.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.divyanshu.colorseekbar.ColorSeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.ChooseColoringPage;
import com.example.rysowanie.LoadImageFromFile;
import com.example.rysowanie.OnClickListenerSetter;
import com.example.rysowanie.R;
import com.example.rysowanie.listener.ColorSeekBarChangeListener;
import com.example.rysowanie.listener.StrokeWidthBarChangeListener;
import com.example.rysowanie.strategy.BackClickedStrategy;
import com.example.rysowanie.strategy.ClearClickedStrategy;
import com.example.rysowanie.strategy.FillClickedStrategy;
import com.example.rysowanie.strategy.IButtonClickedStrategy;
import com.example.rysowanie.strategy.PencilClickedStrategy;
import com.example.rysowanie.strategy.RubberClickedStrategy;
import com.example.rysowanie.strategy.SaveClickedStrategy;
import com.example.rysowanie.strategy.SprayClickedStrategy;
import lombok.Getter;
import lombok.Setter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Getter
    private static final float initialWidth = 7f;
    @Setter @Getter
    private CanvasView canvasView;
    private SeekBar strokeWidthBar;
    private ImageButton pencilBtn, rubberBtn, clearBtn, fillBtn, saveBtn, sprayBtn, backBtn;
    private ColorSeekBar colorSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsById();
        init();
        setListeners();
        new ChooseColoringPage(this);
    }

    private void init() {
        canvasView.setColor(Color.BLACK);
        canvasView.setDefaultColor(Color.BLACK);
        canvasView.setWidth(initialWidth);
        canvasView.setDefaultWidth(initialWidth);
        canvasView.setPaintStyle(Paint.Style.STROKE);
    }

    private void findAllViewsById(){
        canvasView = findViewById(R.id.canvas);
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearBtn = findViewById(R.id.clearBtn);
        colorSeekBar = findViewById(R.id.color_seek_bar);
        fillBtn = findViewById(R.id.fillBtn);
        saveBtn = findViewById(R.id.saveBtn);
        sprayBtn = findViewById(R.id.sprayBtn);
        backBtn = findViewById(R.id.backBtn);
    }

    private void setListeners(){
        new OnClickListenerSetter(this, clearBtn, pencilBtn, rubberBtn, fillBtn, saveBtn, sprayBtn, backBtn);
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
        else if(id == R.id.backBtn){
            strategy = new BackClickedStrategy();
        }
        else {
            strategy = new SaveClickedStrategy();
        }

        strategy.onClickAction(canvasView, strokeWidthBar, this);
    }


}
