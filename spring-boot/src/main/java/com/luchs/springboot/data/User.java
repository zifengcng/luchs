package com.luchs.springboot.data;

/**
 * @Author cheng
 * @Date 2020/9/22
 */
public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
