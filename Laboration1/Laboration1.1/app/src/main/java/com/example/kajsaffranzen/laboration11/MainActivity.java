 package com.example.kajsaffranzen.laboration11;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btn = new Button(this);
        btn.setText("KNAPP");

        EditText txt1 = new EditText(this);
        RatingBar ratingBar = new RatingBar(this);
        EditText txt2 = new EditText(this);

        btn.setId(1);
        txt1.setId(2);

        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams btnParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams txt1Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams barParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams txt2Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT
                );

        btnParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        txt1Params.addRule(RelativeLayout.BELOW, btn.getId());

        barParams.addRule(RelativeLayout.BELOW, txt1.getId());
        barParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        txt2Params.addRule(RelativeLayout.BELOW, ratingBar.getId());

        myLayout.addView(btn, btnParams);
        myLayout.addView(txt1, txt1Params);
        myLayout.addView(ratingBar, barParams);
        myLayout.addView(txt2, txt2Params);

        setContentView(myLayout);
        //setContentView(R.layout.activity_main);
    }

}
