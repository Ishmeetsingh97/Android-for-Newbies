package com.example.warmachine.earthquake;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, List<Earthquake> androidFlavors) {
        super(context, 0, androidFlavors);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Earthquake androidFlavor = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.textinfo, parent, false);
        }
    TextView magnitude = (TextView) convertView.findViewById(R.id.tvv1);
    magnitude.setText(androidFlavor.getMagnitude());

    TextView Location = (TextView) convertView.findViewById(R.id.tvv2);
    Location.setText(androidFlavor.getLocation());

    TextView Date = (TextView) convertView.findViewById(R.id.tvv3);
    Date.setText(androidFlavor.getDate());

        return convertView;
    }


}

