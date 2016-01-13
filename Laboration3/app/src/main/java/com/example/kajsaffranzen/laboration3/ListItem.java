package com.example.kajsaffranzen.laboration3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by kajsaffranzen on 16-01-08.
 */
public class ListItem extends View {
    private String item;
    Paint paint;
    public ListItem(Context con, String theItem)
    {
        super(con);
        item = theItem;
        init();
    }

    public void init()
    {
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        if (item == "No results found")
            paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.FILL);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawText(item, 10, 50, paint);

    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(600, 100); //would like to match width to length of text, not sure how to do that
    }
}
