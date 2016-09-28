package com.example.kajsaffranzen.projje;

import android.content.Context;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kajsaffranzen.projje.PasswordForm.PasswordForm;
import com.example.kajsaffranzen.projje.PasswordForm.PasswordListener;
import com.example.kajsaffranzen.projje.StepsLeft.StepActivity;
import com.example.kajsaffranzen.projje.StepsLeft.StepsLeft;
import com.example.kajsaffranzen.projje.StepsLeft.StepsListener;

/**
 * CreateForm
 * There is one bool for each content, if they should be use or not
 * The init() functions creates a table where the results from the
 * contetns are drawn.
 */
public class CreateForm extends TableLayout {

    Context context;
    Button btn;
    int currentStep;
    public TextView name;

    PasswordForm passwordForm;
    StepsLeft stepsLeft;
    StepActivity step1, step2, step3;

    //default constructor
    public CreateForm(Context con){
        super(con);
        context = con;
        stepsLeft = new StepsLeft(context);

        setUpView();
    }

    public CreateForm(Context con, boolean usePasswordForm){
        super(con);
        context = con;
        if(usePasswordForm) passwordForm = new PasswordForm(context);

        setUpView();
    }

    public CreateForm(Context con, boolean usePasswordForm, boolean useStepsForm){
        super(con);
        context = con;

        if(usePasswordForm){
            passwordForm = new PasswordForm(context);
            passwordForm.setPasswordListener(new PasswordListener() {
                @Override
                public void passwordUpdate(int n) {
                    System.out.println("The password has been changed!");
                }
            });
        }

        if(useStepsForm){
            stepsLeft = new StepsLeft(context);
            stepsLeft.setStepListener(new StepsListener() {
                @Override
                public void stepUpdate(int n) {
                    System.out.println("The step has been changed!");
                }
            });

            step1 = new StepActivity(context, 1);
            stepsLeft.addStep(step1);

            step2 = new StepActivity(context, 2);
            stepsLeft.addStep(step2);

            step3 = new StepActivity(context, 3);
            stepsLeft.addStep(step3);

            currentStep = stepsLeft.getCurrentStep();

        }


        setUpView();
    }

    private void setUpView(){

        btn = new Button(context);
        btn.setText("Next step");

        this.removeAllViews();
        this.addView(passwordForm);
        //stepsLeft.addStep(passwordForm);

        this.addView(stepsLeft.getVisualization());

        if(currentStep < stepsLeft.getListLength()){
            this.addView(stepsLeft.setStep(currentStep));
            this.addView(btn);
        }
        else{
            TextView txt = new TextView(context);
            txt.setText("You'r done!");
            this.addView(txt);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStep++;
                stepsLeft.updateVisualization(currentStep);
                setUpView();
            }
        });
    }
}
