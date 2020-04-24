package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.TaskControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskStatus;
import com.netcracker.taskmanager.util.ControllerProvider;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Class describes start service of tasks's queue with such properties as <b>taskStartQueueService</b>,
 * <b>priorityBlockingQueue</b>
 */
public class TaskStartQueueService {
    /**
     * Static variable of type TaskStartQueueService
     */
    private static TaskStartQueueService taskStartQueueService;
    /**
     * Queue of tasks with priority
     */
    private PriorityBlockingQueue<Task> priorityBlockingQueue;

    /**
     * Private constructor restricted to this class itself
     * Create tasks's queue with priority
     * @throws TaskManagerException
     */
    private TaskStartQueueService() throws TaskManagerException {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, (o1, o2) -> Integer.compare(o2.getPriority().getTaskPriority(), o1.getPriority().getTaskPriority()));
        priorityBlockingQueue.addAll(ControllerProvider.getControllerProvider().getController(TaskControllerInterface.class).getTasksByStatus(TaskStatus.PLANNED));
    }

    /**
     * Static method to create instance of TaskStartQueueService class
     * @return taskStartQueueService
     * @throws TaskManagerException
     */
    public static synchronized TaskStartQueueService getTaskStartQueueService() throws TaskManagerException {
        if (taskStartQueueService == null)
            taskStartQueueService = new TaskStartQueueService();
        return taskStartQueueService;
    }

    /**
     * Method to add task to queue of tasks
     * @param task
     * @throws TaskManagerException
     */
    public void addTask(Task task) throws TaskManagerException {
        priorityBlockingQueue.add(task);
    }

    /**
     * Method to receive the head task from tasks's queue
     * @return Process
     * @throws TaskManagerException
     */
    public synchronized Task getTask() throws TaskManagerException {
        return priorityBlockingQueue.poll();
    }

}