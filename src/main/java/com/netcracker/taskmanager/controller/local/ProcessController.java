package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.ProcessStatus;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

import static com.netcracker.taskmanager.Constants.FIELDS_OF_PROCESS_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_PROCESS;

public class ProcessController implements ProcessControllerInterface {

    @Override
    public Process createProcess(Process process) throws TaskManagerException {
        if((process.getStartDate().compareTo(process.getEndDate()) > 0) || (ModelFacade.getInstance().getModel().getProcesses().stream().anyMatch(process1 -> process1.getName().equals(process.getName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_PROCESS_INCORRECT);
        process.setProcessId(ModelFacade.getInstance().getModel().getMatchMap().get(Process.class).generate());
        ModelFacade.getInstance().getModel().getProcesses().add(process);
        return process;
    }

    @Override
    public Process updateProcess(Process process) throws TaskManagerException {
        if((process.getStartDate().compareTo(process.getEndDate()) > 0) || (ModelFacade.getInstance().getModel().getProcesses().stream().anyMatch(process1 -> process1.getName().equals(process.getName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_PROCESS_INCORRECT);
        return ModelFacade.getInstance().getModel().getProcesses().stream()
                    .filter(process1 -> process1.getProcessId() == process.getProcessId())
                    .peek(process1 -> process1 = process)
                    .findAny()
                    .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS));

    }

    @Override
    public void deleteProcess(Long processId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcesses().removeIf(process -> process.getProcessId() == processId);
    }

    @Override
    public void deleteProcess(Process process) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcesses().remove(process);
    }

    @Override
    public Process getProcessByProcessId(Long processId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcesses().stream()
                .filter(process -> process.getProcessId().equals(processId))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS));
    }

    @Override
    public Process getProcessByProcessName(String processName) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcesses().stream()
                .filter(process -> process.getName().equals(processName))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS));
    }

    @Override
    public Collection<Process> getAllProcesses() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcesses();
    }

    @Override
    public Collection<Process> getProcessesByStatus(ProcessStatus status) throws TaskManagerException {
        PriorityBlockingQueue<Process> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (Process process : ModelFacade.getInstance().getModel().getProcesses()) {
            if (process.getStatus() == status) {
                priorityBlockingQueue.add(process);
            }
        }
        return priorityBlockingQueue;
    }
}
