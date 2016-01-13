package com.example.kajsaffranzen.labb2;

import java.util.ArrayList;

/**
 * Created by kajsaffranzen on 15-12-03.
 */
public class Brightness {

    private String name;
    private ArrayList<Color> colorList = new ArrayList<Color>();

    public Brightness(String name, ArrayList<Color> colorList) {
        super();
        this.name = name;
        this.colorList = colorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Color> getColorList() {
        return colorList;
    }

    public void setColorList(ArrayList<Color> colorList){
        this.colorList = colorList;
    }
}

