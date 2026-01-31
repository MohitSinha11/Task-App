package com.example.tasks.services.impl;

import com.example.tasks.domain.entities.TaskList;
import com.example.tasks.repositories.TaskListRepository;
import com.example.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(taskList.getTasks() != null)
            throw new IllegalArgumentException(
                    "Task List already had an Id !!"
            );

        if(taskList.getTitle() == null || taskList.getTitle().isBlank())
            throw new IllegalArgumentException(
                    "Task List Title must be present!!"
            );

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(
                new TaskList(
                    null,
                    taskList.getTitle(),
                    taskList.getDescription(),
                    null,
                    now,
                    now
                )
        );
    }
}
