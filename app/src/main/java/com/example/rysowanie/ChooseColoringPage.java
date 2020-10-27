package com.example.rysowanie;

import com.example.rysowanie.activity.MainActivity;
import java.util.Objects;

public class ChooseColoringPage
{
    public ChooseColoringPage(MainActivity activity)
    {
        int paintingPageEnum = Objects.requireNonNull(activity.getIntent().getExtras()).getInt("coloringPage");

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
            new LoadImage(activity, id);
        }
        else {
            String filePath = activity.getIntent().getExtras().getString("imagePath");
            if(!filePath.equals("")){
                new LoadImage(activity, filePath);
            }
        }
    }
}
