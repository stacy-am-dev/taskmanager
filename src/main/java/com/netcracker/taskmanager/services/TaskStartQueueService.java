package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.local.TaskController;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskStatus;
import com.netcracker.taskmanager.util.ControllerProvider;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskStartQueueService {
    private static TaskStartQueueService taskStartQueueService;
    private PriorityBlockingQueue<Task> priorityBlockingQueue;

    private TaskStartQueueService() throws TaskManagerException {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, (o1, o2) -> Integer.compare(o2.getPriority().getTaskPriority(), o1.getPriority().getTaskPriority()));
        priorityBlockingQueue.addAll(ControllerProvider.getControllerProvider().getController(TaskController.class).getTasksByStatus(TaskStatus.PLANNED));
    }

    public static synchronized TaskStartQueueService getTaskStartQueueService() throws TaskManagerException {
        if (taskStartQueueService == null)
            taskStartQueueService = new TaskStartQueueService();
        return taskStartQueueService;
    }

    public void addTask(Task task) {
        priorityBlockingQueue.add(task);
    }

    public synchronized Task getTask() throws TaskManagerException {
        return priorityBlockingQueue.poll();
    }

}