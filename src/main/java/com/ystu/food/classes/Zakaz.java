package com.ystu.food.classes;

import java.util.ArrayList;
import java.util.List;

public class Zakaz {
    private long id = 0;
    private long user_id =0;
    private List<Long> foods = new ArrayList<Long>();

    public Zakaz() {
    }

    public Zakaz(long id, long user_id, List<Long> foods) {
        this.id = id;
        this.user_id = user_id;
        this.foods = foods;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getFoods() {
        return foods;
    }

    public void setFoods(List<Long> foods) {
        this.foods = foods;
    }
}
