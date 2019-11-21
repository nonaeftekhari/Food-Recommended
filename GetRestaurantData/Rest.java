package com.app.foodrecommendedtest;

//Class rest that saves intializes all the varibables of a restaurants data that is stored in database
public class Rest {
    private int id = 0;
    private String restName = "";
    private String banner = "";
    private long zipcode = 0;
    private double restRating = 0.0;
    private String website = "";
    private long phone = 0;
    private double restPrice = 0.0;
    private int category = 0;

    public Rest(){}

    public Rest(int id, String restName, String banner, long zipcode, double restRating,
    String website, long phone, double restPrice, int category) {
        this.id = id;
        this.restName = restName;
        this.banner = banner;
        this.zipcode = zipcode;
        this.restRating = restRating;
        this.website = website;
        this.phone = phone;
        this.restPrice = restPrice;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getRestName() {
        return restName;
    }

    public String getBanner() {
        return banner;
    }

    public long getZipcode() {
        return zipcode;
    }

    public double getRestRating() {
        return restRating;
    }

    public String getWebsite() {
        return website;
    }

    public long getPhone() {
        return phone;
    }

    public double getRestPrice() {
        return restPrice;
    }

    public int getCategory() { return category; }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public void setRestRating(double restRating) {
        this.restRating = restRating;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setRestPrice(double restPrice) {
        this.restPrice = restPrice;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
