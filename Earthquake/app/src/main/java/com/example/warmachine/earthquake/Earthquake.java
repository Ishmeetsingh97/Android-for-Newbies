package com.example.warmachine.earthquake;


public class Earthquake {

    private String mmagnitude;
    private String mlocation;
    private String mdate;

    public Earthquake(String magnitude, String location, String Date)
    {
        mmagnitude=magnitude;
        mlocation=location;
        mdate=Date;
    }

    public String getMagnitude()
    {
        return mmagnitude;
    }

    public String getLocation()
    {
        return mlocation;
    }

    public String getDate()
    {
        return mdate;
    }
}
