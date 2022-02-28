package com.example.g_mart;

public class ProductsModel {


    private String name;
    private long price;
    private String img;




    private ProductsModel(){}
    private ProductsModel(String name, long price,String img){
        this.name=name;
        this.price=price;
        this.img=img;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
