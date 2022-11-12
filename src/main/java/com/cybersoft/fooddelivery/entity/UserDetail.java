package com.cybersoft.fooddelivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "users_detail")
public class UserDetail {

    @Id
    @Column(name = "user_id")
    private int userId;

    @JsonIgnore
    @OneToOne
//    @MapsId copy id chỉ định làm khoá ngoại và điều kiện join
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "age")
    private int age;

    @Column(name = "cmnd")
    private String cmnd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}
