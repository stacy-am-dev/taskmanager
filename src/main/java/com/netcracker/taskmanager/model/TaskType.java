package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Class of enums describes type of task
 */
@XmlEnum
public enum TaskType{
    /**
     * Java action type
     */
    JAVA_ACTION,
    /**
     * Manual type
     */
    MANUAL
}
