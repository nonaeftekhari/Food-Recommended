package com.example.foodrecommended_asd;

public class Rating {
    private int id;
    private String userEmail;
    private int restId;
    private String review;
    private int rating;

    public Rating(String userEmail, int restId, String review, int rating) {
        this.userEmail = userEmail;
        this.restId = restId;
        this.review = review;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getRestId() {
        return restId;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

}
