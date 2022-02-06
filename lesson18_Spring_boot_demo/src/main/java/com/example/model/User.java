package com.example.model;

import com.sun.istack.NotNull;
import lombok.NonNull;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Size(min = 3, max = 20, message = "min = 3 characters, max = 20 characters")
//    @NotBlank(message = "username cannot be blank")
    private String userName;

//    @NotBlank(message = "Password can not be blank")
    private String userPassword;

//    @Email(message = "Please enter the correct email")
//    @NotBlank(message = "email cannot be blank")
    private String email;
//    @NotBlank(message = "phone.blank")
//    @Pattern( regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Please enter the correct phone number")
//    @Pattern(regexp = "\"^((09(\\d){8})|(086(\\d){7})|(088(\\d){7})|(089(\\d){7})|(01(\\d){9}))$\"", message = "Please enter the correct phone number")
//    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;

    private String avatar;

//    @NotBlank(message = "please enter your full name")
    private String fullName;

    @ManyToOne
    private Role role;

    public User() {
    }


    public User(int id, String userName, String userPassword, String email, String phoneNumber, String avatar, String fullName, Role role) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.fullName = fullName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
