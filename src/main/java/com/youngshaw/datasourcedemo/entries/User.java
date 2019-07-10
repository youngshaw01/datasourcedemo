package com.youngshaw.datasourcedemo.entries;

public class User {
    private Integer uid;
    private String userName;
    private String age;
    private String gender;

    public User(Integer uid, String userName, String age, String gender) {
        this.uid = uid;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
