package com.example.android.medicure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fontometrics.Fontometrics;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private Toolbar tb;
   private  TextView txt;
  private  DrawerLayout dl;
    RelativeLayout rl;
    RelativeLayout rl2;
    RelativeLayout rl3;
    RelativeLayout rl4;
    NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setSupportActionBar(tb);
        getSupportActionBar().setTitle(null);
        nv.setItemIconTintList(null);
        nv.getMenu().getItem(0).setChecked(true);
        nv.setNavigationItemSelectedListener(this);

        rl = (RelativeLayout) findViewById(R.id.galleryclick);
        rl2 = (RelativeLayout) findViewById(R.id.cameraclick);
        rl3 = (RelativeLayout) findViewById(R.id.filemanagerclick);
        rl4 = (RelativeLayout) findViewById(R.id.cloudclick);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in  = new Intent(MainActivity.this,medicine.class);
                in.putExtra("identity","medicine");
                startActivity(in);
            }
        });

        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in  = new Intent(MainActivity.this,medicine.class);
                in.putExtra("identity","disease");
                startActivity(in);
            }


        });

        rl3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<lat>,<long>?q=<Doctors>"));
        startActivity(intent);
    }
});

        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in  = new Intent(MainActivity.this,fresult.class);
                startActivity(in);
            }
        });

        ActionBarDrawerToggle actw = new ActionBarDrawerToggle(this,dl,tb,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        dl.addDrawerListener(actw);
        actw.syncState();
    }



    private void init()
    {
        tb = (Toolbar) findViewById(R.id.app_bar);
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);

        txt = (TextView) findViewById(R.id.tbtxt);
        txt.setTypeface(Fontometrics.myepicselfie(MainActivity.this));
        nv = (NavigationView) findViewById(R.id.nav_view);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent in;
        switch(id)
        {
            case R.id.bmi:
                in = new Intent(this,bmiActivity.class);
                startActivity(in);
                break;

            case R.id.home:
                break;


            case R.id.hnews:
                in = new Intent(this,healthnews.class);
                startActivity(in);
                break;
        }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}
