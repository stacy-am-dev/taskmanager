package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.util.Collection;
import java.util.List;

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
     * Function receives list of processes
     * @return Collection<Process>
     */
    Collection<Process> getAllProcesses() throws TaskManagerException;
}
