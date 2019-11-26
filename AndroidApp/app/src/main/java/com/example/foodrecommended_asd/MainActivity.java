package com.example.foodrecommended_asd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private FoodAPI foodAPI;
    private WebView testRest;

    //temp objects
    private List<Rest> tempRestList;
    private User tempUser;
    private List<Item> tempItemList;
    private List<Rating> tempRatingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        foodAPI = retrofit.create(FoodAPI.class);

        //getRest();
        getRestZip(48201);
        //createRest("Jet's Pizza", 48201, "https://www.jetspizza.com/", 3132977000.0, 0);
        //getUserID("test@gmail.com");
        //createUser("jonsmith2@gmail.com", "p@ssw0rd", "jonsmith2");
        //getItemRest(2);
        //createItem("Tonkotsu Ramen", "Pork, Noodle, and Green Onion", 4, 11.95);
        //getRatingRest(2);
        //creatRating("root@gmail.com", 2, "Too Salty for me", 3);

        List<Rest> testObj;
        testObj = getRest();

        /*


        // This code below is to add the html file into the app
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build()); // ignores URI

        // Creating a javascript object to pass through the .addJavaScriptInterface
        JavaInter javaInterObj = new JavaInter(this);
        AccountSignup exAccount = new AccountSignup();
        Restaurant exRestaurant = new Restaurant();
        */
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        // The browser is what's used to view the webView
        final WebView browser=(WebView)view.findViewById(R.id.webView);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enableing Javascript

        browser.loadUrl("file:///android_asset/menu.html");// The code above is the html file added into the app.
        browser.getSettings().setJavaScriptEnabled(true);

        //browser.addJavascriptInterface(javaInterObj, "Android");
        //browser.addJavascriptInterface(exAccount, "AccountMethods");
        //browser.addJavascriptInterface(exRestaurant, "Restaurant");


        //we need to fix that
        //browser.addJavascriptInterface(testObj, "stupidObj");


        // Color for background #3498db

    } // End of MainActivity

    @JavascriptInterface
    public List<Rest> getRest() {
        Call<List<Rest>> call = foodAPI.getRests();

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                tempRestList = response.body();
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {

            }
        });

        return tempRestList;
    }

    @JavascriptInterface
    public List<Rest> getRestZip(int zip) {
        Call<List<Rest>> call = foodAPI.getRestZip(zip);

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                tempRestList = response.body();

            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {

            }
        });
        return tempRestList;
    }

    private void createRest(String restName, int zipcode, String website, long phone, int category) {
        Rest rest = new Rest(restName, zipcode, website, phone, category);

        Call<Rest> call = foodAPI.createRest(rest);

        call.enqueue(new Callback<Rest>() {
            @Override
            public void onResponse(Call<Rest> call, Response<Rest> response) {
                if (!response.isSuccessful()) {
                    return;
                }

            }

            @Override
            public void onFailure(Call<Rest> call, Throwable t) {

            }
        });
    }

    private User getUserID(String userEmail) {
        Call call = foodAPI.getUserID(userEmail);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {

                    return;
                }

                tempUser = response.body();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return tempUser;
    }

    private void createUser(String userEmail, String password, String name) {
        User user = new User(userEmail, password, name);

        Call<User> call = foodAPI.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {

                    return;
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private List<Item> getItemRest(int id) {
        Call<List<Item>> call = foodAPI.getItemRest(id);

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (!response.isSuccessful()) {
                    return;
                }

                tempItemList = response.body();

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
            }
        });

        return tempItemList;
    }

    public void createItem(String itemName, String description, int restId, double itemPrice) {
        Item item = new Item(itemName, description, restId, itemPrice);

        Call<Item> call = foodAPI.createItem(item);

        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (!response.isSuccessful()) {
                    return;
                }

            }


            @Override
            public void onFailure(Call<Item> call, Throwable t) {
            }
        });
    }

    public List<Rating> getRatingRest(int id) {
        Call<List<Rating>> call = foodAPI.getRatingRest(id);

        call.enqueue(new Callback<List<Rating>>() {
            @Override
            public void onResponse(Call<List<Rating>> call, Response<List<Rating>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                tempRatingList = response.body();
            }

            @Override
            public void onFailure(Call<List<Rating>> call, Throwable t) {

            }
        });

        return tempRatingList;
    }

    public void creatRating(String userEmail, int restId, String review, int ratingNum) {
        Rating rating = new Rating(userEmail, restId, review, ratingNum);

        Call<Rating> call = foodAPI.createRating(rating);

        call.enqueue(new Callback<Rating>() {
            @Override
            public void onResponse(Call<Rating> call, Response<Rating> response) {
                if (!response.isSuccessful()) {
                    return;
                }

            }

            @Override
            public void onFailure(Call<Rating> call, Throwable t) {
            }
        });


    }


    /*

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

    */

}


