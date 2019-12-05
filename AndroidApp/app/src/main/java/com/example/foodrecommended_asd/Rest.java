package com.example.foodrecommended_asd;


import android.graphics.Bitmap;
import android.webkit.JavascriptInterface;

import java.util.List;

public class Rest {
    private int id;
    private String restName;
    private String banner;
    private int zipcode;
    private double restRating;
    private String website;
    private long phone;
    private double restPrice;
    private int category;


    public Rest() {
    }

    public Rest(String restName, int zipcode, String website, long phone, int category) {
        this.restName = restName;
        //this.banner = banner;
        //find out how to post images with piccaso
        this.zipcode = zipcode;
        this.website = website;
        this.phone = phone;
        this.category = category;
    }

    @JavascriptInterface
    public int getId() {
        return id;
    }

    @JavascriptInterface
    public String getRestName() {
        return restName;
    }

    @JavascriptInterface
    public String getBanner() {
        return "http://127.0.0.1:8000/" + banner;
    }

    @JavascriptInterface
    public int getZipcode() {
        return zipcode;
    }

    @JavascriptInterface
    public double getRestRating() {
        return restRating;
    }

    @JavascriptInterface
    public int getCategory() {
        return category;
    }

    @JavascriptInterface
    public String getWebsite() {
        return website;
    }

    @JavascriptInterface
    public long getPhone() {
        return phone;
    }

    @JavascriptInterface
    public double getRestPrice() {
        return restPrice;
    }

    @JavascriptInterface
    public String printRestList(List<Rest> listRest){
        String content = "";
        for (Rest rest : listRest) {
            content += "<a href= '" + rest.getWebsite() + "'>";
            content += "<h2>" + rest.getRestName()+ "</h2><p></a>";
            content += "Rating: " + rest.getRestRating()+ "</p><p>";
            content += "Price: " + rest.getRestPrice()+ "</p><hr>";

        }
        return content;
    }


}
