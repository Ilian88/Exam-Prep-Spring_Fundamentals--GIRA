package com.example.gira.web;

import com.example.gira.model.bindingModel.UserLoginBindingModel;
import com.example.gira.model.bindingModel.UserRegisterBindingModel;
import com.example.gira.model.serviceModel.UserServiceModel;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;

    public UserController(ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute @Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        Boolean existsByUsernameAndPassword = this.userService.checkUserByUsernameAndPassword(
                userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getPassword()
        );

        if (bindingResult.hasErrors() || existsByUsernameAndPassword || userRegisterBindingModel.passwordsNotMatch()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);

            return "redirect:register";
        }

        this.userService.registerUser(
                modelMapper.map(userRegisterBindingModel, UserServiceModel.class)
        );

        return "redirect:login";

    }

    @PostMapping("/login")
    public String loginConfirm(@ModelAttribute @Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (currentUser.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            return "redirect:login";
        }

        Boolean userLoggedIn = this.userService.loginUser(
                modelMapper.map(
                        userLoginBindingModel,
                        UserServiceModel.class)
        );

        if (userLoggedIn) {
            return "redirect:/";
        }

        return "redirect:login";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
//        currentUser.setUsername(null)
//                .setId(null);

        session.invalidate();

        return "redirect:/";
    }

}
