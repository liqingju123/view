package com.example.imac.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by liqingju on 16/8/22.
 */
public class CrileView extends View implements Runnable {
    private boolean isRun = true;
    private int angle = 100;
    int height;
    int width;
    Canvas canvas;
    float lineX = 0;
    double lineY2 = 0;
    Paint paint1 = new Paint();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            angle = (int) (Math.random() * 100);
            angle += 20;
            Log.e("======", "==========" + angle);
            invalidate();
//            mHandler.sendEmptyMessageDelayed(1, 2000);
        }
    };

    public CrileView(Context context) {
        super(context);
    }

    public CrileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CrileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        height = getHeight();
        width = getWidth();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(5);
//        paint1.setAlpha(100);
        paint1.setColor(Color.BLACK);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint1);
        canvas.drawLine(100, 0, 100, getHeight(), paint1);
        Paint textPaint = new Paint();
        textPaint.setStrokeWidth(10);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(30);
        textPaint.setAntiAlias(true);
        Log.e("====", "绘制===");
        paint1.setColor(Color.RED);
        canvas.drawText("0", 120, getHeight() / 2 - 20, textPaint);
        for (int i = 100; i < getWidth(); i++) {
            lineX = i;
            double lineY2 = 100 * Math.sin((2 * i + angle) * Math.PI / 180) + 100;
            canvas.drawLine((int) i, (int) (lineY2 + height / 2), (int) i + 2, (int) (lineY2 + height / 2), paint1);
        }
        mHandler.sendEmptyMessageDelayed(1, 50);
    }


    /**
     * 按照角度绘制位置
     *
     * @param canvas
     */
    void drawArc(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(0, getHeight() / 2);
        path.lineTo(getWidth(), getHeight() / 2);
        path.moveTo(getWidth() / 2, 0);
        path.lineTo(getWidth() / 2, getHeight());
        path.moveTo(getWidth() / 2, getHeight());
        path.addCircle(getWidth() / 2, getHeight() / 2, 100, Path.Direction.CW);
        path.moveTo(getWidth() / 2 + (float) (100 * Math.cos(Math.PI / 4)), getHeight() / 2 - (float) (100 * Math.sin(Math.PI / 4)));
        path.lineTo(getWidth() / 2 + (float) (80 * Math.cos(Math.PI / 4)), getHeight() / 2 - (float) (80 * Math.sin(Math.PI / 4)));
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制 圆环
     *
     * @param canvas
     */
    void initClire(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30, paint);
        paint.setColor(Color.WHITE);
//        paint.setAlpha(0);
        paint.setAntiAlias(true);
//        paint.setColor();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 25, paint);
    }

    @Override
    public void run() {
        while (isRun) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            angle = (int) (Math.random() * 100);

            invalidate();
        }
    }
}
