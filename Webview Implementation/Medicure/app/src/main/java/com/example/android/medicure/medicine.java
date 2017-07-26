package com.example.android.medicure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class  medicine extends AppCompatActivity {
EditText ed;
    String st;
    TextView tv;
    TextView tv1;
    String ourl = "https://www.drugs.com/";
    String dis = "https://www.merriam-webster.com/dictionary/";
    Button bt;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        ed = (EditText) findViewById(R.id.medicine);
        bt = (Button) findViewById(R.id.medsub);
        tv = (TextView) findViewById(R.id.searchtext);
        tv1 = (TextView) findViewById(R.id.error);
         in = getIntent();
        if (in.getStringExtra("identity").equals("disease")) {
         getSupportActionBar().setTitle("Search Diseases");
            tv.setText("-:Enter the name of Disease:-");
            tv1.setText("Please enter the name of disease!!");
        }

        else if (in.getStringExtra("identity").equals("medicine"))
        {
            getSupportActionBar().setTitle("Search Medicines");
            tv.setText("-:Enter the name of Medicine:-");
            tv1.setText("Please enter the name of medicine!!");
        }



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                st = ed.getText().toString();

                if (!st.equals("")) {

                    if (tv1.getVisibility()==View.VISIBLE)
                        tv1.setVisibility(View.INVISIBLE);
                    if (in.getStringExtra("identity").equals("disease")) {

                        st = dis + st;
                    } else if (in.getStringExtra("identity").equals("medicine")) {
                        st = ourl + st + ".html";
                    }
                    if (!st.equals(null)) {


                        Intent in1 = new Intent(medicine.this, medicineresults.class);
                        in1.putExtra("url", st);
                        startActivity(in1);

                    }

                }

                else
                {
                    tv1.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}
