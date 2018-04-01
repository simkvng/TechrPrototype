package com.simcoder.tinder;
import java.util.Comparator;

/**
 * Created by natha on 3/30/2018.
 */
//this is basically the equivalent to our Product Class

public class Product {


    private String name;
    private String category;
    private String[] section = new String[3];
    private double price;
    private String [] images;
    private double rating;
    private String url;

    Product()
    {
        name = "";
        category = "";
        section = null;
        price = 0;
        images = null;
        rating = 0;
        url = "";

    }
    Product(String name, String category, String[] section, double price, String[] images, double rating, String url)
    {
        this.name = name;
        this.category = category;
        this.section = section;
        this.price = price;
        this.images = images;
        this.rating = rating;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String[] getSection() {
        return section;
    }
    public void setSection(String[] section) {
        this.section = section;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String[] getImages() {
        return images;
    }
    public void setImages(String[] images) {
        this.images = images;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    static Comparator<Product> alphabetical() {
        return new Comparator<Product>() {
            public int compare(Product one, Product two) {
                int compareValue = one.name.compareTo(two.name);
                if(compareValue < 0)
                    return -1;
                else if(compareValue == 0)
                    return 0;
                else
                    return 1;
            }
        };
    }

    static Comparator<Product> price() {
        return new Comparator<Product>() {
            public int compare(Product one, Product two) {
                double compareValue = one.price - two.price;
                if(compareValue < 0)
                    return -1;
                else if(compareValue == 0)
                    return 0;
                else
                    return 1;
            }
        };
    }



}
