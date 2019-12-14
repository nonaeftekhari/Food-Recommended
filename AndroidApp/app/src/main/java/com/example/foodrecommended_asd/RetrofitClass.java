package com.example.foodrecommended_asd;

import android.util.Log;
import android.webkit.JavascriptInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClass {
    private List<Rest> tempRestList;
    private User tempUser;
    private List<Item> tempItemList;
    private List<Rating> tempRatingList;
    private List<RatingResponse> tempRatingResponse;
    private boolean tempBool;
    String password;
    String email;
    private boolean running = false;

    public List<com.example.foodrecommended_asd.Rest> getTempRestList() {
        return tempRestList;
    }

    public void setTempRestList(List<com.example.foodrecommended_asd.Rest> tempRestList) {
        this.tempRestList = tempRestList;
    }

    public com.example.foodrecommended_asd.User getTempUser() {
        return tempUser;
    }

    public void setTempUser(com.example.foodrecommended_asd.User tempUser) {
        this.tempUser = tempUser;
    }

    public List<com.example.foodrecommended_asd.Item> getTempItemList() {
        return tempItemList;
    }

    public void setTempItemList(List<com.example.foodrecommended_asd.Item> tempItemList) {
        this.tempItemList = tempItemList;
    }

    public List<com.example.foodrecommended_asd.Rating> getTempRatingList() {
        return tempRatingList;
    }

    public void setTempRatingList(List<com.example.foodrecommended_asd.Rating> tempRatingList) {
        this.tempRatingList = tempRatingList;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private FoodAPI foodAPI = retrofit.create(FoodAPI.class);

    //i think we need to move this
    //foodAPI = retrofit.create(FoodAPI.class);


    @JavascriptInterface
    public List<Rest> getRestZipCat(int zip, int cat) {
        tempRestList = null;
        running = false;
        Call<List<Rest>> call = foodAPI.getRestZipCat(zip, cat);

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if (!response.isSuccessful()) {
                    running = true;
                }else {
                    tempRestList = response.body();
                    running = true;
                }
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {
                running = true;
            }
        });
        while(0==0){
            if(running){
                break;
            }
        }
        return tempRestList;
    }


    @JavascriptInterface
    public void createRest(String restName, int zipcode, String website, Long phone, int category) {
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

    @JavascriptInterface
    public void createUser(String userEmail, String password, String name) {
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

    @JavascriptInterface
    public List<Item> getItemRest(int id) {
        tempRestList = null;
        running = false;
        Call<List<Item>> call = foodAPI.getItemRest(id);

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (!response.isSuccessful()) {
                    running = true;
                }

                tempItemList = response.body();
                running = true;

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                running = true;
            }
        });
        while(0==0) {
            if (running) {
                break;
            }
        }
        return tempItemList;
    }

    @JavascriptInterface
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

    @JavascriptInterface
    public List<Rating> getRatingRest(int id) {
        tempRestList = null;
        running = false;

        Call<List<Rating>> call = foodAPI.getRatingRest(id);

        call.enqueue(new Callback<List<Rating>>() {
            @Override
            public void onResponse(Call<List<Rating>> call, Response<List<Rating>> response) {
                if (!response.isSuccessful()) {
                    running = true;
                }
                tempRatingList = response.body();
                running = true;
            }

            @Override
            public void onFailure(Call<List<Rating>> call, Throwable t) {
                running = true;
            }
        });
        while(0==0) {
            if (running) {
                break;
            }
        }
        return tempRatingList;
    }

    @JavascriptInterface
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

    @JavascriptInterface
    public void creatRatingResponse(int id, String response) {
        RatingResponse ratingResponse = new RatingResponse(id, response);

        Call<RatingResponse> call = foodAPI.createRatingResponse(ratingResponse);

        call.enqueue(new Callback<RatingResponse>() {
            @Override
            public void onResponse(Call<RatingResponse> call, Response<RatingResponse> response) {
                if (!response.isSuccessful()) {
                    return;
                }

            }

            @Override
            public void onFailure(Call<RatingResponse> call, Throwable t) {

            }
        });
    }

    @JavascriptInterface
    public List<RatingResponse> getRatingResponse(int id){
        tempRatingList = null;
        running = false;

        Call<List<RatingResponse>> call = foodAPI.getRatingResponseId(id);

        call.enqueue(new Callback<List<RatingResponse>>() {
            @Override
            public void onResponse(Call<List<RatingResponse>> call, Response<List<RatingResponse>> response) {
                if (!response.isSuccessful()) {
                    running = true;
                }
                tempRatingResponse = response.body();
                running = true;

            }

            @Override
            public void onFailure(Call<List<RatingResponse>> call, Throwable t) {
                running = true;
            }
        });
        while(0==0) {
            if (running) {
                break;
            }
        }
        return tempRatingResponse;
    }

    @JavascriptInterface
    public boolean checkUser(String pk){
        tempBool = false;
        running = false;

        Call<User> call = foodAPI.getUserID(pk);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    running = true;
                }else{
                    tempBool = true;
                    running = true;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                running = true;
            }
        });
        while(0==0) {
            if (running) {
                break;
            }
        }
        return tempBool;
    }

    @JavascriptInterface
    public boolean Authenticate(final String email1, String pass) {
        email = email1;
        password = pass;
        tempBool = false;
        running = false;
        Call<User> call = foodAPI.getUserID(email);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {

                    running = true;
                }else{
                    User user = response.body();
                    String userEmailTemp = user.getPassword();
                    if(!userEmailTemp.equals(password)){
                        running = true;
                    }else{
                        tempBool = true;
                        running = true;
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                running = true;
            }
        });


        while(0==0){
            if(running){
                break;
            }
        }
        return tempBool;

    }

    @JavascriptInterface
    public int getRestListLeng(){
        return tempRestList.size();
    }

    @JavascriptInterface
    public String getRestName(int i){
        return tempRestList.get(i).getRestName();
    }

    @JavascriptInterface
    public String getBanner(int i){
        return tempRestList.get(i).getBanner();
    }

    @JavascriptInterface
    public double getRating(int i){
        return tempRestList.get(i).getRestRating();
    }

    @JavascriptInterface
    public double getRestaurantPrice(int i){
        return tempRestList.get(i).getRestPrice();
    }

    @JavascriptInterface
    public String getWebsite(int i){
        return tempRestList.get(i).getWebsite();
    }

    @JavascriptInterface
    public int getId(int i){
        return tempRestList.get(i).getId();
    }

    @JavascriptInterface
    public Long getPhone(int i){
        return tempRestList.get(i).getPhone();
    }





    //end of class
}
