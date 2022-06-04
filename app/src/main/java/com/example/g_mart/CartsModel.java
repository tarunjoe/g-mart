package com.example.g_mart;

public class CartsModel {



    private  String name;

    private  long price;
    private  String img;





    private CartsModel(){}
    private CartsModel(String name, long price,String img){
        this.name=name;
        this.price=price;
        this.img=img;



    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public static String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}


