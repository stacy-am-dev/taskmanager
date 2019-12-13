package com.netcracker.taskmanager.model;

/**
 * Class describes task dependencies with such properties as <b>taskIdFrom</b>, <b>taskIdTo</b>
 */
public class TaskDependencies {
    /**
     * Task dependencies from task's identifier
     */
    private long taskIdFrom;
    /**
     * Task dependencies to task's identifier
     */
    private long taskIdTo;

    /**
     * Constructor creates new object with definite values
     * @param taskIdFrom
     * @param taskIdTo
     */
    public TaskDependencies(long taskIdFrom, long taskIdTo){
        this.taskIdFrom = taskIdFrom;
        this.taskIdTo = taskIdTo;
    }

    /**
     * Function receives value of field {@link TaskDependencies#taskIdFrom}
     * @return taskIdFrom
     */
    public long getTaskIdFrom() {
        return taskIdFrom;
    }

    /**
     * Procedure defines value of field {@link TaskDependencies#taskIdFrom}
     * @param taskIdFrom
     */
    public void setTaskIdFrom(long taskIdFrom) {
        this.taskIdFrom = taskIdFrom;
    }

    /**
     * Function receives value of field {@link TaskDependencies#taskIdTo}
     * @return taskIdTo
     */
    public long getTaskIdTo() {
        return taskIdTo;
    }

    /**
     * Procedure defines value of field {@link TaskDependencies#taskIdTo}
     * @param taskIdTo
     */
    public void setTaskIdTo(long taskIdTo) {
        this.taskIdTo = taskIdTo;
    }
}
