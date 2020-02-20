package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.model.Task;

public class Comparator implements java.util.Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return Integer.compare(o2.getPriority().getTaskPriority(), o1.getPriority().getTaskPriority());
    }
}
