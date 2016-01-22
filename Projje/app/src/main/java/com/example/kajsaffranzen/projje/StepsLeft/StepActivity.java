package com.example.kajsaffranzen.projje.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kajsaffranzen.projje.CreateForm;
import com.example.kajsaffranzen.projje.PasswordForm.PasswordForm;

/**
 * StepActivit class
 *Creates a list of view to be shown in each step
 *
 */
public class StepActivity extends TableLayout {
    
    Context context;
    int currentStep = 0;


   public StepActivity(Context con, int n){
       super(con);
       context = con;
       createView(n);
   }

    public void setCurrentStep(int current){
        currentStep = current;
    }

    public int getCurrentStep(){
        return currentStep;
    }

    /**Default view*/
    public void createView(int n){
        getCurrentStep();
        currentStep = n;

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels - metrics.widthPixels / 2;

        TableRow tableRow = new TableRow(context);

        TextView nameView = new TextView(context);
        nameView.setText("Name");
        EditText nameText = new EditText(context);
        nameText.setWidth(width);

        tableRow.addView(nameView);
        tableRow.addView(nameText);

        this.addView(tableRow);
    }


}
