package com.example.warmachine.earthquake;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EarthquakeAdapter ea = null;
    String jsonResponse="";
    String STRING_URL="http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView) findViewById(R.id.lv1);
        ea = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
        lv.setAdapter(ea);

        EarthquakeAsynctask eaa = new EarthquakeAsynctask();
        eaa.execute();

    }


    public class EarthquakeAsynctask extends AsyncTask<URL,Void,List<Earthquake>>
    {
        @Override
        protected void onPostExecute(List<Earthquake> earthquakes) {
            ea.addAll(earthquakes);
            super.onPostExecute(earthquakes);
        }

        @Override
        protected List<Earthquake> doInBackground(URL... urls) {

            URL url = QueryUtils.createUrl(STRING_URL);
            try {
                jsonResponse = QueryUtils.makeHttpRequest(url);
            }catch(Exception e){

            }

            List<Earthquake> earthquakes = QueryUtils.jsonParse(jsonResponse);
            return earthquakes;
        }
    }

}
