package com.example.mayni.askreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button btn_mark;
    private Button btn_samhee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_mark = (Button) findViewById(R.id.btn_mark);
        btn_samhee = (Button) findViewById(R.id.btn_samhee);
    }

    public void onClick (View v){
        if (v == btn_mark){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }if (v == btn_samhee){
            Intent i = new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(i);
        }
    }

}
