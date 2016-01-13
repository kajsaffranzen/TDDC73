package com.example.kajsaffranzen.laboration3;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by kajsaffranzen on 16-01-08.
 */
public class ItemAdapter extends BaseAdapter {
    private List<String> items;
    Context context;

    public ItemAdapter(Context con, List<String> theItems)
    {
        context = con;
        items = theItems;
    }
    @Override
    public int getCount()
    {
        if (items == null) // will give an exception otherwise when deleting all text
            return 0;

        return items.size();
    }
    @Override
    public View getView(int i, View v, ViewGroup viewGroup)
    {
        return new ListItem(context, items.get(i));
    }
    @Override
    public long getItemId(int position)
    {
        return 0; // ?
    }

    @Override
    public Object getItem(int position)
    {
        return items.get(position);
    }
}
