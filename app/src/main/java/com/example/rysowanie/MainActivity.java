package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CanvasView canvasView;
    private SeekBar strokeWidthBar;
    private ImageButton pencilBtn, rubberBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCanvas();
        findAllViewsById();
        setListeners();
    }

    private void initCanvas() {
        canvasView = findViewById(R.id.canvas);
        canvasView.setColor(Color.BLACK);
        canvasView.setStrokeWidthAndDefault(5f);
    }

    private void findAllViewsById(){
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearBtn = findViewById(R.id.clearBtn);
    }

    private void setListeners(){
        clearBtn.setOnClickListener(this);
        pencilBtn.setOnClickListener(this);
        rubberBtn.setOnClickListener(this);
        strokeWidthBar.setOnSeekBarChangeListener(new StrokeWidthBarChangeListener(canvasView));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.pencilBtn) {
            canvasView.setDefaultWidthAndCountProgress(5f, strokeWidthBar.getProgress());
            canvasView.setColor(Color.GRAY);
        }
        else if(id == R.id.rubberBtn) {
            canvasView.setDefaultWidthAndCountProgress(12f, strokeWidthBar.getProgress());
            canvasView.setColor(Color.WHITE);
        }
        else if(id == R.id.clearBtn){
            canvasView.clearAll();
        }

    }

}
