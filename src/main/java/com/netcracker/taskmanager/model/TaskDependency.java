package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Class describes task dependencies with such properties as <b>taskIdFrom</b>, <b>taskIdTo</b>
 */
@XmlRootElement(name = "task_dependency")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDependency implements Serializable {
    /**
     * Task dependencies from task's identifier
     */
    @XmlAttribute(name = "task_id_from")
    private long taskIdFrom;
    /**
     * Task dependencies to task's identifier
     */
    @XmlAttribute(name = "task_id_to")
    private long taskIdTo;

    /**
     * Constructor creates new object with definite values
     * @param taskIdFrom
     * @param taskIdTo
     */
    public TaskDependency(long taskIdFrom, long taskIdTo){
        this.taskIdFrom = taskIdFrom;
        this.taskIdTo = taskIdTo;
    }

    /**
     * Function receives value of field {@link TaskDependency#taskIdFrom}
     * @return taskIdFrom
     */
    public long getTaskIdFrom() {
        return taskIdFrom;
    }

    /**
     * Procedure defines value of field {@link TaskDependency#taskIdFrom}
     * @param taskIdFrom
     */
    public void setTaskIdFrom(long taskIdFrom) {
        this.taskIdFrom = taskIdFrom;
    }

    /**
     * Function receives value of field {@link TaskDependency#taskIdTo}
     * @return taskIdTo
     */
    public long getTaskIdTo() {
        return taskIdTo;
    }

    /**
     * Procedure defines value of field {@link TaskDependency#taskIdTo}
     * @param taskIdTo
     */
    public void setTaskIdTo(long taskIdTo) {
        this.taskIdTo = taskIdTo;
    }

    /**
     *
     * @param taskId
     * @return
     */
    public boolean isTaskDependsOnAnotherTask(Long taskId) {
            return this.taskIdFrom == taskId;
    }

    /**
     *
     * @param taskId
     * @return
     */
    public boolean IsAnotherTaskDependsOnThisTask(Long taskId) {
        return this.taskIdTo == taskId;
    }

}
