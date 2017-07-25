package com.example.android.audioplayer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.audioplayer.data.audiocontract;
import com.example.android.audioplayer.data.sqlconnection;

import java.util.ArrayList;

import static com.example.android.audioplayer.songfrag.index;



//import android.support.annotation.RequiresApi;

public class listactivity extends AppCompatActivity{
static int pos = 10000;
    private sqlconnection sc;
   static boolean listloaded = false;
    public static ArrayList<listitems> passit = new ArrayList<listitems>();
static  boolean itemclicked = false;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

  //  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);

        customadapter cm;
sc = new sqlconnection(this);
if (!listloaded) {
    SQLiteDatabase sq = sc.getReadableDatabase();


    String projection[] = new String[]
            {
                    audiocontract.audiodata.COLUMN_TITLE,
                    audiocontract.audiodata.COLUMN_ARTIST,
                    audiocontract.audiodata.COLUMN_ALBUM
            };

    Cursor csl = sq.query(audiocontract.audiodata.TABLE_NAME, projection, null, null, null, null, null);
    int titleindex = csl.getColumnIndex(audiocontract.audiodata.COLUMN_TITLE);
    int artistindex = csl.getColumnIndex(audiocontract.audiodata.COLUMN_ARTIST);
    int albumindex = csl.getColumnIndex(audiocontract.audiodata.COLUMN_ALBUM);
    while (csl.moveToNext()) {
        passit.add(new listitems(csl.getString(titleindex), csl.getString(artistindex) + " | " + csl.getString(albumindex)));

    }
    listloaded = true;
    csl.close();
}
        cm = new customadapter(this, passit);

        Toast.makeText(this,""+passit.size(),Toast.LENGTH_SHORT).show();


        ListView lv = (ListView) findViewById(R.id.songlistview);
        lv.setAdapter(cm);
lv.setFastScrollEnabled(true);
        lv.setTextFilterEnabled(true);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bn = ActivityOptions.makeSceneTransitionAnimation(listactivity.this).toBundle();



                pos = position;
itemclicked = true;
                if (pos!=index) {
                    MainActivity.servicestarted = false;
                    Intent ini = new Intent(listactivity.this, MainActivity.class);
                    startActivity(ini,bn);
                }
                else
                {
                    Intent openMainActivity= new Intent(listactivity.this, MainActivity.class);
                    openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(openMainActivity,bn);
                    finish();
                }
                }
        });

    }




    }


