package com.example.android.audioplayer;


public class listitems {

    private String songname;
    private String details;

public listitems()
{

}
    public listitems(String songname,String details)
    {
        this.songname = songname;
        this.details = details;
    }


    public String getSongname()
    {
        if (songname==null)
            songname = "Unknown";
        return songname;
    }

    public String getDetails()
    {


        if (details.contains("null"))
            details = "Unknown | Unknown";
        return details;
    }


}
