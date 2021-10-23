package com.example.gira.service;

import com.example.gira.model.view.TaskViewModel;
import com.example.gira.model.serviceModel.TaskServiceModel;

import java.util.List;

public interface TaskService {
    Boolean checkIfTaskExistsByName(String name);

    void saveTask(TaskServiceModel taskServiceModel);

    List<TaskViewModel> getAllTask();

}
