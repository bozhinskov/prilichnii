package com.ystu.food.classes;

import java.util.ArrayList;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        initData();
    }

    ArrayList<Food> foods = new ArrayList<Food>();
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Zakaz> zakazs = new ArrayList<Zakaz>();

    //получить id покупателя по логину и паролю
    public long getIdUserByLogPas(String log, String pass) {
        for (User userLogPass : users) {
            if ((userLogPass.getName().equals(log)) && (userLogPass.getPass().equals(pass))) {
                return userLogPass.getId();
            }
        }
        return 0;
    }

    //проверка на правильность логина и пароля
    public boolean getLogin(String log, String pass) {
        for (User userLogPass : users) {
            if ((userLogPass.getName().equals(log)) && (userLogPass.getPass().equals(pass))) {
                return false;
            }
        }
        return true;
    }

    //получить еду
    public ArrayList<Food> getFoods() {
        return foods;
    }

    //получить еду по id
    public Food getFoodById(long id) {
        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    //установить заказ
    public void setZakazs(ArrayList<Zakaz> zakazs) {
        this.zakazs = zakazs;
    }

    //получить заказ по id прользователя
    public Zakaz getZakazByUser(long idUser) {
        for (Zakaz or : zakazs) {
            if (or.getUser_id() == idUser) {
                return or;
            }
        }
        return new Zakaz();
    }

    // данные товаров и пользователей
    public void initData() {
        foods.add(new Food(1, "Пицца", "img/11.png", 500));
        foods.add(new Food(2, "Хотдог", "img/12.png", 130));
        foods.add(new Food(3, "Роллы", "img/13.png", 250));
        foods.add(new Food(4, "Бутер", "img/14.png", 120));
        foods.add(new Food(5, "Бургер", "img/15.png", 300));
        foods.add(new Food(6, "Пивас", "img/16.png", 100));
        foods.add(new Food(7, "Картоха", "img/17.png", 80));
        foods.add(new Food(8, "КККомбо", "img/18.png", 400));

        users.add(new User(1, "a", "1"));
        users.add(new User(2, "b", "2"));
        users.add(new User(3, "v", "3"));
    }
}

