package com.example.android.audioplayer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeet on 22-03-2017.
 */

public class sqlconnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Audio.db";
    public static final int DATABASE_VERSION = 1;
    public sqlconnection(Context cxt)
    {
super(cxt,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

String query = "create table "+audiocontract.audiodata.TABLE_NAME+" ( "
                +audiocontract.audiodata.COLUMN_ID+" integer primary key  , "+audiocontract.audiodata.COLUMN_PATH+" text not null , "+audiocontract.audiodata.COLUMN_TITLE+" text , "+audiocontract.audiodata.COLUMN_ARTIST+" text , "+audiocontract.audiodata.COLUMN_ALBUM+" text );";

sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
