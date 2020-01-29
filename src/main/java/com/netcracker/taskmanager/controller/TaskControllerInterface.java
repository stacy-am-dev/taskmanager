package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;

import java.util.List;

public interface TaskControllerInterface {

    /**
     * Function creates new task
     */
    Task createTask();

    /**
     * Function update task
     * @param taskId
     * @param task
     * @return Task
     */
    Task updateTask(Long taskId, Task task);

    /**
     * Function delete task
     * @param taskId
     * @throws TaskManagerException
     */
    void deleteTask(Long taskId) throws TaskManagerException;

    /**
     * Function delete task
     * @param task
     * @throws TaskManagerException
     */
    void deleteTask(Task task) throws TaskManagerException;

    /**
     * Function receives task
     * @param taskId
     * @return Task
     */
    Task getTask(Long taskId);

    /**
     * Function receives task
     * @param taskName
     * @return Task
     */
    Task getTask(String taskName);

    /**
     * Function receives list of tasks
     * @return List<Task>
     */
    List<Task> getAllTask();
}
