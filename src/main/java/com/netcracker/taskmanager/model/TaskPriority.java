package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Class of enums describes priority of task
 */
@XmlEnum
public enum TaskPriority {
    /**
     * Low priority
     */
    LOW(1),
    /**
     * Normal priority
     */
    NORMAL(2),
    /**
     * Major priority
     */
    MAJOR(3),
    /**
     * Critical priority
     */
    CRITICAL(4),
    /**
     * Blocker priority
     */
    BLOCKER(0);

    private final int priority;
    TaskPriority(int priority){
        this.priority = priority;
    }

    public int getTaskPriority() {
        return priority;
    }
}