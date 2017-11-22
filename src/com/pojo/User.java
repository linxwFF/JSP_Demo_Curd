package com.pojo;

import java.util.Date;

/**
 * Created by LINxwFF on 2017/11/21.
 */
// id role nickname name password gender email tel
public class User {
    private int id;
    private int role;
    private String nickname;
    private String name;
    private String password;
    private int gender;
    private String email;
    private String tel;

    public User() {
    }

    public User(int id, int role, String nickname, String name, String password, int gender, String email, String tel, String confirmPassword) {
        this.id = id;
        this.role = role;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.tel = tel;
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String confirmPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
