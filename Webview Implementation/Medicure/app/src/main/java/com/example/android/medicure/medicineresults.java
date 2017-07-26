package com.example.android.medicure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class medicineresults extends AppCompatActivity {
    WebView wb;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicineresults);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent in = getIntent();

pb = (ProgressBar) findViewById(R.id.pbcontent);
        String q = in.getStringExtra("url");
        wb = (WebView) findViewById(R.id.webview);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient()

                            {

                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    super.onPageFinished(view, url);
                                    pb.setVisibility(View.INVISIBLE);
                                }
                            }
        );
        wb.loadUrl(q);


    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        wb.destroy();
    }
}
