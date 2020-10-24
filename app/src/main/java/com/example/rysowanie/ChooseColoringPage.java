package com.example.rysowanie;

import com.example.rysowanie.activity.MainActivity;

public class ChooseColoringPage
{
    public ChooseColoringPage(MainActivity activity)
    {
        int paintingPageEnum = activity.getIntent().getExtras().getInt("coloringPage");
        
        if(paintingPageEnum != 0) {
            int id = 0;
            if (paintingPageEnum == R.id.image1) {
                id = R.drawable.kolorowanka1;
            } else if (paintingPageEnum == R.id.image2) {
                id = R.drawable.kolorowanka2;
            } else if (paintingPageEnum == R.id.image3) {
                id = R.drawable.kolorowanka3;
            } else if (paintingPageEnum == R.id.image4) {
                id = R.drawable.kolorowanka4;
            }
            new LoadImageFromFile(activity, activity.getCanvasView(), id);
        }
    }
}
