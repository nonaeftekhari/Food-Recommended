package com.app.foodrecommendedtest;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("Rest")
    Call<List<Rest>> getPosts();
}
