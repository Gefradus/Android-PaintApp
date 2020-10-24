package com.example.rysowanie;

import com.example.rysowanie.activity.MainActivity;

public class ChooseColoringPage
{
    public ChooseColoringPage(MainActivity activity)
    {
        int paintingPageEnum = activity.getIntent().getExtras().getInt("coloringPage");
        String imageName = null;

        if(paintingPageEnum != 0) {
            if (paintingPageEnum == 1) {
                imageName = "/image1.png";
            } else if (paintingPageEnum == 2) {
                imageName = "/image2.png";
            } else if (paintingPageEnum == 3) {
                imageName = "/image3.png";
            } else if (paintingPageEnum == 4) {
                imageName = "/image4.png";
            }
            new LoadImageFromFile(activity, activity.getCanvasView(), imageName);
        }
    }
}
