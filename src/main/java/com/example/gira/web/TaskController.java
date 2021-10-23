package com.example.gira.web;

import com.example.gira.model.bindingModel.AddTaskBindingModel;
import com.example.gira.model.serviceModel.TaskServiceModel;
import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public AddTaskBindingModel taskBindingModel(){
        return new AddTaskBindingModel();
    }

    @GetMapping("/add")
    public String addTask() {

        if (!currentUser.isLoggedIn()) {
            return "redirect:/users/login";
        }

        return "add-task";
    }

    @PostMapping("/add")
    public String addTaskConfirm(@ModelAttribute @Valid AddTaskBindingModel addTaskBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        Boolean taskExists = this.taskService.checkIfTaskExistsByName(
                addTaskBindingModel.getName()
        );

        if (bindingResult.hasErrors() || taskExists || addTaskBindingModel.getClassification().isEmpty()) {

            redirectAttributes.addFlashAttribute("addTaskBindingModel",addTaskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel",
                    bindingResult);

            return "redirect:add";
        }
        TaskServiceModel taskServiceModel = modelMapper.map(addTaskBindingModel,TaskServiceModel.class);
        taskServiceModel.setDueDate(LocalDate.parse(addTaskBindingModel.getDueDate()));
        this.taskService.saveTask(
                taskServiceModel
        );

        return "redirect:/";

    }

}
