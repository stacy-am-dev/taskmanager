package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

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

    @Override
    public Collection<Process> getProcessesByStatus(PriorityBlockingQueue<Process> processPriorityBlockingQueue, ProcessStatus status) throws TaskManagerException {
        PriorityBlockingQueue<Process> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (Process process : processPriorityBlockingQueue) {
            if (process.getStatus() == status) {
                priorityBlockingQueue.add(process);
            }
        }
        return priorityBlockingQueue;
    }
}
