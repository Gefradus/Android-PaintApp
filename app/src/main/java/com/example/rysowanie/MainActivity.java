package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CanvasView canvasView;
    private ImageButton pencilBtn, rubberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCanvas();

        pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        pencilBtn.setOnClickListener(this);
        rubberBtn.setOnClickListener(this);
    }

    private void initCanvas() {
        canvasView = findViewById(R.id.canvas);
        canvasView.setColor(Color.BLACK);
        canvasView.setStrokeWidth(10f);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.pencilBtn){
            canvasView.setColor(Color.DKGRAY);
            canvasView.setStrokeWidth(5f);
        } else if(id == R.id.rubberBtn) {
            canvasView.setColor(Color.WHITE);
            canvasView.setStrokeWidth(15f);
        }

    }
}
