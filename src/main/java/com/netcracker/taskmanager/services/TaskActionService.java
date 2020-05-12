package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.model.Task;

public class TaskActionService implements Runnable{
    private Task taskAction;

    public Task getTaskAction() {
        return taskAction;
    }

    public void setTaskAction(Task taskAction) {
        this.taskAction = taskAction;
    }

    @Override
    public void run() {

    }
}
