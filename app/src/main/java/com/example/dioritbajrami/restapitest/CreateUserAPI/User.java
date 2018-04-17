package com.example.dioritbajrami.restapitest.CreateUserAPI;

/**
 * Created by dioritbajrami on 17.04.18.
 */

public class User {

    private Integer id;
    private String name;
    private String email;
    private int age;
    private String [] interests;

    public User(String name, String email, int age, String[] interests) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.interests = interests;
    }

    public Integer getId() {
        return id;
    }

}
