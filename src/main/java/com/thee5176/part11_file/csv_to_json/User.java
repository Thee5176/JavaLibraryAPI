package com.thee5176.part11_file.csv_to_json;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String name;
    private String email;
    private String phone_number;
    private String date_of_birth;

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }

    public User(String name, String email, String phone_number, String date_of_birth){
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
    }
    public User(){}

    @Override
    public String toString() {
        return "User {\n" +
                "\tname :'" + name + "',\n" +
                "\temail :'" + email + "',\n" +
                "\tphone_number :'" + phone_number + "',\n" +
                "\tdate_of_birth :" + date_of_birth + "',\n" +
                '}';
    }
}
