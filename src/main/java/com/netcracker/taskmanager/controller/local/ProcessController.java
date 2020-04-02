package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;
import com.netcracker.taskmanager.util.Model;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

import static com.netcracker.taskmanager.Constants.*;

public class ProcessController implements ProcessControllerInterface {

    private Model getModel = ModelFacade.getInstance().getModel();

    @Override
    public Process createProcess(Process process) throws TaskManagerException {
        if(process.getStartDate().compareTo(process.getEndDate()) > 0)
            throw new TaskManagerException(new Throwable(""), START_OR_END_DATE_OF_PROCESS_INCORRECT);
        else{
            process.setProcessId(getModel.getMatchMap().get(Process.class).generate());
            getModel.getProcesses().add(process);
            return process;
        }
    }

    @Override
    public Process updateProcess(Process process) throws TaskManagerException {
        if(process.getStartDate().compareTo(process.getEndDate()) > 0)
            throw new TaskManagerException(new Throwable(""), START_OR_END_DATE_OF_PROCESS_INCORRECT);
        else {
            getModel.getProcesses().removeIf(process1 -> process1.getProcessId().equals(process.getProcessId()));
            getModel.getProcesses().add(process);
            return process;
        }
    }

    @Override
    public void deleteProcess(Long processId) throws TaskManagerException {
        if(processId == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_IDENTIFIER_OF_PROCESS);
        else getModel.getProcesses().removeIf(process -> process.getProcessId().equals(processId));
    }

    @Override
    public void deleteProcess(Process process) throws TaskManagerException {
        if(process.getStartDate().compareTo(process.getEndDate()) > 0)
            throw new TaskManagerException(new Throwable(""), START_OR_END_DATE_OF_PROCESS_INCORRECT);
        else getModel.getProcesses().removeIf(process1 -> process1.equals(process));
    }

    @Override
    public Process getProcessByProcessId(Long processId) throws TaskManagerException {
        Process processResult = getModel.getProcesses().stream()
                .filter(process -> process.getProcessId().equals(processId))
                .findAny()
                .orElse(null);
        if (processResult == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS);
        return processResult;
    }

    @Override
    public Process getProcessByProcessName(String processName) throws TaskManagerException {
        Process processResult = getModel.getProcesses().stream()
                .filter(process -> process.getName().equals(processName))
                .findAny()
                .orElse(null);
        if(processResult == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS);
        return processResult;
    }

    @Override
    public Collection<Process> getAllProcesses() throws TaskManagerException {
        return getModel.getProcesses();
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
