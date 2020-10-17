package com.example.rysowanie;

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
public class CanvasView extends View {

    private List<Stroke> _allStrokes; //all strokes that need to be drawn
    private SparseArray<Stroke> _activeStrokes; //use to retrieve the currently drawn strokes
    private Integer color;
    private Float width;

    public void setStrokeWidth(Float width) {
        this.width = width;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public void set_allStrokes(List<Stroke> _allStrokes) {
        this._allStrokes = _allStrokes;
    }

    public void set_activeStrokes(SparseArray<Stroke> _activeStrokes) {
        this._activeStrokes = _activeStrokes;
    }

    public CanvasView(Context context, AttributeSet set) {
        super(context, set);
        _allStrokes = new ArrayList<>();
        _activeStrokes = new SparseArray<>();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setBackgroundColor(Color.WHITE);
    }

    public void onDraw(Canvas canvas) {
        if (_allStrokes != null) {
            for (Stroke stroke: _allStrokes) {
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();
        final int pointerCount = event.getPointerCount();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                pointDown((int)event.getX(), (int)event.getY(), event.getPointerId(0));
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
                    pointDown((int)event.getX(pc), (int)event.getY(pc), event.getPointerId(pc));
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
        _activeStrokes.put(id, stroke);
        _allStrokes.add(stroke);
    }

    private Paint createNewPaint(){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
        paint.setColor(color);
        return paint;
    }

    private void pointMove(int x, int y, int id) {
        Stroke stroke = _activeStrokes.get(id);
        if (stroke != null) {
            Point pt = new Point(x, y);
            stroke.addPoint(pt);
        }
    }
}