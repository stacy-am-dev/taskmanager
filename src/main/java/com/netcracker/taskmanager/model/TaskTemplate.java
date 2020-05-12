package com.netcracker.taskmanager.model;


import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Class describes  template of task with such properties as <b>taskTemplateId</b>,
 * <b>name</b>, <b>description</b>,<b>expectationExecutionTime</b>, <b>parameters</b>.
 *
 * @version 1.0
 */
@XmlRootElement(name = "task_template")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskTemplate implements Serializable {
    /**
     * Identifier of task template
     */
    @XmlAttribute(name = "task_template_id")
    private Long taskTemplateId;
    /**
     * Name of task template
     */
    @XmlElement(name = "name")
    private String name;
    /**
     * Description of task template
     */
    @XmlElement(name = "description")
    private String description;
    /**
     *Expected execution time
     */
    @XmlElement(name = "expectation_execution_time")
    private Duration expectationExecutionTime;

    /**
     *Type of task
     */
    @XmlElement(name = "task_type")
    private TaskType taskType;
    /**
     *Priority of task
     */
    @XmlElement(name = "task_priority")
    private TaskPriority taskPriority;
    /**
     * Necessary skills for task execution
     */
    @XmlElement(name = "skills")
    private Map<Long, Integer> skills = new HashMap<>();
    /**
     * Parameters of task template
     */
    @XmlElement(name = "parameters")
    private Map<String, String> parameters = new HashMap<>();

    /**
     * Constructor creates new object
     */
    public TaskTemplate() {
    }

    /**
     * Function receives value of field {@link TaskTemplate#taskTemplateId}
     *
     * @return taskTemplateId
     */
    public Long getTaskTemplateId() {
        return taskTemplateId;
    }

    /**
     * Procedure defines value of field {@link TaskTemplate#taskTemplateId}
     *
     * @param taskTemplateId
     */
    public void setTaskTemplateId(Long taskTemplateId) {
        this.taskTemplateId = taskTemplateId;
    }

    /**
     * Function receives value of field {@link TaskTemplate#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Procedure defines value of field {@link TaskTemplate#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function receives value of field {@link TaskTemplate#description}
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Procedure defines value of field {@link TaskTemplate#description}
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Function receives value of field {@link TaskTemplate#parameters}
     *
     * @return parameters
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Procedure defines value of field {@link TaskTemplate#parameters}
     *
     * @param parameters
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Function receives value of field {@link TaskTemplate#expectationExecutionTime}
     *
     * @return expectationExecutionTime
     */
    public Duration getExpectationExecutionTime() {
        return expectationExecutionTime;
    }

    /**
     * Procedure defines value of field {@link TaskTemplate#expectationExecutionTime}
     *
     * @param expectationExecutionTime
     */
    public void setExpectationExecutionTime(Duration expectationExecutionTime) {
        this.expectationExecutionTime = expectationExecutionTime;
    }

    /**
     * Function receives value of field {@link TaskTemplate#skills}
     *
     * @return skills
     */
    public Map<Long, Integer> getSkills() {
        return skills;
    }
    /**
     * Procedure defines value of field {@link TaskTemplate#skills}
     *
     * @param skills
     */
    public void setSkills(Map<Long, Integer> skills) {
        this.skills = skills;
    }

    /**
     * Function receives value of field {@link TaskTemplate#taskType}
     *
     * @return taskType
     */
    public TaskType getTaskType() {
        return taskType;
    }
    /**
     * Procedure defines value of field {@link TaskTemplate#taskType}
     *
     * @param taskType
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * Function receives value of field {@link TaskTemplate#taskPriority}
     *
     * @return taskPriority
     */
    public TaskPriority getTaskPriority() {
        return taskPriority;
    }
    /**
     * Procedure defines value of field {@link TaskTemplate#taskPriority}
     *
     * @param taskPriority
     */
    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }
}
