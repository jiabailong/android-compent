package com.tal.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DragTextView extends TextView {
    public DragTextView(Context context) {
        super(context);
        init();
    }

    public DragTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DragTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    public void  init(){
        setText("test");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("@jia","TestText-dispatchTouchEvent");

        return super.dispatchTouchEvent(event);
    }
float x,y,rawx,rawy;
    float sx,sy,srawx,srawy;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("@jia","TestText-onTouchEvent");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sx=event.getX();
                sy=event.getY();
                srawx=event.getRawX();
                srawy=event.getRawY();
                Log.d("@jia","sx="+sx+",sy="+sy+",srawx="+srawx+",srawy="+srawy);

                break;
            case MotionEvent.ACTION_MOVE:
                x=event.getX();
                y=event.getY();
                rawx=event.getRawX();
                rawy=event.getRawY();
                this.setTranslationY((rawy-srawy));
                this.setTranslationX((rawx-srawx));
//                requestLayout();
                Log.d("@jia","x="+x+",y="+y+",rawx="+rawx+",rawy="+rawy+",(rawy-srawy)="+(rawy-srawy));
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        Log.d("@jia","TestText-layout");

        super.layout(l, t, r, b);
    }
}
