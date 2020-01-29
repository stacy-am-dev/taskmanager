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
    LOW,
    /**
     * Normal priority
     */
    NORMAL,
    /**
     * Major priority
     */
    MAJOR,
    /**
     * Critical priority
     */
    CRITICAL,
    /**
     * Blocker priority
     */
    BLOCKER
}