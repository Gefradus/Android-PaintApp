package com.example.rysowanie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
    private Path path;
    private Paint brush;
    private float mX, mY;
    Context context;
    private static final float Tolerance = 5;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        path = new Path();
        brush = new MyBrush(Color.BLACK, Paint.Style.STROKE, Paint.Join.ROUND, 8);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,brush);
    }

    private void startTouch (float x , float y){
        path.moveTo(x,y);
        mX = x;
        mY = y ;
    }

    public void moveTouche (float x,float y ) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if(dx >= Tolerance || dy >= Tolerance){
            path.quadTo(mX,mY,(x+mX)/2,(y+mY)/2);
            mX = x ;
            mY = y;

        }
    }
    
    private void upTouch(){
        path.lineTo(mX,mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startTouch(x,y);
                invalidate();
                break ;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break ;
            case MotionEvent.ACTION_MOVE:
                moveTouche(x,y);
                invalidate();
                break ;

        }
        return true ;
    }
}