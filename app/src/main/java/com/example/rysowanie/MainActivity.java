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
    private ImageButton pencilBtn, rubberBtn, clearAll;

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
        canvasView.setStrokeWidthAndDefault(10f);
    }

    private void findAllViewsById(){
        strokeWidthBar = findViewById(R.id.strokeWidthBar);
        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        clearAll = findViewById(R.id.btn5);
    }

    private void setListeners(){
        clearAll.setOnClickListener(this);
        pencilBtn.setOnClickListener(this);
        rubberBtn.setOnClickListener(this);
        strokeWidthBar.setOnSeekBarChangeListener(new StrokeWidthBarChangeListener(canvasView));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.pencilBtn) {
            canvasView.setColor(Color.GREEN);
        }
        else if(id == R.id.rubberBtn) {
            canvasView.setColor(Color.WHITE);
        }
        else if(id == R.id.btn5){
            
        }

    }

}
