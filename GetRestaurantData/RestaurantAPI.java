package com.app.foodrecommendedtest;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

//All of the json gets converted here
public interface RestaurantAPI {
    @GET("Rest")
    Call<List<Rest>> getPosts();
}
