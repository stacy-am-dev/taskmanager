package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

public interface ProcessControllerInterface {
    /**
     * Function creates new Process
     * @param process
     */
    Process createProcess(Process process) throws TaskManagerException;

    /**
     * Function update process
     * @param process
     * @return Process
     */
    Process updateProcess(Process process) throws TaskManagerException;

    /**
     * Function delete process
     * @param processId
     * @throws TaskManagerException
     */
    void deleteProcess(Long processId) throws TaskManagerException;

    /**
     * Function delete process
     * @param process
     * @throws TaskManagerException
     */
    void deleteProcess(Process process) throws TaskManagerException;

    /**
     * Function receives process
     * @param processId
     * @return Process
     */
    Process getProcessByProcessId(Long processId) throws TaskManagerException;

    /**
     * Function receives process
     * @param processName
     * @return Process
     */
    Process getProcessByProcessName(String processName) throws TaskManagerException;

    /**
     * Function receives collection of processes
     * @return Collection<Process>
     */
    Collection<Process> getAllProcesses() throws TaskManagerException;

    /**
     * Function receives collection of processes with different status
     * @param processPriorityBlockingQueue
     * @param status
     * @return Collection<Process>
     * @throws TaskManagerException
     */
    Collection<Process> getProcessesByStatus(PriorityBlockingQueue<Process> processPriorityBlockingQueue, ProcessStatus status) throws TaskManagerException;
}
