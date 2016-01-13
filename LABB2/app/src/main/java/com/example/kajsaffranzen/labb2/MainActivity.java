package com.example.kajsaffranzen.labb2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Brightness> brightList = new ArrayList<Brightness>();
    private MyListAdapter listAdapter;
    private ExpandableListView myList;

    private EditText txt;
    int index = 0;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display the list
        loadData();

        //get reference to the ExpandableListView
        myList = (ExpandableListView) findViewById(R.id.myList);

        //create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(MainActivity.this, brightList);

        //attach the adapter to the list
        myList.setAdapter(listAdapter);

        //textView
        txt = (EditText) findViewById(R.id.txtField);

        //expand all groups
         expandAll();

        //add TextWatcher listener
         txt.addTextChangedListener((TextWatcher) wordWatcher);

        //listener for child row click
         myList.setOnChildClickListener(myListItemClicked);

        //listener for group heading click
        myList.setOnGroupClickListener(myListGroupClicked);

    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            myList.expandGroup(i);
        }
    }


    private void loadData() {

        ArrayList<Color> colorList = new ArrayList<Color>();
        Color color = new Color("green");
        colorList.add(color);
        color = new Color("blue");
        colorList.add(color);
        color = new Color("yellow");
        colorList.add(color);

        Brightness brightness = new Brightness("light", colorList);
        brightList.add(brightness);

        colorList = new ArrayList<Color>();
        color = new Color("green");
        colorList.add(color);
        color = new Color("blue");
        colorList.add(color);
        color = new Color("yellow");
        colorList.add(color);

        brightness = new Brightness("medium",colorList);
        brightList.add(brightness);

        colorList = new ArrayList<Color>();
        color = new Color("green");
        colorList.add(color);
        color = new Color("orange");
        colorList.add(color);
        color = new Color("yellow");
        colorList.add(color);

        brightness = new Brightness("dark",colorList);
        brightList.add(brightness);

    }

    //our child listener
    private ExpandableListView.OnChildClickListener myListItemClicked =  new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {

            click = true;

            //get the group header
            Brightness brightInfo = brightList.get(groupPosition);
            //get the child info
            Color colorInfo = brightInfo.getColorList().get(childPosition);

            txt.setText("/" + brightInfo.getName() + "/" + colorInfo.getName());
            int index = parent.getFlatListPosition(
                    ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
            parent.setItemChecked(index, true);

            return false;
        }
    };

    //our group listener
    private ExpandableListView.OnGroupClickListener myListGroupClicked =  new ExpandableListView.OnGroupClickListener() {

        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {

            click = true;

            //get the group header
            Brightness brightInfo = brightList.get(groupPosition);
            txt.setText("/"+ brightInfo.getName());

            return false;
        }

    };


    private final TextWatcher wordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            txt.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            String inputTxt = txt.getText().toString().toLowerCase();

            String brightString = inputTxt;
            String colorString = "";
            int groupPosition;
            int count = 0;
            int countB = 0;

            expandAll();

            //fel, kolla en bool typ, om checkText = true;
            System.out.println("click: " + click);
            if (click == true){
                click = false;
                return;
            }

            //check if the text contains a /
            if(inputTxt.contains("/") && inputTxt.length() > 1){
                String[] separated = inputTxt.split("/");

                if (inputTxt.startsWith("/")) {
                    brightString = separated[1];
                    colorString = "";

                    if (separated.length > 2) {
                        brightString = separated[1];
                        colorString = separated[2];
                    }
                } else {
                    if (separated.length > 1) {
                        brightString = separated[0];
                        colorString = separated[1];
                    } else {
                        brightString = separated[0];
                        colorString = "";
                    }
                }
            }

            //System.out.println("brString: " + brightString);
            //System.out.println("colString: " + colorString);

            //check the header
            for(int i= 0; i < listAdapter.getGroupCount(); i++){

                //get the group header
                Brightness headerInfo = brightList.get(i);

                if(headerInfo.getName().startsWith(brightString)){

                    groupPosition = brightList.indexOf(headerInfo);
                    txt.setBackgroundColor(android.graphics.Color.WHITE);
                    countB = 1;

                    //loop through the children
                    for(int j=0; j < headerInfo.getColorList().size(); j++){

                        //get the child info
                        Color childInfo = headerInfo.getColorList().get(j);

                        if(childInfo.getName().startsWith(colorString) && colorString.length() > 0){

                            //expand other groups
                            collapseAll(groupPosition);
                            count = 1;

                            //check if the whole word is typed
                            if(colorString.contains(childInfo.getName()) ){

                                index = myList.getFlatListPosition(
                                        ExpandableListView.getPackedPositionForChild(i,j));
                                myList.setItemChecked(index, true);
                            }
                        }
                    }

                    if(count == 0 && colorString.length() > 0){
                        txt.setBackgroundColor(android.graphics.Color.RED);
                        myList.setItemChecked(index, false);
                        return;
                    }
                }
                if(countB == 0 && brightString.length() > 0){
                     if(brightString.startsWith("/")) txt.setBackgroundColor(android.graphics.Color.WHITE);
                     else txt.setBackgroundColor(android.graphics.Color.RED);
                }
            }
        }
    };

    //method to collapse all groups
    private void collapseAll(int skip) {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            if(i != skip) myList.collapseGroup(i);
        }
    }
}
