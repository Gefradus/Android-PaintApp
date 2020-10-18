package com.example.rysowanie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
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
    @Getter
    private int defaultColor;
    @Setter
    private int color;
    @Getter
    private float defaultWidth;
    @Getter @Setter
    private float width;
    @Getter @Setter
    private boolean rubber;
    @Getter @Setter
    private boolean spray;
    private boolean clear;
    private List<Stroke> allStrokes;
    private SparseArray<Stroke> activeStrokes;

    public void setDefaultWidthAndCountProgress(float defaultWidth, int progress) {
        this.defaultWidth = defaultWidth;
        width = progress * defaultWidth / 100;
    }

    public void setStrokeWidthAndDefault(float strokeWidth) {
        defaultWidth = strokeWidth;
        width = strokeWidth;
    }

    public void setColorAndDefault(int color){
        this.color = color;
        defaultColor = color;
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
        if(!clear){
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
        } else {
            clear();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        final int action = event.getActionMasked();
        final int pointerCount = event.getPointerCount();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                pointDown((int) event.getX(), (int) event.getY(), event.getPointerId(0));
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                for (int pc = 0; pc < pointerCount; pc++) {
                    pointMove((int) event.getX(pc), (int) event.getY(pc), event.getPointerId(pc));
                }
                break;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                for (int pc = 0; pc < pointerCount; pc++) {
                    pointDown((int) event.getX(pc), (int) event.getY(pc), event.getPointerId(pc));
                }
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                break;
            }
        }

        invalidate();
        return true;
    }

    private void pointDown(int x, int y, int id) {
        Point pt = new Point(x, y);
        Stroke stroke = new Stroke(createNewPaint());
        stroke.addPoint(pt);
        activeStrokes.put(id, stroke);
        allStrokes.add(stroke);
    }

    private Paint createNewPaint(){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
        paint.setColor(color);
        return paint;
    }

    private void pointMove(int x, int y, int id) {
        Stroke stroke = activeStrokes.get(id);
        if (stroke != null) {
            Point pt = new Point(x, y);
            stroke.addPoint(pt);
        }
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