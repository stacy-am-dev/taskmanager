package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.*;

/**
 * Class describes  rule of  task template with such properties as <b>taskTemplateRuleId</b>, <b>taskTemplateId</b>,
 * <b>name</b>, <b>description</b>,<b>ruleClass</b>, <b>order</b>.
 *
 * @version 1.0
 */
@XmlRootElement(name = "task_template_rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskTemplateRule {
    /**
     * Identifier of task template rule
     */
    @XmlAttribute(name = "task_template_rule_id")
    private Long taskTemplateRuleId;
    /**
     * Identifier of task template
     */
    @XmlElement(name = "task_template_id")
    private Long taskTemplateId;
    /**
     * Name of task template rule
     */
    @XmlElement(name = "name")
    private String name;
    /**
     * Description of task template rule
     */
    @XmlElement(name = "description")
    private String description;
    /**
     * Name of rule class
     */
    @XmlElement(name = "rule_class")
    private String ruleClass;
    /**
     * Number of task template rule
     */
    @XmlElement(name = "order")
    private Integer order;

    /**
     * Constructor creates new object
     */
    TaskTemplateRule() {
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#taskTemplateRuleId}
     *
     * @return taskTemplateRuleId
     */
    public Long getTaskTemplateRuleId() {
        return taskTemplateRuleId;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#taskTemplateRuleId}
     *
     * @param taskTemplateRuleId
     */
    public void setTaskTemplateRuleId(Long taskTemplateRuleId) {
        this.taskTemplateRuleId = taskTemplateRuleId;
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#taskTemplateRuleId}
     *
     * @return taskTemplateRuleId
     */
    public Long getTaskTemplateId() {
        return taskTemplateId;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#taskTemplateId}
     *
     * @param taskTemplateId
     */
    public void setTaskTemplateId(Long taskTemplateId) {
        this.taskTemplateId = taskTemplateId;
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#description}
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#description}
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#ruleClass}
     *
     * @return ruleClass
     */
    public String getRuleClass() {
        return ruleClass;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#ruleClass}
     *
     * @param ruleClass
     */
    public void setRuleClass(String ruleClass) {
        this.ruleClass = ruleClass;
    }

    /**
     * Function receives value of field {@link TaskTemplateRule#order}
     *
     * @return order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Procedure defines value of field {@link TaskTemplateRule#order}
     *
     * @param order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}
