package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {

    private static final String NAME ="Shelter2.db";
    private static final int VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_PETS_TABLE =
                "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + "( " + PetContract.PetEntry._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PetContract.PetEntry.COLUMN_PET_NAME
                + " TEXT NOT NULL, " + PetContract.PetEntry.COLUMN_PET_BREED
                + " TEXT, " + PetContract.PetEntry.COLUMN_PET_GENDER + " TEXT NOT NULL, "
                + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";


            sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
