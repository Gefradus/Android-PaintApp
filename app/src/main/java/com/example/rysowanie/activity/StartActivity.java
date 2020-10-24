package com.example.rysowanie.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rysowanie.OnClickListenerSetter;
import com.example.rysowanie.R;


@SuppressLint("Registered")
public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button coloringPageBtn, defaultPaintingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findAllViewsById();
        new OnClickListenerSetter(this, coloringPageBtn, defaultPaintingBtn);
    }

    private void findAllViewsById(){
        coloringPageBtn = findViewById(R.id.coloringPageBtn);
        defaultPaintingBtn = findViewById(R.id.defaultPaintingBtn);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(this, MainActivity.class);
        if(id == R.id.defaultPaintingBtn){
            intent.putExtra("coloringPage", 0);
        }
        else{
            intent.putExtra("coloringPage", 1);
        }
        startActivity(intent);
    }
}
