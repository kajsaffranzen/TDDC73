package com.example.kajsaffranzen.laboration3;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListPopupWindow;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by kajsaffranzen on 16-01-08.
 */
public class InteractiveSearcher extends EditText {

    Context context;
    int nrOfResult;
    private int searchId;
    ListPopupWindow popList;
    private HashMap<Integer, ArrayList<String>> searchMap;
    private ItemAdapter itemAdapter;
    HttpURLConnection urlConnection;
    boolean isClicked;

    public InteractiveSearcher(Context con) {
        super(con);
        context = con;
        init();
    }

    public void setnrOfResult(int nr) {
        nrOfResult = nr;
    }

    private void init() {
        searchId = 0;
        searchMap = new HashMap<Integer, ArrayList<String>>();

        this.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        popList = new ListPopupWindow(context);
        popList.setAnchorView(this);
        popList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isClicked = true;
                setText(itemAdapter.getItem(position).toString());
            }

        });



        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 0 || isClicked == true) {
                    popList.dismiss();
                    isClicked = false;
                } else new TestAsync().execute(s.toString());

            }
        });

    }

    private int parseJson(String theString){
        try {
            JSONObject jsonObj = new JSONObject(theString);
            JSONArray results = jsonObj.getJSONArray("result");

            ArrayList<String> names = new ArrayList<String>();

            if(results.length() == 0){
                names.add("sry, no names found");
                searchMap.put(searchId, names);
            }
            else{
                if(results.length() <= nrOfResult){
                    for(int i=0; i < results.length(); i++){
                        names.add(results.get(i).toString());
                    }
                    searchMap.put(searchId, names);
                }

                else{
                    for(int i=0; i < nrOfResult; i++){
                        names.add(results.get(i).toString());
                    }
                    searchMap.put(searchId, names);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return searchId;

    }
    public class TestAsync extends AsyncTask<String, Void, String> {


        protected String doInBackground(String... theSearchString) {
            String returnedText = "";

            try {
                URL url = new URL("http://flask-afteach.rhcloud.com/getnames/" + searchId++ + "/" + theSearchString[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                returnedText = readStream(in);
                urlConnection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return returnedText;

        }

        private String readStream(InputStream in){
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in), 1000);

            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    sb.append(line);
                }
                in.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        protected void onPostExecute(String res){

            //parse json data
            int theId = parseJson(res);

            //check if the json returns the last search
            if(theId == searchId){
                //update the list with names from the web and then display them
                itemAdapter = new ItemAdapter(context, searchMap.get(searchId));
                popList.setAdapter(itemAdapter);
                popList.show();


            }
        }

    }

}
