package com.example.rysowanie;

import com.example.rysowanie.activity.MainActivity;

public class ChooseColoringPage
{
    public ChooseColoringPage(MainActivity activity)
    {
        int paintingPageEnum = activity.getIntent().getExtras().getInt("coloringPage");
        int id = 0;

        if(paintingPageEnum != 0) {
            if (paintingPageEnum == 1) {
                id = R.drawable.kolorowanka1;
            } else if (paintingPageEnum == 2) {
                id = R.drawable.kolorowanka2;
            } else if (paintingPageEnum == 3) {
                id = R.drawable.kolorowanka3;
            } else if (paintingPageEnum == 4) {
                id = R.drawable.kolorowanka4;
            }
            new LoadImageFromFile(activity, activity.getCanvasView(), id);
        }
    }
}
