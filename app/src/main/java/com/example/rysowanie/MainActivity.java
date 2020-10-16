package com.example.rysowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private ImageButton pencilBtn, rubberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setContentView(new CanvasView(this));
        /*pencilBtn = findViewById(R.id.pencilBtn);
        rubberBtn = findViewById(R.id.rubberBtn);
        pencilBtn.setOnClickListener(this);
        rubberBtn.setOnClickListener(this);*/
    }

   /* @Override
    public void onClick(View view) {
        CanvasView cv = findViewById(R.id.canvas);

    }*/
}
