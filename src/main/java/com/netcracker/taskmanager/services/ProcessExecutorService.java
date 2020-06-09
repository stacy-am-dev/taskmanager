package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.controller.TaskControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.util.ControllerProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;

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
            StartProcess startProcess = new StartProcess();
            startProcess.start();
            threads.add(startProcess);
        }
    }

    public class StartProcess extends Thread {
        @Override
        public void start() {
            while (true) {
                Process process = null;
                try {
                    process = ProcessStartQueueService.getProcessStartQueueService().getProcess();
                } catch (TaskManagerException e) {
                    LOGGER.error("Problems with getting ProcessStartQueueService", e);
                }
                try {
                    if (process != null) {
                        for (Task task : ControllerProvider.getControllerProvider().getController(TaskControllerInterface.class).getTasksByProcessId(process.getProcessId())) {
                            {
                                if (ControllerProvider.getControllerProvider().getController(TaskControllerInterface.class).getTasksThatTaskDependsOnByTaskId(task.getTaskId()) == null) {
                                    TaskStartQueueService.getTaskStartQueueService().addTask(task);
                                }
                            }
                        }
                        process.setStatus(IN_PROGRESS);
                    }
                    else throw new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS);
                } catch (TaskManagerException e) {
                    LOGGER.error("Problems with getting controller or TaskStartQueueService", e);
                }

            }
        }
    }

}