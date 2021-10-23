package com.example.gira.model.bindingModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    public UserRegisterBindingModel() {
    }

    @Size(min = 3,max = 20,message = "Username must be between 3 and 20 characters")
    @NotNull
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3,max = 20 ,message = "Password must be between 3 and 20 characters")
    @NotNull
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean passwordsNotMatch() {
        return !this.getPassword().equals(getConfirmPassword());
    }
}
