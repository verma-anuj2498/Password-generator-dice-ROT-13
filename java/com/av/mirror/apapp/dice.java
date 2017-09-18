package com.av.mirror.apapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.RunnableFuture;
import java.util.logging.Handler;

public class dice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dice");
        final TextView tv=(TextView)findViewById(R.id.dicenumber);
        Button generatenumber=(Button)findViewById(R.id.rolldice);
        final Random ran= new Random();
        final android.os.Handler handler=new android.os.Handler();

        final ProgressBar spinner=(ProgressBar)findViewById(R.id.spinner);
        generatenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(" ");
               int x= ran.nextInt(6)+1;
               final String y= Integer.toString(x);
                spinner.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spinner.setVisibility(View.INVISIBLE);
                        tv.setText(y);
                    }
                },600);
            }

        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dice.super.onBackPressed();
            }
        });
    }

}
