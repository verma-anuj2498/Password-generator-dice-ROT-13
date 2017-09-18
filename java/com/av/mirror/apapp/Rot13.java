package com.av.mirror.apapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Rot13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot13);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("ROT 13");
        final StringBuilder sb=new StringBuilder();
        final EditText entertext=(EditText)findViewById(R.id.rotenter);
        final TextView rotfinaltext=(TextView)findViewById(R.id.rottext);
        final Button  click=(Button)findViewById(R.id.convertbutton);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String input =entertext.getText().toString();
                for(int  i = 0 ; i < input.length() ;i++){
                    char c = input.charAt(i);
                    if       (c >= 'a' && c <= 'm') c += 13;
                    else if  (c >= 'A' && c <= 'M') c += 13;
                    else if  (c >= 'n' && c <= 'z') c -= 13;
                    else if  (c >= 'N' && c <= 'Z') c -= 13;
                    sb.append(c);
                }
                String output=sb.toString();
                rotfinaltext.setText(output);
                InputMethodManager inputManager = (InputMethodManager)getSystemService(Rot13.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(click.getWindowToken(),0);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Rot13.super.onBackPressed();
            }
        });
    }

}
