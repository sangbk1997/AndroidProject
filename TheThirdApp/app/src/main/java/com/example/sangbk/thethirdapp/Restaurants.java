package com.example.sangbk.thethirdapp;

/**
 * Created by Sangbk on 9/13/2017.
 */

public class Restaurants {
    private String name;
    private String address;
    private String type;
    private String sale;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
    public void setSale(String sale){
        this.sale=sale;
    }
    public String getSale(){
        return sale;
    }
    public String toString(){
        return (getName()+"  "+getAddress()+"  "+getSale());
    }
}
