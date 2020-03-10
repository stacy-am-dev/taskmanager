package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.model.Process;

import java.util.concurrent.PriorityBlockingQueue;

public class ProcessStartQueueService {
    private static ProcessStartQueueService processStartQueueService;
    private PriorityBlockingQueue<Process> priorityBlockingQueue;

    private ProcessStartQueueService() {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, ((o1, o2) -> {
            if (o1.getStartDate().isAfter(o2.getStartDate()))
                return 1;
            else if (o1.getStartDate().isBefore(o2.getStartDate()))
                return -1;
            else
                return 0;
        }));
    }

    public static synchronized ProcessStartQueueService getProcessStartQueueService() {
        if (processStartQueueService == null)
            processStartQueueService = new ProcessStartQueueService();
        return processStartQueueService;
    }

    public void addProcess(Process process) {
        priorityBlockingQueue.add(process);
    }

    public Process getProcess() {
        return priorityBlockingQueue.poll();
    }

}
