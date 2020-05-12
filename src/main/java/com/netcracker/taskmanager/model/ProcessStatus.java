package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlEnum;
import java.io.Serializable;

@XmlEnum
public enum ProcessStatus implements Serializable {
    PLANNING, PLANNED, IN_PROGRESS, ERROR, CANCELLED, COMPLETED
}
