package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.TaskControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskStatus;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskController implements TaskControllerInterface {
    @Override
    public Task createTask(Task task) throws TaskManagerException {
        return null;
    }

    @Override
    public Task updateTask(Task task) throws TaskManagerException {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) throws TaskManagerException {

    }

    @Override
    public void deleteTask(Task task) throws TaskManagerException {

    }

    @Override
    public Task getTaskById(Long taskId) throws TaskManagerException {
        return null;
    }

    @Override
    public Task getTaskByName(String taskName) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<Task> getAllTasks() throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<Task> getTasksByStatus(TaskStatus status) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (Task task : ModelFacade.getInstance().getModel().getTasks()) {
            if (task.getStatus() == status) {
                priorityBlockingQueue.add(task);
            }
        }
        return priorityBlockingQueue;
    }
}
