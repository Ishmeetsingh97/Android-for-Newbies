package com.example.android.medicure;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class Main2Activity extends AppCompatActivity {

    TextView sugar,blood,hemoglobin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sugar=(TextView)findViewById(R.id.sugar);
        blood=(TextView)findViewById(R.id.blood);
        hemoglobin=(TextView)findViewById(R.id.hemoglobin);

        Blurry.with(Main2Activity.this)
                .radius(25)
                .sampling(1)
                .color(Color.argb(66, 255, 255, 0))
                .async();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        sugar.setText(GetterSetter.getinstance().getChecksugar());
        blood.setText(GetterSetter.getinstance().getCheckblood());
        hemoglobin.setText(GetterSetter.getinstance().getCheckHemoglobin());
    }

}
