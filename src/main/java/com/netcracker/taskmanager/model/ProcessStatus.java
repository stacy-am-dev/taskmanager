package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ProcessStatus {
    PLANNING, PLANNED, IN_PROGRESS, ERROR, CANCELLED, COMPLETED
}
