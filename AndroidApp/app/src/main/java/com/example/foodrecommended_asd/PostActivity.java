package com.example.foodrecommended_asd;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
This is the class handles grabbing the restaurant (/Rest) data from the database. This class can be
used as a template for creating classes that grab data from other parts of the database. However,
a Class for the objects made from the json and an API will have to be created. Both class (Rest) and
the interface (RestaurantAPI) can be refferenced templates to acheive this.

NOTE: Even though the browser URL for the database is 127.0.0.1, android studio cannot access the
database from this address, instead use 10.0.2.2 as the base URL.

REQUIRED DEPENDENCIES FOR build.gradle
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
*/


public class PostActivity extends AppCompatActivity {

    //ifFail is a text variable that displays an error message if the data base isn't accessed and
    //alerts why. Consider changing the method of displaying this error message to alerts with
    //javascript.
    //TextView ifFail = findViewById(R.id.text_view_result);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RestaurantAPI restaurantAPI;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //initalizing the RetrofitAPI that read converts the json file into java variables.
        restaurantAPI = retrofit.create(RestaurantAPI.class);

        List<Rest> restVect = new ArrayList<Rest>();
        getPosts(restaurantAPI);
    }

    public void getPosts(RestaurantAPI restaurantAPI) {
        Call<List<Rest>> call = restaurantAPI.getPosts();

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {

                //Error block if the database is accessed, but runs into a problem once accessed
                if (!response.isSuccessful()) {
                    //ifFail.setText("code: " + response.code());
                    return;
                }


                List<Rest> rests = response.body();


                //This for loop runs though the entire json file and saves the elements into as varibles
                //of a rest object. These rest objects are being stored into a vector that can be
                //accessed later.
                for (Rest rest : rests) {
                    restVector.add(new Rest(rest.getId(), rest.getRestName(), rest.getBanner(),
                            rest.getZipcode(), rest.getRestRating(), rest.getWebsite(),
                            rest.getPhone(), rest.getRestPrice(), rest.getCategory()));
                }
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t,) {
                //ifFail.setText(t.getMessage());
            }
        });
    }

    public void getRestZipCat(RestaurantAPI restaurantAPI, int zip, int cat) {

        Call<List<Rest>> call = restaurantAPI.getRestZipCat(zip, cat);

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {

                //Error block if the database is accessed, but runs into a problem once accessed
                if (!response.isSuccessful()) {
                    //ifFail.setText("code: " + response.code());
                    return;
                }


                List<Rest> rests = response.body();
                Vector<Rest> restVector = new Vector<Rest>();

                //This for loop runs though the entire json file and saves the elements into as varibles
                //of a rest object. These rest objects are being stored into a vector that can be
                //accessed later.
                for (Rest rest : rests) {
                    restVector.add(new Rest(rest.getId(), rest.getRestName(), rest.getBanner(),
                            rest.getZipcode(), rest.getRestRating(), rest.getWebsite(),
                            rest.getPhone(), rest.getRestPrice(), rest.getCategory()));


                }


            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {
                //ifFail.setText(t.getMessage());
            }


        });
    }
}
