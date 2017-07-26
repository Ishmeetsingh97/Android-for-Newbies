package com.example.android.medicure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {
EditText hfeet,hinch,wt;

    TextView res;
    Button submit;
    String tresult;
    int ft,in,weight;
    double height,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
 hfeet = (EditText) findViewById(R.id.hf);
        hinch = (EditText) findViewById(R.id.hin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        wt = (EditText) findViewById(R.id.weight);
        submit = (Button) findViewById(R.id.findbmi);
        res = (TextView) findViewById(R.id.bmiresult);


 submit.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {






         if ((!(hfeet.getText().toString().equals(""))) && (!(hinch.getText().toString().equals(""))) && (!(wt.getText().toString().equals("")))) {





             ft = Integer.parseInt(hfeet.getText().toString());
             in = Integer.parseInt(hinch.getText().toString());

             height = (((ft * 12) + in) * 2.54) / 100;
             Log.v("yugoygib;ju", "" + height);
             weight = Integer.parseInt(wt.getText().toString());
             result = weight / (height * height);

             tresult = "Your Body Mass Index is : " + String.format("%.1f", result);


             res.setText(tresult);
             res.setTextColor(getResources().getColor(R.color.colorPrimary));
         }

         else
         {


             res.setText("Please enter all the details");
             res.setTextColor(getResources().getColor(android.R.color.holo_red_light));
         }
     }
 });
    }




}
