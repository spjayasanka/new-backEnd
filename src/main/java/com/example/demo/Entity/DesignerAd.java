package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "designerAd")
public class DesignerAd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "adTitle")
    private String adTitle;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Integer price;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "images")
    private byte[] images;

    @Column(name = "description")
    private String description;

    public DesignerAd(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
