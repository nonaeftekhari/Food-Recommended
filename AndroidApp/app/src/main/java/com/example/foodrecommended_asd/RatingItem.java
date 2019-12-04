package com.example.foodrecommended_asd;

public class RatingItem {

    private int id;
    private String userEmail;
    private int restId;
    private int itemId;
    private String review;
    private int rating;

    public RatingItem(String userEmail, int restId, int itemId, String review, int rating) {
        this.userEmail = userEmail;
        this.restId = restId;
        this.itemId = itemId;
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

    public int getItemId() {
        return itemId;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }
}
