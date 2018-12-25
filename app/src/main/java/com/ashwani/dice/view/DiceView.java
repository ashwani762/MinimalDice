package com.ashwani.dice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DiceView extends View {

    private Paint mText;
    private Paint mDotsPaint;

    private String messageShake = "SHAKE THE PHONE";
    private String messageTap = "OR TAP ON THE SCREEN";

    private int randomNumber;
    private Random random;

    private Dots dots;

    public DiceView(Context context) {
        super(context);
        init(null);
    }

    public DiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

        //Background Color
        setBackgroundColor(Color.parseColor("#232a3d"));

        //For Random number generation
        random = new Random();

        if(set == null)
            return;

        //For the Dots
        mDotsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDotsPaint.setColor(Color.parseColor("#fe5b6f"));

        //For the Bottom Message
        mText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mText.setColor(Color.WHITE);
        mText.setTypeface(Typeface.SANS_SERIF);
        mText.setTextSize(30f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        //For the Dots
        dots = new Dots(canvas, randomNumber, width, height, mDotsPaint);
        dots.draw();

        // For the Bottom Message
        float messageShakeWidth = mText.measureText(messageShake);
        float messageTapWidth = mText.measureText(messageTap);

        canvas.drawText(messageShake,(width / 2) - (messageShakeWidth / 2),height - height / 6, mText);
        canvas.drawText(messageTap,(width / 2) - (messageTapWidth / 2),(height - height / 6) + 50, mText);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int eventAction = event.getAction();

        switch (eventAction){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                generateRandom();
                break;
        }

        invalidate();

        return true;
    }

    private void generateRandom(){
        randomNumber = random.nextInt(6) + 1;
    }
}
