package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.ProcessControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;
import com.netcracker.taskmanager.util.ControllerProvider;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Class describes start service of processes's queue with such properties as <b>processStartQueueService</b>,
 * <b>priorityBlockingQueue</b>
 */
public class ProcessStartQueueService {
    /**
     * Static variable of type ProcessStartQueueService
     */
    private static ProcessStartQueueService processStartQueueService;
    /**
     * Queue of processes with priority
     */
    private PriorityBlockingQueue<Process> priorityBlockingQueue;

    /**
     * Private constructor restricted to this class itself
     * Create processes's queue with priority
     * @throws TaskManagerException
     */
    private ProcessStartQueueService() throws TaskManagerException {
        priorityBlockingQueue = new PriorityBlockingQueue<>(1, Comparator.comparing(Process::getStartDate));
        priorityBlockingQueue.addAll(ControllerProvider.getControllerProvider().getController(ProcessControllerInterface.class).getProcessesByStatus(ProcessStatus.PLANNED));
    }

    /**
     * Static method to create instance of ProcessStartQueueService class
     * @return processStartQueueService
     * @throws TaskManagerException
     */
    public static synchronized ProcessStartQueueService getProcessStartQueueService() throws TaskManagerException {
        if (processStartQueueService == null)
            processStartQueueService = new ProcessStartQueueService();
        return processStartQueueService;
    }

    /**
     * Method to add process to queue of processes
     * @param process
     * @throws TaskManagerException
     */
    public void addProcess(Process process) throws TaskManagerException {
        priorityBlockingQueue.add(process);
    }

    /**
     * Method to receive the head process from processes's queue
     * @return Process
     * @throws TaskManagerException
     */
    public Process getProcess() throws TaskManagerException {
        return priorityBlockingQueue.poll();
    }

}
