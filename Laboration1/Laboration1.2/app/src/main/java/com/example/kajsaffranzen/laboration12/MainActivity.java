package com.example.kajsaffranzen.laboration12;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txtName = new TextView(this);
        txtName.setText("Namn");

        TextView txtPass = new TextView(this);
        txtPass.setText("Lösenord");

        TextView txtEmail = new TextView(this);
        txtEmail.setText("Epost");

        TextView txtAge = new TextView(this);
        txtAge.setText("Ålder");

        EditText name = new EditText(this);
        EditText password = new EditText(this);
        password.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        
        EditText email = new EditText(this);
        password.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
        SeekBar seekBar = new SeekBar(this);


        txtName.setId(1);
        txtPass.setId(2);
        txtEmail.setId(3);
        txtAge.setId(4);
        name.setId(5);
        password.setId(6);
        email.setId(7);

        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams txtNameParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams nameParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams txtPassParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams passParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams txtEmailParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams emailParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams txtAgeParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        RelativeLayout.LayoutParams ageParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        txtNameParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        txtNameParams.setMargins(0, 25, 0, 0);

        nameParams.addRule(RelativeLayout.END_OF, txtName.getId());
        nameParams.setMargins(70, 0, 0, 0);

        txtPassParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        txtPassParams.addRule(RelativeLayout.BELOW, txtName.getId());
        txtPassParams.setMargins(0, 40, 0, 0);

        passParams.addRule(RelativeLayout.END_OF, txtPass.getId());
        passParams.addRule(RelativeLayout.BELOW, name.getId());

        txtEmailParams.addRule(RelativeLayout.BELOW, password.getId());
        txtEmailParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        txtEmailParams.setMargins(0, 30, 0, 0);

        emailParams.addRule(RelativeLayout.BELOW, password.getId());
        emailParams.addRule(RelativeLayout.END_OF, txtEmail.getId());
        emailParams.setMargins(70, 0, 0, 0);

        txtAgeParams.addRule(RelativeLayout.BELOW, txtEmail.getId());
        txtAgeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        txtAgeParams.setMargins(0, 35, 0, 0);

        ageParams.addRule(RelativeLayout.BELOW, email.getId());
        ageParams.addRule(RelativeLayout.END_OF, txtAge.getId());
        ageParams.setMargins(65, 10, 0, 0);


        myLayout.addView(txtName, txtNameParams);
        myLayout.addView(name, nameParams);
        myLayout.addView(txtPass, txtPassParams);
        myLayout.addView(password, passParams);
        myLayout.addView(txtEmail, txtEmailParams);
        myLayout.addView(email, emailParams);
        myLayout.addView(txtAge, txtAgeParams);
        myLayout.addView(seekBar, ageParams);

        setContentView(myLayout);

        //setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
