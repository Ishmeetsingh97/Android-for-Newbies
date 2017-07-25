package com.example.android.audioplayer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

import static com.example.android.audioplayer.songfrag.urarr;

//import android.support.annotation.RequiresApi;

//@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends AppCompatActivity {
    boolean likeit = false;
    static  boolean backnforth=false;
    private ImageView like;
    static boolean servicestarted = false;


    @Override
    public void onBackPressed() {
        Intent in = new Intent(this,listactivity.class);
        startActivity(in);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Slide sl = new Slide();

        sl.addTarget(R.id.viewpager);

        sl.setInterpolator(AnimationUtils.loadInterpolator(this,android.R.interpolator.accelerate_decelerate));

        sl.setDuration(300);

        getWindow().setEnterTransition(sl);
*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setElevation(0);



like = (ImageView) findViewById(R.id.likedis);


        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

        fragadapter fg = new fragadapter(getSupportFragmentManager(),MainActivity.this);


        vp.setAdapter(fg);

        TabLayout tb = (TabLayout) findViewById(R.id.tabs);

        tb.setupWithViewPager(vp);




        musicservice.setMainActivity(MainActivity.this);










    }










    public void like(View v)
    {
        if (likeit==false) {
            like.setImageResource(R.drawable.heart);
            likeit=true;
        }

        else {
            like.setImageResource(R.drawable.dislike);
            likeit=false;
        }
    }

    public void sendit(View v)
    {
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("audio/mp3");
        send.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(urarr[0].toString())));
        if (send.resolveActivity(MainActivity.this.getPackageManager())!=null)
            startActivity(Intent.createChooser(send,"Send To.."));
    }


    public  void songlists(View v)
    {



        Intent in = new Intent(this,listactivity.class);
        startActivity(in);



    }



}

