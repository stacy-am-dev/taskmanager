package com.netcracker.taskmanager.exception;

/**
 * Class describes exception of task manager  with such properties as <b>errorCode</b>
 */
public class TaskManagerException extends Exception {
    /**
     * Exception code
     */
    private int errorCode;

    /**
     * Constructor creates new object
     * @param cause
     * @param errorCode
     */
    public TaskManagerException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * Function receives value of field {@link TaskManagerException#errorCode}
     * @return errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }
}
