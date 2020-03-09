package com.example.appdatmon;

public class food_obj {
    int id_image;
    int price;
    String name;
    boolean checked;
    boolean editname = false;
    boolean editprice = false;

    public food_obj(int id_image, int price, String name, boolean checked) {
        this.id_image = id_image;
        this.price = price;
        this.name = name;
        this.checked = checked;
    }
}
