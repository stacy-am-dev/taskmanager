package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Class of enums describes type of task
 */
@XmlEnum
public enum TaskType{
    /**
     * Action command type
     */
    ACTION_COMMAND,
    /**
     * Default type
     */
    DEFAULT,
    /**
     * Selected type
     */
    SELECTED,
}
