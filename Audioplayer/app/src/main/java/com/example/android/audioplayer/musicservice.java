package com.example.android.audioplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.fontometrics.Fontometrics;

import java.util.concurrent.TimeUnit;

import static com.example.android.audioplayer.songfrag.index;
import static com.example.android.audioplayer.songfrag.urarr;


public class musicservice extends Service  implements  SeekBar.OnSeekBarChangeListener{
   static MediaPlayer mp1 ;
   static boolean ison = false;
   static ImageButton play;
    Uri ur = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Songs/Bollywood/Baadal.mp3");
   static SeekBar sb;
  public static TextView txt1,txt2;
   private static Handler myh = new Handler();
   private static MainActivity  MAIN_ACTIVITY;
   static boolean firsttime = true;
   @Override
   public void onCreate() {
      super.onCreate();
      play = (ImageButton) MAIN_ACTIVITY.findViewById(R.id.playbutton);
      sb = (SeekBar) MAIN_ACTIVITY.findViewById(R.id.seeky);
      sb.setOnSeekBarChangeListener(this);
      txt1 = (TextView) MAIN_ACTIVITY.findViewById(R.id.currenttime);
      txt2 = (TextView) MAIN_ACTIVITY.findViewById(R.id.remainingtime);
      txt1.setTypeface(Fontometrics.myepicselfie(this));
      txt2.setTypeface(Fontometrics.myepicselfie(this));
      mp1 = MediaPlayer.create(this,urarr[index]);





if (firsttime==false)
{
   ison = true;
   play.setImageResource(R.drawable.pauseit);
   mp1.start();
   sb.setMax(mp1.getDuration());
   sb.setProgress(mp1.getCurrentPosition());
   myh.postDelayed(rn,100);
}

      txt2.setText(String.format("%02d:%02d",
              java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long)mp1.getDuration()),
              java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds((long)mp1.getDuration())-
                      TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long)mp1.getDuration()))
      ));

      play.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            if (ison == true) {
               play.setImageResource(R.drawable.play2);
               ison = false;
               mp1.pause();
                    /*mp.pause();*/

            } else if (ison == false) {
               play.setImageResource(R.drawable.pauseit);
               ison = true;
               mp1.start();

               sb.setMax(mp1.getDuration());

            }

            sb.setProgress(mp1.getCurrentPosition());

            txt1.setText(String.format("%02d:%02d",
                    java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long) mp1.getCurrentPosition()),
                    java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds((long) mp1.getCurrentPosition()) -
                            TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long) mp1.getCurrentPosition()))
            ));


            myh.postDelayed(rn, 100);


         }
      });

   }

   @Override
   public void onDestroy() {
      /*super.onDestroy();*/
      releaseit();

   }


   private Runnable rn = new Runnable() {
      @Override
      public void run() {
         if (mp1!=null) {
            sb.setProgress(mp1.getCurrentPosition());
            myh.postDelayed(this, 100);
            txt1.setText(String.format("%02d:%02d",
                    java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long) mp1.getCurrentPosition()),
                    java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds((long) mp1.getCurrentPosition()) -
                            TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes((long) mp1.getCurrentPosition()))
            ));

            if (txt1.getText().equals(txt2.getText())) {
               mp1.seekTo(0);
               mp1.pause();
               play.setImageResource(R.drawable.play2);
               ison = false;
            }
         }
      }
   };


   @Nullable
   @Override
   public IBinder onBind(Intent intent) {
      return null;
   }


   public void releaseit()
   {
      if (mp1 != null) {
         mp1.release();

         mp1 = null;
         sb.setOnSeekBarChangeListener(null);
      }
   }

   public static void setMainActivity(MainActivity mainActivity)
   {
      MAIN_ACTIVITY=mainActivity;
   }


   @Override
   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
      if (fromUser) {
         mp1.seekTo(progress);
         sb.setProgress(progress);
      }
      }

   @Override
   public void onStartTrackingTouch(SeekBar seekBar) {

   }

   @Override
   public void onStopTrackingTouch(SeekBar seekBar) {

   }


}


