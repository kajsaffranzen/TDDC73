package com.example.kajsaffranzen.labb13;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txtLiu = new TextView(this);
        txtLiu.setId(1);
        txtLiu.setText("Hur trivs du på Liu?");

        CheckBox oneBox = new CheckBox(this);
        oneBox.setId(2);
        oneBox.setText("Bra");

        CheckBox twoBox = new CheckBox(this);
        //twoBox.setId(3);
        twoBox.setText("Mycket bra");

        CheckBox boxThree = new CheckBox(this);
        boxThree.setText("Jättebra");

        TextView txtLith = new TextView(this);
        txtLith.setText("Läser du på LiTH?");
        txtLith.setId(3);

        CheckBox yesBox = new CheckBox(this);
        yesBox.setText("Ja");
        yesBox.setId(4);

        CheckBox noBox = new CheckBox(this);
        noBox.setText("Nej");
        noBox.setId(5);

        ImageView myImg = new ImageView(this);
        myImg.setImageResource(R.drawable.liu2);
        myImg.setId(6);
        //myImg.setAdjustViewBounds(true);

        TextView logo = new TextView(this);
        logo.setText("Är detta LiUs logotyp?");
        logo.setId(7);

        CheckBox yesBox2 = new CheckBox(this);
        yesBox2.setText("Ja");
        yesBox2.setId(8);

        CheckBox noBox2 = new CheckBox(this);
        noBox2.setText("Nej");

        Button sendBtn = new Button(this);
        sendBtn.setText("SKICKA IN");

        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams liuParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        liuParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams boxParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        boxParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        boxParams.addRule(RelativeLayout.BELOW, txtLiu.getId());

        RelativeLayout.LayoutParams box2Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);


        box2Params.addRule(RelativeLayout.BELOW, txtLiu.getId());
        box2Params.addRule(RelativeLayout.CENTER_HORIZONTAL);


        RelativeLayout.LayoutParams box3Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        box3Params.addRule(RelativeLayout.BELOW, txtLiu.getId());
        box3Params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);


        RelativeLayout.LayoutParams lithParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        lithParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lithParams.addRule(RelativeLayout.BELOW, oneBox.getId());
        lithParams.setMargins(0, 10, 0, 0);

        RelativeLayout.LayoutParams yesParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        yesParams.addRule(RelativeLayout.BELOW, txtLith.getId());
        yesParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams noParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        noParams.addRule(RelativeLayout.BELOW, txtLith.getId());
        noParams.addRule(RelativeLayout.END_OF, yesBox.getId());

        RelativeLayout.LayoutParams imgParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        imgParams.addRule(RelativeLayout.BELOW, yesBox.getId());
        imgParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams logoParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        logoParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        logoParams.addRule(RelativeLayout.BELOW, myImg.getId());

        RelativeLayout.LayoutParams yes2Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        yes2Params.addRule(RelativeLayout.BELOW, logo.getId());
        yes2Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        RelativeLayout.LayoutParams no2Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        no2Params.addRule(RelativeLayout.BELOW, logo.getId());
        no2Params.addRule(RelativeLayout.END_OF, yesBox2.getId());

        RelativeLayout.LayoutParams btnParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        btnParams.addRule(RelativeLayout.BELOW, yesBox2.getId());


        myLayout.addView(txtLiu, liuParams);
        myLayout.addView(oneBox, boxParams);
        myLayout.addView(twoBox, box2Params);
        myLayout.addView(boxThree, box3Params);
        myLayout.addView(txtLith, lithParams);
        myLayout.addView(yesBox, yesParams);
        myLayout.addView(noBox, noParams);
        myLayout.addView(myImg, imgParams);
        myLayout.addView(logo, logoParams);
        myLayout.addView(yesBox2, yes2Params);
        myLayout.addView(noBox2, no2Params);
        myLayout.addView(sendBtn, btnParams);

        setContentView(myLayout);

    }
}
