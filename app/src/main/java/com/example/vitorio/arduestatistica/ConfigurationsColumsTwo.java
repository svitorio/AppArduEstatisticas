package com.example.vitorio.arduestatistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

public class ConfigurationsColumsTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations_colums_two);
        Intent intent = getIntent();
        int colums = Integer.parseInt(intent.getStringExtra("number"));
        Spinner[] sppiners= new Spinner[8];
        EditText[] nomecolums= new EditText[8];

        TableRow[] tableRow= new TableRow[8];
        tableRow[0]=findViewById(R.id.tbr1);
        tableRow[1]=findViewById(R.id.tbr2);
        tableRow[2]=findViewById(R.id.tbr3);
        tableRow[3]=findViewById(R.id.tbr4);
        tableRow[4]=findViewById(R.id.tbr5);
        tableRow[5]=findViewById(R.id.tbr6);
        tableRow[6]=findViewById(R.id.tbr7);
        tableRow[7]=findViewById(R.id.tbr8);

        sppiners[0] = findViewById(R.id.spnType1);
        sppiners[1] = findViewById(R.id.spnType2);
        sppiners[2] = findViewById(R.id.spnType3);
        sppiners[3] = findViewById(R.id.spnType4);
        sppiners[4] = findViewById(R.id.spnType5);
        sppiners[5] = findViewById(R.id.spnType6);
        sppiners[6] = findViewById(R.id.spnType7);
        sppiners[7] = findViewById(R.id.spnType8);
       // sppiners[1].setVisibility(View.VISIBLE);
        for (int i=0;i<colums;i++){
            tableRow[i].setVisibility(View.VISIBLE);
        }
        //TextView txtnumber = (TextView)findViewById(R.id.txtNumber);
        //txtnumber.setText(""+colums);
    }
}
