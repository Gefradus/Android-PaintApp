package com.example.rysowanie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rysowanie.OnClickListenerSetter;
import com.example.rysowanie.R;

public class SelectColoringPageActivity  extends AppCompatActivity implements View.OnClickListener
{
    private ImageView image1, image2, image3, image4;

    private void findAllViewsById(){
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        findAllViewsById();
        new OnClickListenerSetter(this, image1, image2, image3, image4);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("coloringPage", view.getId());
        startActivity(intent);
    }
}
