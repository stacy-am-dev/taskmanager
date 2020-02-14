package com.netcracker.taskmanager.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describes  template of task with such properties as <b>taskTemplateId</b>,
 * <b>name</b>, <b>description</b>, <b>parameters</b>.
 *
 * @version 1.0
 */
@XmlRootElement(name = "taskTemplate")
public class TaskTemplate {
    /**
     * Identifier of task template
     */
    @XmlAttribute(name = "taskTemplateId")
    private Long taskTemplateId;
    /**
     * Name of task template
     */
    @XmlElement
    private String name;
    /**
     * Description of task template
     */
    private String description;
    /**
     * Parameters of task template
     */
    private Map<String, String> parameters = new HashMap<>();

    /**
     * Constructor creates new object
     */
    public TaskTemplate() {
    }

    /**
     * Procedure defines value of parameter
     *
     * @param key
     * @param value
     */
    public void setParameter(String key, String value) {
        parameters.put(key, value);
    }

    /**
     * Function receives value of parameter
     *
     * @return parameters.get(key)
     */
    public String getParameter(String key) {
        return parameters.get(key);
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
}
