package com.example.sangbk.jsontutorial;

/**
 * Created by Sangbk on 11/1/2017.
 */

public class Address {
    private String street;
    private  String city;
    public void Address(){

    }
    public Address(String street , String city){
        this.street=street;
        this.city=city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String toString(){
        return street+ "  "+city;
    }
}
