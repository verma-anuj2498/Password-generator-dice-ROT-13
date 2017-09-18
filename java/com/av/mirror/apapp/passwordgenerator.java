package com.av.mirror.apapp;

import android.content.Intent;
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

public class passwordgenerator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordgenerator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Generate Password");
        setSupportActionBar(toolbar);

                 FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                 final EditText enter=(EditText)findViewById(R.id.entertextforpwd);
                 final TextView textView=(TextView)findViewById(R.id.generatedpwd);
                 final Button  button=(Button)findViewById(R.id.generate);
                 final String[] insert = {""};
                 final Button bt=(Button)findViewById(R.id.bt);
                 button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String stringtext=enter.getText().toString();
                 String finalstr="";
                 char[] ch={'!','@','#','$','%','&','*','(',')'};
                 for(int i=0;i<stringtext.length();i++){


                    if(i%2==0)   {
                        finalstr=finalstr+  Character.toUpperCase(stringtext.charAt(i));
                    }

                    else         {finalstr=finalstr+  Character.toLowerCase(stringtext.charAt(i));}


                }
                StringBuilder sb=new StringBuilder(finalstr);

                for(int i=0;i<finalstr.length();i++) {

                    sb.insert((i + 1) + i, ch[i%9]);
                    insert[0] = sb.toString();
                }
                insert[0] =  new StringBuilder(insert[0]).reverse().toString();
                textView.setText(insert[0]);
                InputMethodManager inputManager = (InputMethodManager)getSystemService(Rot13.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(button.getWindowToken(),0);
                bt.setVisibility(View.VISIBLE);
            }
        });

    textView.setOnClickListener(new View.OnClickListener() {
     @Override
        public void onClick(View v) {
        Intent in=new Intent(passwordgenerator.this,pwd.class);
        in.putExtra("tag",insert[0]);
        startActivity(in);
    }
});

        bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent in=new Intent(passwordgenerator.this,pwd.class);
                in.putExtra("tag",insert[0]);
                startActivity(in);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordgenerator.super.onBackPressed();
            }
        });
    }

}
