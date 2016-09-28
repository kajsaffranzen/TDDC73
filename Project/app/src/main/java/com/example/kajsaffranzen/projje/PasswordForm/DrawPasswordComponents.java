package com.example.kajsaffranzen.projje.PasswordForm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * DrawPasswordComponents
 * the class gets the strength of an password (an int)
 * that is visualized in form of a circle which color
 * depends on the strength
 */
public class DrawPasswordComponents extends View {
    private int strengthPassword;
    Context context;

    /**default constructor*/
    public DrawPasswordComponents(Context con){
        super(con);
        context = con;
    }

    public void upDate(int strength){
        strengthPassword = strength;
        invalidate();
    }

    /**The color of the circle depends on the in strengthPassword*/
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();

        if(strengthPassword == 3) paint.setColor(Color.GREEN);
        else if(strengthPassword ==2 ) paint.setColor(Color.YELLOW);
        else paint.setColor(Color.RED);

        canvas.drawCircle(50, 50, 50, paint);
        //x,y, raid
    }

    @Override
    protected void onMeasure(int widthM, int heightM){
        //sets the dimensions for the items
        //super.onMeasure(widthM, heightM);
        setMeasuredDimension(1000, 100);
    }
}
