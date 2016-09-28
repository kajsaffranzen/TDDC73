package com.example.kajsaffranzen.laboration3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearlayout = new LinearLayout(this);
        InteractiveSearcher interactiveSearcher = new InteractiveSearcher(this);
        interactiveSearcher.setnrOfResult(4);

        linearlayout.addView(interactiveSearcher);
        setContentView(linearlayout);
        //setContentView(R.layout.activity_main);
    }
}
