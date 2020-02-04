package com.netcracker.taskmanager.services;

import java.util.concurrent.PriorityBlockingQueue;
import com.netcracker.taskmanager.model.Process;

public class ProcessStartQueueService  {
    private static PriorityBlockingQueue<Process> priorityBlockingQueue;

    private ProcessStartQueueService(){

    }

    public static synchronized PriorityBlockingQueue<Process> getPriorityBlockingQueue(){
        if (priorityBlockingQueue == null)
            priorityBlockingQueue = new PriorityBlockingQueue<Process>();
        return priorityBlockingQueue;
    }

    public void add(Process process){
        priorityBlockingQueue.add(process);
    }

    public Process get(){
        return priorityBlockingQueue.peek();
    }

}
