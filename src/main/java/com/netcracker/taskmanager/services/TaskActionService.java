package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.Task;

public abstract class TaskActionService{

    protected void start(Process process, Task task) throws TaskManagerException {
        run(process,task);
    }

    public abstract void run(Process process, Task task) throws TaskManagerException;
}
