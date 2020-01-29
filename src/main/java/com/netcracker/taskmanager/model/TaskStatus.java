package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Class of enums describes status of task
 */
@XmlEnum
public enum TaskStatus{
    /**
     * Free status
     */
    FREE,
    /**
     * Occupied status
     */
    OCCUPIED,
    /**
     * Started status
     */
    STARTED,
    /**
     * Status in progress
     */
    IN_PROGRESS,
    /**
     * Waiting status
     */
    WAITING,
    /**
     * Delayed status
     */
    DELAYED,
    /**
     * Finished status
     */
    FINISHED,
}
