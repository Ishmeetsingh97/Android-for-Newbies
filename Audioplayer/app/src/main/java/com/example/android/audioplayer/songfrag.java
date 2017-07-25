package com.example.android.audioplayer;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.audioplayer.data.audiocontract;
import com.example.android.audioplayer.data.sqlconnection;
import com.example.fontometrics.Fontometrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.example.android.audioplayer.MainActivity.servicestarted;
import static com.example.android.audioplayer.R.id.trackartist;
import static com.example.android.audioplayer.listactivity.itemclicked;
import static com.example.android.audioplayer.listactivity.pos;
import static com.example.android.audioplayer.musicservice.firsttime;

/**
 * A simple {@link Fragment} subclass.
 */
public class songfrag extends Fragment {
    private MediaMetadataRetriever mmd = new MediaMetadataRetriever();
    private MediaMetadataRetriever mmd1 = new MediaMetadataRetriever();
    private static byte[] art;
    ImageView img2;
    static Uri urarr[];
    String songname;
    private File myfl = new File(Environment.getExternalStorageDirectory().getPath() + "/Songs/");
    static TextView trackinfo,trackartist1;
    List<String> givefile;
    ImageButton forward,backward ;
    Bitmap btm;
    private sqlconnection sc;
    ProgressBar pb;
    static int index = 0;
static int count = 0;

    public songfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vw =inflater.inflate(R.layout.frag_song, container, false);


            img2 = (ImageView) vw.findViewById(R.id.songimg);
        sc = new sqlconnection(getActivity());
            trackinfo = (TextView) getActivity().findViewById(R.id.trackinfo);
            trackartist1 = (TextView) getActivity().findViewById(trackartist);
            pb = (ProgressBar) vw.findViewById(R.id.progressbar);
            asyncit as = new asyncit();

            as.execute();

        return vw;
    }

    public void updateUi()
    {
        forward =(ImageButton) getActivity().findViewById(R.id.forwardbutton);
        backward = (ImageButton) getActivity().findViewById(R.id.backwardbutton);
        pb.setVisibility(View.INVISIBLE);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index != urarr.length - 1) {
                    index++;
                    getActivity().stopService(new Intent(getActivity(), musicservice.class));
                    firsttime = false;
                    getActivity().startService(new Intent(getActivity(), musicservice.class));
                    setproperties();

                }
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index != 0) {
                    index--;
                    getActivity().stopService(new Intent(getActivity(), musicservice.class));
                    firsttime = false;
                    getActivity().startService(new Intent(getActivity(), musicservice.class));
                    setproperties();
                }
            }
        });

        if (pos!=10000&&pos!=index&&itemclicked==true)
        {
            getActivity().stopService(new Intent(getActivity(),musicservice.class));
            itemclicked=false;
            firsttime=false;
            index = pos;

        }

        if (servicestarted==false) {
            getActivity().startService(new Intent(getActivity(),musicservice.class));
            servicestarted=true;

        }




        setproperties();
    }
/*
    private void getnoti()
    {
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(getActivity())
                .setShowWhen(false)
                // Set the Notification style
                .setStyle(new NotificationCompat.MediaStyle()
                        // Attach our MediaSession token
                        // Show our playback controls in the compact notification view.
                        .setShowActionsInCompactView(0, 1, 2))
                // Set the Notification color
                .setColor(getResources().getColor(R.color.colorPrimary))
                // Set the large and small icons
                .setLargeIcon(btm)
                .setSmallIcon(android.R.drawable.stat_sys_headset)
                // Set Notification content information
                .setContentTitle(songname)
                // Add playback actions
                .addAction(android.R.drawable.ic_media_previous, "previous", )
                .addAction(notificationAction, "pause", play_pauseAction)
                .addAction(android.R.drawable.ic_media_next, "next", playbackAction(2));

        ((NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE)).notify(2, notificationBuilder.build());
    }
*/
    public void setproperties()
    {


        mmd.setDataSource(urarr[index].toString());

        songname = mmd
                .extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        String songdet = mmd
                .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)+" | "+mmd
                .extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        if (mmd.getEmbeddedPicture()==null)
        {
            img2.setImageResource(R.drawable.musicicon);
            if (songname==null)
                trackinfo.setText("Unknown");

            if (songdet.contains("null"))
                trackartist1.setText("Unknown | Unknown");
            return;
        }
        art =  mmd.getEmbeddedPicture();
        btm = BitmapFactory.decodeByteArray(art,0,art.length);


        if (art!=null)
        {
            img2.setImageBitmap(btm);

        }

        trackinfo.setText(songname);
        trackartist1.setText(songdet);

    }





    private class asyncit extends AsyncTask
    {



        @Override
        protected Object doInBackground(Object[] objects) {
            if (pos==10000&&count==0) {

                givefile = getListFiles(myfl);

                urarr = new Uri[givefile.size()];
                for (int i = 0; i < givefile.size(); i++) {
                    urarr[i] = Uri.parse(givefile.get(i));

                }

/*
                for (int i = 0; i < urarr.length; i++) {
                    mmd.setDataSource(urarr[i].toString());

                    passit.add(new listitems(mmd.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE), mmd.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST) + " | " + mmd.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)));
                }
*/
                Log.v("euwfbpuwebfpuweh","ewuigfbp9ywegf97ewgqufpe");

                count++;

            }

            return null;
        }

        @Override
        protected void onPreExecute() {

            if (count==0) {
                trackinfo.setText("Loading...");
                trackartist1.setText("Loading...");
                trackinfo.setTypeface(Fontometrics.myepicselfie(getActivity()));
                trackartist1.setTypeface(Fontometrics.myepicselfie(getActivity()));
                pb.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getActivity(), R.color.mainorange), android.graphics.PorterDuff.Mode.SRC_ATOP);
            }

        }


        @Override
        protected void onPostExecute(Object o) {
            updateUi();
        }


        public List<String> getListFiles(File parentDir) {
            ArrayList<String> inFiles = new ArrayList<String>();
            String selection = MediaStore.Audio.Media.IS_MUSIC ;
            ContentResolver cr = getContext().getContentResolver();

            Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

            Cursor cs = null;
            try {

                cs = cr.query(uri,null,selection,null,MediaStore.Audio.Media.TITLE+" ASC");
                SQLiteDatabase sq = sc.getReadableDatabase();

                String[] projection = new String[] {
                        audiocontract.audiodata.COLUMN_PATH
                };
                Cursor cs1 = sq.query(audiocontract.audiodata.TABLE_NAME,projection,null,null,null,null,null);
                Log.v("ewiufiuwefguowehf;ou",""+cs1.getCount()+" "+cs.getCount());
                while (cs!=null&&cs.moveToNext()&&cs.getCount()-1!=cs1.getCount())
                {
String path = cs.getString(cs.getColumnIndex(MediaStore.Audio.Media.DATA));
                    int id = cs.getInt(cs.getColumnIndex(MediaStore.Audio.Media._ID));


try {

Uri uripath = Uri.parse(path);

    mmd1.setDataSource(getActivity(),uripath);


    ContentValues cv = new ContentValues();
cv.put(audiocontract.audiodata.COLUMN_TITLE,mmd1.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
    cv.put(audiocontract.audiodata.COLUMN_ARTIST,mmd1.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
    cv.put(audiocontract.audiodata.COLUMN_ALBUM,mmd1.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
    cv.put(audiocontract.audiodata.COLUMN_PATH, path);

    cv.put(audiocontract.audiodata.COLUMN_ID, id);
    sq.insertOrThrow(audiocontract.audiodata.TABLE_NAME, null, cv);
}

catch (Exception e)
{
    e.printStackTrace();
}




                }
                cs.close();
                cs1.close();
              Cursor  mycs = sq.query(audiocontract.audiodata.TABLE_NAME,projection,null,null,null,null,null);

                int pathindex = mycs.getColumnIndex(audiocontract.audiodata.COLUMN_PATH);

                while(mycs.moveToNext())
                {
                    inFiles.add(mycs.getString(pathindex));
                }



            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            Log.v("jbvwirjv","rljbg;iwu4gu   "+inFiles.size());
                return inFiles;
        }



    }

}
