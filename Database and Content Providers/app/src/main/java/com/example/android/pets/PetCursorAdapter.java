package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view.findViewById(R.id.name);
        TextView breed = (TextView) view.findViewById(R.id.breed);

        int name = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedr = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String petName = cursor.getString(name);
        String petBreed = cursor.getString(breedr);

        tv.setText(petName);
        breed.setText(petBreed);
    }
}