package com.example.rysowanie;

import android.graphics.Paint;

public class MyBrush extends Paint {

    private int color;
    private Paint.Style style;
    private Paint.Join join;
    
    public void setJoin(Join join) {
        this.join = join;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int width;

    public MyBrush(int color, Paint.Style style, Paint.Join join, int width) {
        setAntiAlias(true);
        setColor(color);
        setStyle(style);
        setStrokeJoin(join);
        setStrokeWidth(width);
    }

    public MyBrush(){
        setAntiAlias(true);
        setColor(color);
        setStyle(style);
        setStrokeJoin(join);
        setStrokeWidth(width);
    }
}
