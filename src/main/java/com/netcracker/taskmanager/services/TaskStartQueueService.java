package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.model.Task;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskStartQueueService {
    private static TaskStartQueueService taskStartQueueService;
    private PriorityBlockingQueue<Task> priorityBlockingQueue;

    private TaskStartQueueService() {
        priorityBlockingQueue = new PriorityBlockingQueue<>();
    }

    public static synchronized TaskStartQueueService getTaskStartQueueService() {
        if (taskStartQueueService == null)
            taskStartQueueService = new TaskStartQueueService();
        return taskStartQueueService;
    }

    public void addTask(Task task) {
        priorityBlockingQueue.add(task);
    }

    public Task getTask() {
        return priorityBlockingQueue.peek();
    }
}
