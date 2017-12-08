package com.example.sangbk.chartenginedemo;

        import android.support.annotation.NonNull;

        import java.util.Comparator;

public class Restaurant implements Comparable<Restaurant> {
    private String name="";
    private String address="";
    private String type="";
    private String sale="";

    public String getName() {
        return(name);
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getAddress() {
        return(address);
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public String getType() {
        return(type);
    }

    public void setType(String type) {
        this.type=type;
    }
    public void setSale(String sale) {
        this.sale = sale;
    }
    public String getSale(){
        return (sale);
    }

    @Override
    public int compareTo(Restaurant o) {
        int value=o.getSale().compareTo(this.getSale());
        if(value!=0){
            return value;
        }
        value=this.getName().compareTo(o.getName());
        return value;
    }


}