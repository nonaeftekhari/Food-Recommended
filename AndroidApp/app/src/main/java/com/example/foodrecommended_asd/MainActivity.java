package com.example.foodrecommended_asd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private WebView testRest;

    //temp objects


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitClass exchange = new RetrofitClass();
        Rest dataAccessor = new Rest();



        //getRest();
        //getRestZip(48201);
        //createRest("Jet's Pizza", 48201, "https://www.jetspizza.com/", 3132977000.0, 0);
        //getUserID("test@gmail.com");
        //createUser("jonsmith2@gmail.com", "p@ssw0rd", "jonsmith2");
        //getItemRest(2);
        //createItem("Tonkotsu Ramen", "Pork, Noodle, and Green Onion", 4, 11.95);
        //getRatingRest(2);
        //creatRating("root@gmail.com", 2, "Too Salty for me", 3);

        //List<Rest> testObj;
        //testObj = getRest();




        // This code below is to add the html file into the app
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build()); // ignores URI

        // Creating a javascript object to pass through the .addJavaScriptInterface
        JavaInter javaInterObj = new JavaInter(this);
        AccountSignup exAccount = new AccountSignup();
        Restaurant exRestaurant = new Restaurant();

        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        // The browser is what's used to view the webView
        final WebView browser=(WebView)view.findViewById(R.id.webView);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enableing Javascript

        browser.loadUrl("file:///android_asset/location.html");// The code above is the html file added into the app.
        browser.getSettings().setJavaScriptEnabled(true);

        browser.addJavascriptInterface(javaInterObj, "Android");
        browser.addJavascriptInterface(exAccount, "AccountMethods");
        browser.addJavascriptInterface(exRestaurant, "Restaurant");
        browser.addJavascriptInterface(exchange, "RetroExchange");
        browser.addJavascriptInterface(dataAccessor, "DataExchange");

        // Color for background #3498db

    } // End of MainActivity






    public class JavaInter{
        private String message;
        Context jContext;

        JavaInter(){ }

        JavaInter(Context c){
            jContext = c;
        }

        @JavascriptInterface // This will post a toast, and take you to the GPS
        public void showLocation() {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        }

        @JavascriptInterface
        public void showMessage(String msg) {
            this.message = msg;
            Toast.makeText(jContext, msg, Toast.LENGTH_LONG).show(); // This is a toast!
        }


        @JavascriptInterface // This will return the zip code into the form
        public String zipForm(){
            MapsActivity obj1 = new MapsActivity();
            return obj1.getZip();
        }

        @JavascriptInterface
        public void sendMessage(String msg){
            this.message = msg;
        }

        String getMessage(){
            return this.message;
        }

    }



}


