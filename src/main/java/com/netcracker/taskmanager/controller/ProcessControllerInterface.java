package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.util.List;

public interface ProcessControllerInterface {
    /**
     * Function creates new Process
     * @param process
     */
    Process createProcess(Process process);

    /**
     * Function update process
     * @param process
     * @return Process
     */
    Process updateProcess(Process process);

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
    Process getProcessBySomething(Long processId);

    /**
     * Function receives process
     * @param processName
     * @return Process
     */
    Process getProcessBySomething(String processName);

    /**
     * Function receives list of processs
     * @return List<Process>
     */
    List<Process> getAllProcess();
}
