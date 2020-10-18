package com.example.rysowanie;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import lombok.Getter;


class Stroke {
    @Getter
    private Path path;
    @Getter
    private Paint paint;

     Stroke (Paint paint) {
        this.paint = paint;
    }

     void addPoint(Point pt) {
        if (path == null) {
            path = new Path();
            path.moveTo(pt.x, pt.y);
        } else {
            path.lineTo(pt.x, pt.y);
        }
    }
}