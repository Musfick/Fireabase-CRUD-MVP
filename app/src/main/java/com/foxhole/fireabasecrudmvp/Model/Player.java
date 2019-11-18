package com.foxhole.fireabasecrudmvp.Model;

public class Player {
    public String name;
    public String age;
    public String position;
    public String key;

    public Player()
    {}


    public Player(String name, String age, String position, String key) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.key = key;
    }

    public Player(String name, String age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
