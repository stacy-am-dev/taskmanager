package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskStartQueueService {
    private static TaskStartQueueService taskStartQueueService;
    private PriorityBlockingQueue<Task> priorityBlockingQueue;

    private TaskStartQueueService() {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, (o1, o2) -> Integer.compare(o2.getPriority().getTaskPriority(), o1.getPriority().getTaskPriority()));
    }

    public static synchronized TaskStartQueueService getTaskStartQueueService() {
        if (taskStartQueueService == null)
            taskStartQueueService = new TaskStartQueueService();
        return taskStartQueueService;
    }

    public void addTask(Task task) {
        priorityBlockingQueue.add(task);
    }

    public synchronized Task getTask() throws TaskManagerException {
        if (priorityBlockingQueue == null)
            throw new TaskManagerException(new NullPointerException(), 123);
        else
            return priorityBlockingQueue.poll();
    }

}