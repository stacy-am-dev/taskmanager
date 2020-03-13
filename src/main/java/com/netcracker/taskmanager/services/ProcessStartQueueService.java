package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.local.ProcessController;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;

import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class ProcessStartQueueService {
    private static ProcessStartQueueService processStartQueueService;
    private PriorityBlockingQueue<Process> priorityBlockingQueue;

    private ProcessStartQueueService(PriorityBlockingQueue<Process> processPriorityBlockingQueue) throws TaskManagerException {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, Comparator.comparing(Process::getStartDate));
        ProcessController processController = new ProcessController();
        Collection<Process> processCollection = processController.getPlannedProcesses(processPriorityBlockingQueue);
        if(!processCollection.isEmpty()) {
            priorityBlockingQueue.addAll(processCollection);
        }
    }

    public static synchronized ProcessStartQueueService getProcessStartQueueService(PriorityBlockingQueue<Process> processPriorityBlockingQueue) throws TaskManagerException {
        if (processStartQueueService == null)
            processStartQueueService = new ProcessStartQueueService(processPriorityBlockingQueue);
        return processStartQueueService;
    }

    public void addProcess(Process process) throws TaskManagerException{
        priorityBlockingQueue.add(process);
    }

    public Process getProcess() throws TaskManagerException {
        return priorityBlockingQueue.poll();
    }

}
