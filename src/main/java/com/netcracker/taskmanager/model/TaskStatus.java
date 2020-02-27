package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Class of enums describes status of task
 */
@XmlEnum
public enum TaskStatus{
    /**
     * Planing status
     */
    PLANNING,
    /**
     * Planned status
     */
    PLANNED,
    /**
     * Not started status
     */
    NOT_STARTED,
    /**
     * Status in progress
     */
    IN_PROGRESS,
    /**
     * Error status
     */
    ERROR,
    /**
     * Waiting status
     */
    WAITING,
    /**
     * Cancelled status
     */
    CANCELLED,
    /**
     * Completed status
     */
    COMPLETED,
}
