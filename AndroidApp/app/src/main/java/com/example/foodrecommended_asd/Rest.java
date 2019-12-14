package com.example.foodrecommended_asd;
import java.net.URL;
import java.util.Locale;


import android.graphics.Bitmap;
import android.icu.util.ULocale;

public class Rest {
    private int id;
    private String restName;
    private String banner;
    private int zipcode;
    private double restRating;
    private String website;
    private double phone;
    private double restPrice;
    private int category;

    public Rest(String restName, int zipcode, String website, double phone, int category) {
        this.restName = restName;
        //this.banner = banner;
        //find out how to post images with piccaso
        this.zipcode = zipcode;
        this.website = website;
        this.phone = phone;
        this.category = category;
    }
    
    public Rest() {
    	
    }


    public void setRestName(String restName) {
        if(restName.length()>50){
            throw new IllegalArgumentException("Input must be 50 or less characters: " + restName.length());
        }
        this.restName = restName;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setZipcode(int zipcode) {
        int length = String.valueOf(zipcode).length();

        if(length != 5){
            throw new IllegalArgumentException("Input must be 5 characters: " + zipcode);
        }
        this.zipcode = zipcode;
    }

    public void setWebsite(String website) {
        try{
            new URL(website).toURI();
            this.website = website;
        }

        catch (Exception e){
            throw new IllegalArgumentException("Incorrect Website");
        }
    }

    public void setPhone(double phone) {

        if(phone >= 9999999999.0){
            throw new IllegalArgumentException("Input must be a valid phone number: " + phone);
        }

        this.phone = phone;
    }

    public void setCategory(int category) {
        if(category >= 0 && category < 9){
            this.category = category;
        }
        else{
            throw new IllegalArgumentException("Input must be between 0 and 8 characters: " + category);
        }
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

    public int getZipcode() {
        return zipcode;
    }

    public double getRestRating() {
        return restRating;
    }

    public int getCategory() {
        return category;
    }

    public String getWebsite() {
        return website;
    }

    public double getPhone() {
        return phone;
    }

    public double getRestPrice() {
        return restPrice;
    }


}
