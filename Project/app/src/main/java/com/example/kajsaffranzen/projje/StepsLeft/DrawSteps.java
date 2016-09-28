package com.example.kajsaffranzen.projje.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.TableLayout;

/**
 *DrawStep containts the visualization in form
 * of a progressbar
 */
public class DrawSteps extends TableLayout {

    Context context;
    ProgressBar progressBar;
    int nrOfSteps = 3, start = 1;

    public DrawSteps(Context con){
        super(con);
        context = con;

        draw();
    }

    public void updateStep(int n){
        progressBar.setProgress(n++);
    }

    public void draw(){
        /**progressbar*/
        progressBar = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(nrOfSteps);
        progressBar.setProgress(start);
        progressBar.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

        this.addView(progressBar);

    }
}
