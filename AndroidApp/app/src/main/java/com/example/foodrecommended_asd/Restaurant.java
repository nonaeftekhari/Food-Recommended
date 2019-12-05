package com.example.foodrecommended_asd;

import android.webkit.JavascriptInterface;

public class Restaurant {
    private String banner;
    private int id;
    private int zip;
    private double rating;
    private String website;
    private String phoneNumber;
    private double restaurantPrice;
    private int category;

    @JavascriptInterface
    public void setBanner(String banner) {
        this.banner = banner;
    }

    @JavascriptInterface
    public void setId(int id) {
        this.id = id;
    }
    @JavascriptInterface
    public void setZip(String z) {
        int zipper = Integer.parseInt(z);
        this.zip = zipper;
    }
    @JavascriptInterface
    public void setRating(double rating) {
        this.rating = rating;
    }
    @JavascriptInterface
    public void setWebsite(String website) {
        this.website = website;
    }
    @JavascriptInterface
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @JavascriptInterface
    public void setRestaurantPrice(double restaurantPrice) {
        this.restaurantPrice = restaurantPrice;
    }
    @JavascriptInterface
    public void setCategory(String category) {
        int setter = Integer.parseInt(category);
        this.category = setter;
    }
    // Setter Function above
    @JavascriptInterface
    public String getBanner() {
        return banner;
    }
    @JavascriptInterface
    public int getId() {
        return id;
    }
    @JavascriptInterface
    public int getZip() {
        return zip;
    }
    @JavascriptInterface
    public double getRating() {
        return rating;
    }
    @JavascriptInterface
    public String getWebsite() {
        return website;
    }
    @JavascriptInterface
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @JavascriptInterface
    public double getRestaurantPrice() {
        return restaurantPrice;
    }
    @JavascriptInterface
    public int getCategory() {
        return category;
    }
    // Getter Functions above

}
