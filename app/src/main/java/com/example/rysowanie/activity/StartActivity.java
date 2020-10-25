package com.example.rysowanie.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rysowanie.MyMaterialFilePicker;
import com.example.rysowanie.OnClickListenerSetter;
import com.example.rysowanie.R;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

@SuppressLint("Registered")
public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button coloringPageBtn, defaultPaintingBtn, loadImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findAllViewsById();
        new OnClickListenerSetter(this, coloringPageBtn, defaultPaintingBtn, loadImageBtn);
    }

    private void findAllViewsById(){
        coloringPageBtn = findViewById(R.id.coloringPageBtn);
        defaultPaintingBtn = findViewById(R.id.defaultPaintingBtn);
        loadImageBtn = findViewById(R.id.loadImageBtn);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        if(id == R.id.defaultPaintingBtn){
            intent = new Intent(this, MainActivity.class);
            intent.putExtra("coloringPage", 0);
            startActivity(intent);
        }
        else if(id == R.id.coloringPageBtn){
            intent = new Intent(this, SelectColoringPageActivity.class);
            startActivity(intent);
        }
        else {
            new MyMaterialFilePicker(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
        }
    }

}
