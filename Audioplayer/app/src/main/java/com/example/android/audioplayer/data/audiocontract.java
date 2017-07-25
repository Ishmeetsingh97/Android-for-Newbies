package com.example.android.audioplayer.data;

import android.provider.BaseColumns;

/**
 * Created by Jeet on 22-03-2017.
 */

public final class audiocontract {


    private audiocontract(){}

    public static abstract  class audiodata implements BaseColumns
    {
        public final static String TABLE_NAME = "Songs";
        public final static String COLUMN_PATH = "path";
        public final static String COLUMN_TITLE = "title";
        public final static String COLUMN_ARTIST = "artist";
        public final static String COLUMN_ALBUM = "album";
        public final static String COLUMN_ID = "id";
    }
}
