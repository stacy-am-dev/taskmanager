package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.EmployeeControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskType;
import com.netcracker.taskmanager.util.ControllerProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

public class TaskExecutorService extends TaskActionService {
    private static TaskExecutorService taskExecutorService;
    private static final Logger LOGGER = Logger.getLogger(TaskExecutorService.class);
    private Collection<Thread> threads;
    private int quantityThreads = 10;

    private TaskExecutorService() throws TaskManagerException {
        threads = new ArrayList<Thread>(quantityThreads);

    }

    public static synchronized TaskExecutorService getTaskExecutorService() throws TaskManagerException {
        if (taskExecutorService == null)
            taskExecutorService = new TaskExecutorService();
        return taskExecutorService;
    }

    public void startTask() throws TaskManagerException {
        while (TaskStartQueueService.getTaskStartQueueService().getTask() != null) {
            Task task = TaskStartQueueService.getTaskStartQueueService().getTask();
            Thread newThread = new Thread(() -> {
                try {
                    if (task.getType() == TaskType.MANUAL)
                        task.setAssigneeId(ControllerProvider.getControllerProvider().getController(EmployeeControllerInterface.class).getAssigneeEmployeeId(task));
                    else if (task.getType() == TaskType.JAVA_ACTION)
                        start();
                }catch (TaskManagerException e){
                    LOGGER.error("Problems with getting controller or TaskActionService",e);
                }
            });
            newThread.start();
            threads.add(newThread);
        }
    }

    @Override
    public void run(Process process, Task task) throws TaskManagerException {

    }
}
