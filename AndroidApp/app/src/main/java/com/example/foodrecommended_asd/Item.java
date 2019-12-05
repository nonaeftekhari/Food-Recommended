package com.example.foodrecommended_asd;

public class Item {
    private int id;
    private String itemName;
    private double itemPrice;
    private double itemRating;
    private String description;
    private int restId;

    public Item(String itemName, String description, int restId, double itemPrice) {
        this.itemName = itemName;;
        this.description = description;
        this.restId = restId;
        this.itemPrice = itemPrice;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getItemRating() {
        return itemRating;
    }

    public String getDescription() {
        return description;
    }

    public int getRestId() {
        return restId;
    }
}
