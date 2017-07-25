package com.example.android.audioplayer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jeet on 08-12-2016.
 */

public class fragadapter extends FragmentPagerAdapter {
    Context ct;

    public fragadapter(FragmentManager fm,Context ct) {
        super(fm);
        this.ct = ct;
    }

    @Override
    public Fragment getItem(int position) {

        if (position==0)
            return  new songfrag();

        else if (position==1)
            return new detailfrag();

        else
            return new lyricsfrag();

    }

    @Override
    public int getCount() {
        return 3;
    }


}
