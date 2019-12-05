package com.example.foodrecommended_asd;

<<<<<<< HEAD
import android.content.Context;
=======
import android.os.RecoverySystem;
>>>>>>> 99041909fade26534bd9bc309975728a0f717245
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

    @JavascriptInterface
    public List<Rest> getRestZipCat(int zip, int cat) {
        Call<List<Rest>> call = foodAPI.getRestZipCat(zip, cat);

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

    @JavascriptInterface
    public User getUserID(String userEmail) {
        Call call = foodAPI.getUserID(userEmail);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    String message = "Email already exists.";
                    Context jContext;

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

    public List<RatingResponse> getRatingResponse(int id){
        Call<List<RatingResponse>> call = foodAPI.getRatingResponseId(id);

        call.enqueue(new Callback<List<RatingResponse>>() {
            @Override
            public void onResponse(Call<List<RatingResponse>> call, Response<List<RatingResponse>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                tempRatingResponse = response.body();
            }

            @Override
            public void onFailure(Call<List<RatingResponse>> call, Throwable t) {

            }
        });
        return tempRatingResponse;
    }


    public boolean checkUser(String pk){
        tempBool = false;

        Call<User> call = foodAPI.getUserID(pk);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    return;
                }else{
                    tempBool = true;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return tempBool;
    }
    //end of class
}
