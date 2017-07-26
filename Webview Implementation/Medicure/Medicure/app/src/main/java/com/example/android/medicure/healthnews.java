package com.example.android.medicure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class healthnews extends AppCompatActivity {
    WebView wb;
    String url = "http://timesofindia.indiatimes.com/life-style/health-fitness";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthnews);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        wb = (WebView) findViewById(R.id.webview);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient()

                            {

                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    super.onPageFinished(view, url);

                                }
                            }
        );
        wb.loadUrl(url);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wb.destroy();
    }
}
