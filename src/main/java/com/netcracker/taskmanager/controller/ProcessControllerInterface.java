package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.util.List;

public interface ProcessControllerInterface {
    /**
     * Function creates new Process
     */
    Process createProcess();

    /**
     * Function update process
     * @param processId
     * @param process
     * @return Process
     */
    Process updateProcess(Long processId, Process process);

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
    Process getProcess(Long processId);

    /**
     * Function receives process
     * @param processName
     * @return Process
     */
    Process getProcess(String processName);

    /**
     * Function receives list of processs
     * @return List<Process>
     */
    List<Process> getAllProcess();
}
