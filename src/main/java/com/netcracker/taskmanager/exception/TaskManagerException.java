package com.netcracker.taskmanager.exception;

/**
 * Class describes exception of task manager  with such properties as <b>codeException</b>
 */
public class TaskManagerException extends Exception {
    /**
     * Exception code
     */
    Throwable codeException;
    /**
     * Constructor creates new object
     * @param cause
     */
    public TaskManagerException(Throwable cause) {
        super(cause);
    }
}
