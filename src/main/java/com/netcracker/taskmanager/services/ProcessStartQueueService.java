package com.netcracker.taskmanager.services;

import java.util.concurrent.PriorityBlockingQueue;
import com.netcracker.taskmanager.model.Process;

public class ProcessStartQueueService  {
    private static PriorityBlockingQueue<Process> pbq;

    private ProcessStartQueueService(){

    }

    public static synchronized PriorityBlockingQueue<Process> getPBQ(){
        if (pbq == null)
            pbq = new PriorityBlockingQueue<Process>();
        return pbq;
    }

    public void add(Process process){
        pbq.add(process);
    }

    public Process get(){
        return pbq.peek();
    }

}
