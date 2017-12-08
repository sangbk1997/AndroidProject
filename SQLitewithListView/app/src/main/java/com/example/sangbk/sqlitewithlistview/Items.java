package com.example.sangbk.sqlitewithlistview;

/**
 * Created by Sangbk on 10/17/2017.
 */

public class Items {
    private int idItem;
    private String name;
    private int mount;
    private int cost;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
