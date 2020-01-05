package com.example.demo.dto;

import java.util.Arrays;

public class DesignerAdDTO {
    private String adTitle;
    private String category;
    private Integer price;
    private Integer rating;
    private String description;

    public DesignerAdDTO(){

    }

    public DesignerAdDTO(String adTitle, String category, Integer price, Integer rating, String description) {
        this.adTitle = adTitle;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.description = description;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DesignerAdDTO{" +
                "adTitle='" + adTitle + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
