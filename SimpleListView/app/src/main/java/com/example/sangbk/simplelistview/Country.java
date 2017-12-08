package com.example.sangbk.simplelistview;

/**
 * Created by Sangbk on 9/22/2017.
 */

public class Country {
    String name;
    int id;
    Country(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;

    }
    public String toString(){
        return this.name+ " : "+this.id;
    }
}
