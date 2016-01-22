package com.example.kajsaffranzen.projje.PasswordForm;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kajsaffranzen.projje.CreateForm;

/**
 * PasswordForm is a class that checks if a typed in
 * password is good or bad with a
 * passwordAlgorithm-class and a class that
 * visualize the strength of it.
 */
public class PasswordForm extends TableLayout{

    Context context;
    public TextView password;
    public EditText passwordTxt;
    public int strength;
    private int checklevel = 0;


    private PasswordAlgorithm passwordAlgorithm;
    private DrawPasswordComponents drawPasswordComponents;
    private PasswordListener listener;

    /**Defaul constructor*/
    public PasswordForm(Context con){
        super(con);
        context = con;
        passwordAlgorithm = new PasswordAlgorithm();
        drawPasswordComponents = new DrawPasswordComponents(context);

        init();
        passwordTxt.addTextChangedListener(watcher);
    }

    public PasswordForm(Context con, PasswordAlgorithm passAlg){
        super(con);
        context = con;
        passwordAlgorithm = passAlg;
        drawPasswordComponents = new DrawPasswordComponents(context);

        init();
        passwordTxt.addTextChangedListener(watcher);
    }

    public PasswordForm(Context con, PasswordAlgorithm passAlg, DrawPasswordComponents drawPass, boolean inputP){
        super(con);
        context = con;
        passwordAlgorithm = passAlg;
        drawPasswordComponents = drawPass;

        init();
        passwordTxt.addTextChangedListener(watcher);
    }

    public void setPasswordListener(PasswordListener pl){
        listener = pl;
    }

    /**Inizialises the textfield for the password*/
    private void init(){

        TableRow tableRow = new TableRow(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels - metrics.widthPixels/2;

        password = new TextView(context);
        password.setText("Password");
        passwordTxt = new EditText(context);
        passwordTxt.setWidth(width);
        passwordTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        tableRow.addView(password);
        tableRow.addView(passwordTxt);
        tableRow.addView(drawPasswordComponents);
        this.addView(tableRow);
    }

    /**Textwatcher connected to the textfield
     * the input is connected to passwordAlgorithm to check the strength of it
     * the strength is then passed on to DrawPasswordComponent*/
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {

            String input = passwordTxt.getText().toString();
            strength = passwordAlgorithm.CheckStrength(input);

            if(strength != checklevel){
                listener.passwordUpdate(strength);
                checklevel = strength;
            }
            drawPasswordComponents.upDate(strength);
        }

    };

}
