package com.webtech.onlinemedicalms.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;

@Entity
public class SignupData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Uid;
    private String name;
    private String id_card;
    private String email;
    private String phone;
    private String password;
    @ColumnDefault("'user'")
    @Column(name = "role")
    private String role;
    
    public SignupData() {
    }

    public Long getUid() {
        return Uid;
    }

    public void setUid(Long uid) {
        Uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    
}