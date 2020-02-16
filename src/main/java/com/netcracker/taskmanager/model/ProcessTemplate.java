package com.netcracker.taskmanager.model;


import javax.xml.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describes  template of process with such properties as <b>processTemplateId</b>,
 * <b>name</b>, <b>description</b>, <b>parameters</b>.
 *
 * @version 1.0
 */
@XmlRootElement(name = "processTemplate")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessTemplate {
    /**
     * Identifier of process template
     */
    @XmlAttribute(name = "processTemplateId")
    private Long processTemplateId;
    /**
     * Name of process template
     */
    @XmlElement
    private String name;
    /**
     * Description of process template
     */
    @XmlElement
    private String description;
    /**
     * Parameters of process template
     */
    @XmlElement
    private Map<String, String> parameters = new HashMap<String, String>();

    /**
     * Constructor creates new object
     */
    ProcessTemplate() {
    }

    /**
     * Function receives value of field {@link ProcessTemplate#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Procedure defines value of field {@link ProcessTemplate#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function receives value of field {@link ProcessTemplate#description}
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Procedure defines value of field {@link ProcessTemplate#description}
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Function receives value of field {@link ProcessTemplate#parameters}
     *
     * @return parameters
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Procedure defines value of field {@link ProcessTemplate#parameters}
     *
     * @param parameters
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Function receives value of field {@link ProcessTemplate#processTemplateId}
     *
     * @return processTemplateId
     */
    public Long getProcessTemplateId() {
        return processTemplateId;
    }

    /**
     * Procedure defines value of field {@link ProcessTemplate#processTemplateId}
     *
     * @param processTemplateId
     */
    public void setProcessTemplateId(Long processTemplateId) {
        this.processTemplateId = processTemplateId;
    }
}