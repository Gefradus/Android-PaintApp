package com.example.rysowanie;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

class MyPaint extends Paint {

    MyPaint(Paint.Style style, float width, int color, boolean spray){
        setStyle(style);
        setStrokeWidth(width);
        setColor(color);
        checkIfSpray(spray);
    }

    private void checkIfSpray(boolean spray){
        if(spray) {
            setPathEffect(new DashPathEffect(new float[] {5f,5f}, 0));
            setStyle(Style.STROKE);
        }
    }

}
