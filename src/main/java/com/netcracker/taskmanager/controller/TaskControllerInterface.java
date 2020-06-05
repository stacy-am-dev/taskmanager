package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskDependency;
import com.netcracker.taskmanager.model.TaskStatus;

import java.util.Collection;

public interface TaskControllerInterface {

    /**
     * Function creates new task
     *  @param task
     */
    Task createTask(Task task) throws TaskManagerException;

    /**
     * Function update task
     * @param task
     * @return Task
     */
    Task updateTask(Task task) throws TaskManagerException;

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
    Task getTaskById(Long taskId) throws TaskManagerException;

    /**
     * Function receives task
     * @param taskName
     * @return Task
     */
    Task getTaskByName(String taskName) throws TaskManagerException;

    /**
     * Function receives list of tasks
     * @return Collection<Task>
     */
    Collection<Task> getAllTasks() throws TaskManagerException;

    /**
     * Function receives collection of tasks with different status
     * @param status
     * @return Collection<Task>
     */
    Collection<Task> getTasksByStatus(TaskStatus status) throws TaskManagerException;

    /**
     *
     * @param processId
     * @return
     * @throws TaskManagerException
     */
    Collection<Task> getTasksByProcessId(Long processId) throws TaskManagerException;

    /**
     *
     * @param taskId
     * @return
     * @throws TaskManagerException
     */
    Collection<Task> getDependentTasksByTaskId(Long taskId) throws TaskManagerException;

    /**
     *
     * @param taskId
     * @return
     * @throws TaskManagerException
     */
    Collection<Task> getTasksThatTaskDependsOnByTaskId(Long taskId) throws TaskManagerException;

}
