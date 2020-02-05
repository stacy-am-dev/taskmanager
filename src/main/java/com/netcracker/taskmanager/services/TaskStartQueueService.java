package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.model.Task;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskStartQueueService {
    private static PriorityBlockingQueue<Task> priorityBlockingQueue;

    public TaskStartQueueService(){}

    public static synchronized PriorityBlockingQueue<Task> getPriorityBlockingQueue() {
        if(priorityBlockingQueue == null)
            priorityBlockingQueue = new PriorityBlockingQueue<>();
        return priorityBlockingQueue;
    }

    public void addTask(Task task){
        priorityBlockingQueue.add(task);
    }

    public Task getTask(){
        return priorityBlockingQueue.peek();
    }
}
