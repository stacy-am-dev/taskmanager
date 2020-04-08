package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.local.ProcessController;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;
import com.netcracker.taskmanager.util.ControllerProvider;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class ProcessStartQueueService {
    private static ProcessStartQueueService processStartQueueService;
    private PriorityBlockingQueue<Process> priorityBlockingQueue;

    private ProcessStartQueueService() throws TaskManagerException {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, Comparator.comparing(Process::getStartDate));
        priorityBlockingQueue.addAll(ControllerProvider.getControllerProvider().getController(ProcessController.class).getProcessesByStatus(ProcessStatus.PLANNED));
    }

    public static synchronized ProcessStartQueueService getProcessStartQueueService() throws TaskManagerException {
        if (processStartQueueService == null)
            processStartQueueService = new ProcessStartQueueService();
        return processStartQueueService;
    }

    public void addProcess(Process process) throws TaskManagerException {
        priorityBlockingQueue.add(process);
    }

    public Process getProcess() throws TaskManagerException {
        return priorityBlockingQueue.poll();
    }

}
