package com.example.foodrecommended_asd;

import java.util.List;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FoodAPI {
    @GET("Rest")
    Call<List<Rest>> getRests();

    @GET("Rest/Zip/{Zip}/")
    Call<List<Rest>> getRestZip(@Path("Zip") int zip);

    @GET("Rest/Zip/{Zip}/Cat/{Cat}/")
    Call<List<Rest>> getRestZipCat(@Path("Zip") int zip, @Path("Cat") int cat);

    @POST("Rest/")
    Call<Rest> createRest(@Body Rest rest);

    @GET("User/ID/{email}/")
    Call<User> getUserID(@Path("email") String userEmail);

    @POST("User/")
    Call<User> createUser(@Body User user);

    @GET("Item/Rest/{id}/")
    Call<List<Item>> getItemRest(@Path("id") int ID);

    @POST("Item/")
    Call<Item> createItem(@Body Item item);

    @GET("Rating/Rest/{id}/")
    Call<List<Rating>> getRatingRest(@Path("id") int ID);

    @POST("Rating/")
    Call<Rating> createRating(@Body Rating rating);

    @GET("RatingResponse/Rating/{id}/")
    Call<List<RatingResponse>> getRatingResponseId(@Path("id") int ID);

    @POST("RatingResponse/")
    Call<RatingResponse> createRatingResponse(@Body RatingResponse ratingResponse);
}
