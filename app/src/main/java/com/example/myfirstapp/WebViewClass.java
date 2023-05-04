package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClass extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_class);

        webView = findViewById(R.id.webView);
        String url = "https://www.tiktok.com/en/";

        //pre-loader setting section
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading content from "+url);

        webView.loadUrl(url);

        //TO SET THINGS THAT WE FUNCTION IN THE APP LIKE JAVASCRIPT AND ZOOMING
        WebSettings seetings = webView.getSettings();
        seetings.setJavaScriptEnabled(true);
        seetings.setDisplayZoomControls(true);


        //FOR THE REP-LOADING SECTION
        webView.setWebViewClient(new WebViewClient(){
            ///crl + o to bering out the override

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                pd.show();

                if(!url.startsWith(url)){
                    return;
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                pd.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });


    }
}