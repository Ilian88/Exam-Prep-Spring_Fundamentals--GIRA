package com.example.gira.service.impl;

import com.example.gira.model.view.TaskViewModel;
import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.Task;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.enums.ProgressEnum;
import com.example.gira.model.serviceModel.TaskServiceModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ClassificationService classificationService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, UserService userService,
                           ClassificationService classificationService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.classificationService = classificationService;
        this.currentUser = currentUser;
    }

    @Override
    public Boolean checkIfTaskExistsByName(String name) {
        return this.taskRepository.existsByName(name);
    }

    @Override
    public void saveTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel,Task.class);

        UserEntity author = this.userService.findUserById(currentUser.getId());
        Classification classification = this.classificationService.
                findByName(taskServiceModel.getClassification());

        task.setUser(author)
                .setClassification(classification)
                .setProgress(ProgressEnum.OPEN);


        this.taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> getAllTask() {

        return this.taskRepository.findAll()
                .stream()
                .map(task -> {
                    TaskViewModel taskViewModel = modelMapper.map(task,TaskViewModel.class);
                    taskViewModel.setUser(task.getUser().getUsername());
                    taskViewModel.setClassification(task.getClassification().getClassificationName().name());

                    return taskViewModel;
                })
                .collect(Collectors.toList());
    }
}
