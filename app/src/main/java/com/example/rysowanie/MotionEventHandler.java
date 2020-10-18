package com.example.rysowanie;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class MotionEventHandler {

    private List<Stroke> allStrokes;
    private SparseArray<Stroke> activeStrokes;
    private MyPaint myPaint;

    void onTouchEventAction(MotionEvent event){
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
    }

    private void pointDown(int x, int y, int id) {
        Point pt = new Point(x, y);
        Stroke stroke = new Stroke(myPaint);
        stroke.addPoint(pt);
        activeStrokes.put(id, stroke);
        allStrokes.add(stroke);
    }


    private void pointMove(int x, int y, int id) {
        Stroke stroke = activeStrokes.get(id);
        if (stroke != null) {
            Point pt = new Point(x, y);
            stroke.addPoint(pt);
        }
    }
}
