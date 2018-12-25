package com.ashwani.dice.view;

import android.graphics.Canvas;
import android.graphics.Paint;

// Class to draw the dots on the screen

public class Dots {

    private Canvas canvas;
    private int randomNumber;
    private int width;
    private int height;
    private Paint dotsPaint;
    private int RADIUS;
    private int DISTANCE;

    Dots(Canvas mCanvas, int mRandomNumber, int mWidth, int mHeight, Paint mDotsPaint){
        canvas = mCanvas;
        randomNumber = mRandomNumber;
        width = mWidth;
        height = mHeight;
        dotsPaint = mDotsPaint;
        RADIUS = 20;
        DISTANCE = 100;
    }

    protected void draw(){
        switch (randomNumber){
            case 1: dotOne();
                break;
            case 2: dotTwo();
                break;
            case 3: dotThree();
                break;
            case 4: dotFour();
                break;
            case 5: dotFive();
                break;
            case 6: dotSix();
                break;
        }
    }

    private void dotOne(){
        canvas.drawCircle(width / 2,height / 2, RADIUS, dotsPaint);
    }

    private void dotTwo(){
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
    }

    private void dotThree(){
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 , height / 2 , RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
    }

    private void dotFour(){
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);

    }

    private void dotFive(){
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 , height / 2 , RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
    }

    private void dotSix(){
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 - DISTANCE, height / 2, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 - DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 - DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2, RADIUS, dotsPaint);
        canvas.drawCircle(width / 2 + DISTANCE, height / 2 + DISTANCE, RADIUS, dotsPaint);
    }

}
