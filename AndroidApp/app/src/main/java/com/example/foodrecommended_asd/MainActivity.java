package com.example.foodrecommended_asd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // This code below is to add the html file into the app
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build()); // ignores URI


        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);



        final WebView browser=(WebView)view.findViewById(R.id.webView);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);


        browser.addJavascriptInterface(new WebAppInterface(this), "Android");

        browser.loadUrl("file:///android_asset/index.html");// The code above is the html file added into the app.





        /*
        if(browser.getUrl() == "file:///android_asset/signup.html"){
            if(retriever.data == "pass" || retriever.data == "pass-repeat"){
                if(account.checkPassword(retriever.data, retriever2.data) == true){
                    browser.loadData("<html><body> &#9989</body></html>", "text/html", "UTF-8");
                    account.setAccountInfo(retriever.data, retriever2.data);
                }
                else{
                    browser.loadData("<html><body> &#10060</body></html>", "text/html", "UTF-8");

                }

            }
            else{
                browser.loadData("<html><body>YOU SUCK</body></html>", "text/html", "UTF-8");
            }
        }
        else{
            browser.loadData("&#10060","text/html", "UTF-8");
        }
        */


        } // End of MainActivity

    public class WebAppInterface {
        Context mContext;
        String data;

        WebAppInterface(Context ctx){
            this.mContext=ctx;
        }


        @JavascriptInterface
        public void sendData(String data) {
            //Get the string value to process
            this.data=data;
        }
    }

    }


