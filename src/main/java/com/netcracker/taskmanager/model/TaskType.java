package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;
import java.io.Serializable;

/**
 * Class of enums describes type of task
 */
@XmlEnum
public enum TaskType implements Serializable {
    /**
     * Java action type
     */
    JAVA_ACTION,
    /**
     * Manual type
     */
    MANUAL
}
