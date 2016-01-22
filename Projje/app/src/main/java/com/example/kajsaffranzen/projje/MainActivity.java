package com.example.kajsaffranzen.projje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

/**
 * This program uses the PasswordForm and StepsLeft
 * to use the Booleans has to be set to true
 *
 */

public class MainActivity extends AppCompatActivity {

    CreateForm createForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TableLayout layout = new TableLayout(this);
        Boolean usePasswordForm = true;
        Boolean useStepsLeft = true;

        createForm = new CreateForm(this, usePasswordForm, useStepsLeft);

        layout.addView(createForm);
        setContentView(layout);
    }
}
