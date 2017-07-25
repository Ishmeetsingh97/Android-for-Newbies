package com.example.android.audioplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fontometrics.Fontometrics;

import java.util.ArrayList;

/**
 * Created by Jeet on 02-12-2016.
 */

public class customadapter extends ArrayAdapter{
Activity act;
    ArrayList<listitems> arl;

public customadapter(Activity act,ArrayList<listitems> arl)
{
    super(act,R.layout.listitemlayout,arl);
    this.act = act;
    this.arl = arl;
}
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemad = convertView;

        listitems ls =(listitems) getItem(position);

        listitemad = LayoutInflater.from(getContext()).inflate(R.layout.listitemlayout,parent,false);
        TextView tv1 = (TextView) listitemad.findViewById(R.id.listsongname);
tv1.setTypeface(Fontometrics.myepicselfie(act));
        TextView tv2 = (TextView) listitemad.findViewById(R.id.listsongdetails);
        tv2.setTypeface(Fontometrics.myepicselfie(act));
        tv1.setText(ls.getSongname());
        tv2.setText(ls.getDetails());

        return listitemad;
    }
}
