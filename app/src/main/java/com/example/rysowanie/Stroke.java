package com.example.rysowanie;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

class Stroke {
    private Path _path;
    private Paint _paint;

     Stroke (Paint paint) {
        _paint = paint;
    }

     Path getPath() {
        return _path;
    }

     Paint getPaint() {
        return _paint;
    }

     void addPoint(Point pt) {
        if (_path == null) {
            _path = new Path();
            _path.moveTo(pt.x, pt.y);
        } else {
            _path.lineTo(pt.x, pt.y);
        }
    }
}