package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.TaskControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskDependency;
import com.netcracker.taskmanager.model.TaskStatus;
import com.netcracker.taskmanager.util.ControllerProvider;
import com.netcracker.taskmanager.util.ModelFacade;
import org.apache.log4j.Logger;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.NO_SUCH_PROCESS;
import static com.netcracker.taskmanager.model.ProcessStatus.IN_PROGRESS;

public class ProcessExecutorService {
    private static ProcessExecutorService processExecutorService;
    private static final Logger LOGGER = Logger.getLogger(ProcessExecutorService.class);
    private static final int NUM_OF_THREADS = 10;
    private ArrayList<Thread> threads = new ArrayList<Thread>();

    private ProcessExecutorService() throws TaskManagerException {
        ProcessStartQueueService.getProcessStartQueueService();
    }

    public static synchronized ProcessExecutorService getProcessExecutorService() throws TaskManagerException {
        if (processExecutorService == null)
            processExecutorService = new ProcessExecutorService();
        return processExecutorService;
    }

    public void startService() throws TaskManagerException {
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            Thread startProcess = new Thread() {
                @Override
                public void start() {
                    while (true) {
                        Process process = null;
                        try {
                            process = ProcessStartQueueService.getProcessStartQueueService().getProcess();
                        } catch (TaskManagerException e) {
                            LOGGER.error("Problems with getting ProcessStartQueueService", e);
                        }
                        if (process == null) {
                            LOGGER.error("Problems with getting ProcessStartQueueService", new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS));
                        }
                        try {
                            for (Task task : ControllerProvider.getControllerProvider().getController(TaskControllerInterface.class).getTasksByProcessId(process.getProcessId())) {
                                if (ModelFacade.getInstance().getModel().getTaskDependencies().
                                        stream().allMatch(taskDependency -> taskDependency.isTaskIndependent(task))) {
                                    TaskStartQueueService.getTaskStartQueueService().addTask(task);
                                }
                            }
                        } catch (TaskManagerException e) {
                            LOGGER.error("Problems with getting controller or TaskStartQueueService", e);
                        }
                        process.setStatus(IN_PROGRESS);
                    }
                }
            };
            startProcess.start();
            threads.add(startProcess);
        }
    }


}
