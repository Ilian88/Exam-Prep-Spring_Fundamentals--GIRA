package com.example.gira.model.bindingModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String email;

    private String password;

    @Email(message = "You must enter valid email address!")
    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Size(min = 3,max = 20,message = "Password must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
