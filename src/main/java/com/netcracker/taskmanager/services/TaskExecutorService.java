package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.exception.TaskManagerException;

public class TaskExecutorService {
    private static TaskExecutorService taskExecutorService;

    private TaskExecutorService() throws TaskManagerException {
        TaskStartQueueService.getTaskStartQueueService();
    }

    public static synchronized TaskExecutorService getTaskExecutorService() throws TaskManagerException {
        if(taskExecutorService == null)
            taskExecutorService = new TaskExecutorService();
        return taskExecutorService;
    }

}
