package com.example.foodrecommended_asd;

public class RatingResponse {
    private int id;
    private int ratingId;
    private String response;

    public RatingResponse(int ratingId, String response) {
        this.ratingId = ratingId;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public int getRatingId() {
        return ratingId;
    }

    public String getResponse() {
        return response;
    }
}
