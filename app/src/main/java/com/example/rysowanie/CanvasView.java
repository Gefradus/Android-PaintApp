package com.example.rysowanie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class CanvasView extends View
{
    @Setter
    private Paint.Style paintStyle;
    @Setter
    private boolean spray;
    @Setter
    private float width;
    @Setter
    private int color;
    @Getter @Setter
    private int defaultColor;
    @Getter @Setter
    private float defaultWidth;
    @Getter @Setter
    private boolean rubber;
    private boolean clear;
    @Getter @Setter
    private List<Stroke> allStrokes;
    @Getter @Setter
    private SparseArray<Stroke> activeStrokes;


    public void setDefaultWidthAndCountProgress(float defaultWidth, int progress) {
        this.defaultWidth = defaultWidth;
        width = progress * defaultWidth / 100;
    }

    public CanvasView(Context context, AttributeSet set) {
        super(context, set);
        allStrokes = new ArrayList<>();
        activeStrokes = new SparseArray<>();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setBackgroundColor(Color.WHITE);
    }

    public void onDraw(Canvas canvas) {
        if(clear) {
            clear();
        }
        else {
            drawPath(canvas);
        }
    }

    private void drawPath(Canvas canvas){
        if (allStrokes != null) {
            for (Stroke stroke: allStrokes) {
                if (stroke != null) {
                    Path path = stroke.getPath();
                    Paint painter = stroke.getPaint();
                    if ((path != null) && (painter != null)) {
                        canvas.drawPath(path, painter);
                    }
                }
            }
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        new MotionEventHandler(allStrokes, activeStrokes, new MyPaint(paintStyle, width, color, spray))
                .onTouchEventAction(event);
        invalidate();
        return true;
    }

    private void clear() {
        allStrokes = new ArrayList<>();
        activeStrokes = new SparseArray<>();
        clear = false;
    }

    public void clearAll() {
        clear = true;
        invalidate();
    }
}