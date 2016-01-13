package com.example.kajsaffranzen.labb2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kajsaffranzen on 15-12-03.
 */
public class MyListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Brightness> brightList;
    private ArrayList<Brightness> originalList;

    public MyListAdapter(Context context, ArrayList<Brightness> brightList) {
        this.context = context;
        this.brightList= new ArrayList<Brightness>();
        this.brightList.addAll(brightList);
        this.originalList = new ArrayList<Brightness>();
        this.originalList.addAll(brightList);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Color> colorList = brightList.get(groupPosition).getColorList();
        return colorList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Color color = (Color) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child, null);
        }

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(color.getName().trim());

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<Color> colorList = brightList.get(groupPosition).getColorList();
        return brightList.size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return brightList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return brightList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Brightness brightness = (Brightness) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(brightness.getName().trim());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){

        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(brightList.size()));
        brightList.clear();

        if(query.isEmpty()){
            brightList.addAll(originalList);
        }
        else {

            for(Brightness brightness: originalList){

                ArrayList<Color> colorList = brightness.getColorList();
                ArrayList<Color> newList = new ArrayList<Color>();
                for(Color color: colorList){
                   /* if(color.getCode().toLowerCase().contains(query) ||
                            color.getName().toLowerCase().contains(query)){
                        newList.add(color);
                    }*/
                }
                /*if(newList.size() > 0){
                    Brightness nBrightness = new Brightness(Brightness.getName(), newList);
                    brightList.add(nBrightness);
                }*/
            }
        }

        Log.v("MyListAdapter", String.valueOf(brightList.size()));
        notifyDataSetChanged();

    }

}
