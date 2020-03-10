package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;

import java.util.Collection;

public class ProcessController implements ProcessControllerInterface {
    @Override
    public Process createProcess(Process process) throws TaskManagerException {
        return null;
    }

    @Override
    public Process updateProcess(Process process) throws TaskManagerException {
        return null;
    }

    @Override
    public void deleteProcess(Long processId) throws TaskManagerException {

    }

    @Override
    public void deleteProcess(Process process) throws TaskManagerException {

    }

    @Override
    public Process getProcessByProcessId(Long processId) throws TaskManagerException {
        return null;
    }

    @Override
    public Process getProcessByProcessName(String processName) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<Process> getAllProcesses() throws TaskManagerException {
        return null;
    }
}
