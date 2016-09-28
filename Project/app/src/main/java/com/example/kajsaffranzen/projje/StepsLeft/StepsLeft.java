package com.example.kajsaffranzen.projje.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kajsaffranzen.projje.PasswordForm.DrawPasswordComponents;
import com.example.kajsaffranzen.projje.PasswordForm.PasswordListener;

import java.util.ArrayList;

/**
 * StepsLeft activity
 * the creatForm functions adds
 * each step to the view
 */
public class StepsLeft extends TableLayout {

    Context context;
    StepActivity step;
    DrawSteps draw;
    StepsListener listener;
    public int listLength = 3, currentStep = 1;
    ArrayList<View> views = new ArrayList<View>(listLength);

    public StepsLeft(Context con){
        super(con);
        context = con;
        draw = new DrawSteps(context);
    }

    /**gets the current step*/
    public int getCurrentStep(){
        return currentStep;
    }

    /**gets the lenght of the list*/
    public int getListLength() { return listLength;}

    public void setStepListener(StepsListener sl) { listener = sl; }

    /**add a step to the view*/
    public void addStep(StepActivity sa){
        views.add(sa);
    }

    /**set the step to be shown*/
    public View setStep(int currentStep){
        return views.get(currentStep);
    }

    public View getVisualization(){
        return this.draw;
    }

    /**updates the visualization*/
    public void updateVisualization(int current){
        listener.stepUpdate(current);
        draw.updateStep(current);
    }

}
