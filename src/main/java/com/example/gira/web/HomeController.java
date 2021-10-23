package com.example.gira.web;

import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, TaskService taskService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    private String home(Model model) {

        if (!currentUser.isLoggedIn()) {
            return "index";
        }

        model.addAttribute("tasks",this.taskService.getAllTask());

        return "home";
    }
}
