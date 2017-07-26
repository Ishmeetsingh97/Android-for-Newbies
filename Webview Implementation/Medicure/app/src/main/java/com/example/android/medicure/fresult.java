package com.example.android.medicure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class fresult extends AppCompatActivity {

    EditText name,disease,allergy,sugar,blood,hemoglobin,bone;
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresult);

        name=(EditText)findViewById(R.id.name);
        disease=(EditText)findViewById(R.id.disease);
        allergy=(EditText)findViewById(R.id.allergy);
        sugar=(EditText)findViewById(R.id.sugar);
        blood=(EditText)findViewById(R.id.blood);
        bone=(EditText)findViewById(R.id.bone);
        hemoglobin=(EditText)findViewById(R.id.hemoglobin);
        check=(Button)findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetterSetter.getinstance().setName(name.getText().toString());
                GetterSetter.getinstance().setDisease(disease.getText().toString());
                GetterSetter.getinstance().setAllergy(allergy.getText().toString());
                GetterSetter.getinstance().setSugar(sugar.getText().toString());;
                GetterSetter.getinstance().setBlood(blood.getText().toString());
                GetterSetter.getinstance().setHemoglobin(hemoglobin.getText().toString());
                GetterSetter.getinstance().setBone(bone.getText().toString());

                if(Integer.parseInt(sugar.getText().toString())<108&&Integer.parseInt(sugar.getText().toString())>72){
                    GetterSetter.getinstance().setChecksugar("Your Sugar Level is Normal");
                }
                else{
                    GetterSetter.getinstance().setChecksugar("Your Sugar Level is abnormal");
                }

                if(Integer.parseInt(blood.getText().toString())<140&&Integer.parseInt(blood.getText().toString())>120){
                    GetterSetter.getinstance().setCheckblood("Your Blood Pressure is Normal");
                }
                else{
                    GetterSetter.getinstance().setCheckblood("Your Blood Pressure is abnormal");
                }

                if(Integer.parseInt(hemoglobin.getText().toString())<17&&Integer.parseInt(hemoglobin.getText().toString())>13){
                    GetterSetter.getinstance().setCheckHemoglobin("Your Hemoglobin Level is Normal");
                }
                else{
                    GetterSetter.getinstance().setCheckHemoglobin("Your Hemoglobin Level is abnormal");
                }

                Intent i=new Intent(fresult.this,Main2Activity.class);
                startActivity(i);
            }
        });

    }
}
