package com.example.rysowanie;

import android.graphics.Paint;

public class MyBrush extends Paint {

    private int color;
    private Paint.Style style;
    private Paint.Join join;
    private int width;

    public void setJoin(Join join) {
        this.join = join;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    MyBrush(int color, Paint.Style style, Paint.Join join, int width) {
        setAntiAlias(true);
        setColor(color);
        setStyle(style);
        setStrokeJoin(join);
        setStrokeWidth(width);
    }

     MyBrush(){
        setAntiAlias(true);
        setColor(color);
        setStyle(style);
        setStrokeJoin(join);
        setStrokeWidth(width);
    }
}
