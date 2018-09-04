package com.developer.bianca.createyouraccounttp.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class RegisterCard implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String cel;
    private String cpf;
    private String city;

    public RegisterCard(String name, String email, String phone, String cel, String cpf, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cel = cel;
        this.cpf = cpf;
        this.city = city;
    }

    public RegisterCard(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
